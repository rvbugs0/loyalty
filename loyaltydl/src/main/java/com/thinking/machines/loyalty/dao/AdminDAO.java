package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
import java.sql.*;
public class AdminDAO implements AdminDAOInterface
{

//tested
	public void add(AdminInterface adminInterface,Connection connection) throws DAOException
	{
		boolean closeConnection=false;	

		try
		{
		if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
		if(existsByName(adminInterface.getName(),connection))
		{
		throw new DAOException("AdminDAO : add() Name :" +adminInterface.getName()+" already exists");
		}
		if(existsByUsername(adminInterface.getUsername(),connection))
		{
		throw new DAOException("AdminDAO : add() Username:" +adminInterface.getUsername()+" already exists");
		}
		if(existsByEmailId(adminInterface.getEmailId(),connection))
		{
		throw new DAOException("AdminDAO : add() Email :" +adminInterface.getEmailId()+" already exists");
		}
		if(existsByContactNumber(adminInterface.getContactNumber(),connection))
		{
		throw new DAOException("AdminDAO : add() --> Admin with same contactNumber Already Exists");
		}
		String job="{ call add_admin(?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setString(1,adminInterface.getName());
		callableStatement.setString(2,adminInterface.getUsername());
		callableStatement.setString(3,adminInterface.getPassword());
		callableStatement.setString(4,adminInterface.getPasswordKey());
		callableStatement.setString(5,adminInterface.getEmailId());
		callableStatement.setString(6,adminInterface.getContactNumber());
		callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
		callableStatement.execute();
		int code=callableStatement.getInt(7);
		callableStatement.close();
		//System.out.println(code);
		if(closeConnection)
		{
			connection.close();
		}
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : add() " + exception.getMessage());
		}
	}

//tested
	public void update(AdminInterface adminInterface,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}			
			if(!exists(adminInterface.getCode(),connection))
			{
			throw new DAOException("AdminDAO : update() --> Invalid admin Code :"+adminInterface.getCode());
			}

			AdminInterface vAdminInterface;
			boolean valid=true;
			try
			{
			vAdminInterface = getByName(adminInterface.getName(),connection);				
			if(adminInterface.getCode()!=vAdminInterface.getCode())
			{
				valid=false;
				
			}
			}
			catch(Exception exception)
			{
				
			}
			if(!valid)
			{
				throw new DAOException("AdminDAO : update() --> admin with same name already exists :"+adminInterface.getName());
			}

			valid=true;
			try
			{
			vAdminInterface = getByContactNumber(adminInterface.getContactNumber(),connection);		
			if(adminInterface.getCode()!=vAdminInterface.getCode())
			{
				valid=false;
				
			}}
			catch(Exception exception)
			{
		
			}
			if(!valid)
			{
			throw new DAOException("AdminDAO : update() phone number already exists "+adminInterface.getContactNumber());		
			}

			valid=true;
			try
			{
			vAdminInterface= getByEmailId(adminInterface.getEmailId(),connection);
			if(adminInterface.getCode()!=vAdminInterface.getCode())
			{
				valid=false;
				
			}}
			catch(Exception exception)
			{

			}
			if(!valid)
			{
			throw new DAOException("AdminDAO : update() --> Admin with same email id Already Exists : "+adminInterface.getEmailId());		
			}			
			
			String job="{ call update_admin(?,?,?,?,?,?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,adminInterface.getCode());
			callableStatement.setString(2,adminInterface.getName());
			callableStatement.setString(3,adminInterface.getUsername());
			callableStatement.setString(4,adminInterface.getPassword());
			callableStatement.setString(5,adminInterface.getPasswordKey());
			callableStatement.setString(6,adminInterface.getEmailId());
			callableStatement.setString(7,adminInterface.getContactNumber());
			callableStatement.execute();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : update() " + exception.getMessage());
		}
	}


	public void remove(int code,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
		if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;			
		}
		if(!exists(code,connection))
		{
			throw new DAOException("AdminDAO : remove() Invalid admin code "+code);			
		}
		
		String job="{ call remove_admin(?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setInt(1,code);
		callableStatement.execute();
		callableStatement.close();
		if(closeConnection)
		{
		connection.close();
		}				
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : remove() " + exception.getMessage());
		}
	}


	






		public long getCount(Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_admin_count(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.execute();
			long count=callableStatement.getInt(1);
			callableStatement.close();
			if(closeConnection)
			{
			connection.close();
			}
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getCount() " + exception.getMessage());
		}

	}






public AdminInterface getByCode(int code,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_admin_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO : getByCode() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				if(closeConnection)
{
	connection.close();
}
				throw new DAOException("AdminDAO : getByCode() --> Invalid Code "+code);
			}
			AdminInterface adminInterface = new Admin();
			adminInterface.setCode(resultSet.getInt("code"));
			adminInterface.setName(resultSet.getString("name").trim());
			adminInterface.setEmailId(resultSet.getString("mail_id").trim());
			adminInterface.setUsername(resultSet.getString("username").trim());
			adminInterface.setPasswordKey(resultSet.getString("password_key").trim());
			adminInterface.setContactNumber(resultSet.getString("contact_number").trim());
			adminInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return adminInterface;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getByPrimaryKey() " + exception.getMessage());
		}

	}
	

	//tested
		public AdminInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_admin_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO : getByContactNumber() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				if(closeConnection)
{
	connection.close();
}
				throw new DAOException("AdminDAO : getByContactNumber() --> Invalid contactNumber " + contactNumber);
			}
			AdminInterface adminInterface = new Admin();
			adminInterface.setCode(resultSet.getInt("code"));
			adminInterface.setName(resultSet.getString("name").trim());
			adminInterface.setEmailId(resultSet.getString("mail_id").trim());
			adminInterface.setUsername(resultSet.getString("username").trim());
			adminInterface.setPasswordKey(resultSet.getString("password_key").trim());
			adminInterface.setContactNumber(resultSet.getString("contact_number").trim());
			adminInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return adminInterface;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getByContactNumber() " + exception.getMessage());
		}

	}

//tested
	public AdminInterface getByEmailId(String emailId,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_admin_by_mail_id(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,emailId);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO : getByEmailId() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				if(closeConnection)
{
	connection.close();
}
				throw new DAOException("AdminDAO : getByEmailId() --> Invalid emailId "+ emailId);
			}
			AdminInterface adminInterface = new Admin();
			adminInterface.setCode(resultSet.getInt("code"));
			adminInterface.setName(resultSet.getString("name").trim());
			adminInterface.setEmailId(resultSet.getString("mail_id").trim());
			adminInterface.setUsername(resultSet.getString("username").trim());
			adminInterface.setPasswordKey(resultSet.getString("password_key").trim());
			adminInterface.setContactNumber(resultSet.getString("contact_number").trim());
			adminInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return adminInterface;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getByEmailId() "+exception.getMessage());			
		}
	}


//tested
	public AdminInterface getByUsername(String username,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
				{
				connection=DAOConnection.getConnection();	
				closeConnection=true;
				}
			String job="{ call get_admin_by_username(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,username);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO : getByUsername() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				if(closeConnection)
{
	connection.close();
}
				throw new DAOException("AdminDAO : getByUsername() --> Invalid Username "+username);
			}
			AdminInterface adminInterface = new Admin();
			adminInterface.setCode(resultSet.getInt("code"));
			adminInterface.setName(resultSet.getString("name").trim());
			adminInterface.setEmailId(resultSet.getString("mail_id").trim());
			adminInterface.setUsername(resultSet.getString("username").trim());
			adminInterface.setPasswordKey(resultSet.getString("password_key").trim());
			adminInterface.setContactNumber(resultSet.getString("contact_number").trim());
			adminInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return adminInterface;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getByUsername() "+exception.getMessage());			
		}
	}

//tested
	public AdminInterface getByName(String name,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_admin_by_name(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,name);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO : getByName() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				if(closeConnection)
{
	connection.close();
}
				throw new DAOException("AdminDAO : getByName() --> Invalid name "+name);
			}
			AdminInterface adminInterface = new Admin();
			adminInterface.setCode(resultSet.getInt("code"));
			adminInterface.setName(resultSet.getString("name").trim());
			adminInterface.setEmailId(resultSet.getString("mail_id").trim());
			adminInterface.setUsername(resultSet.getString("username").trim());
			adminInterface.setPasswordKey(resultSet.getString("password_key").trim());
			adminInterface.setContactNumber(resultSet.getString("contact_number").trim());
			adminInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return adminInterface;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : getByName() "+exception.getMessage());			
		}
	}

//tested
	public boolean exists(int code,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			boolean exists=false;
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call admin_exists_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO :exists() --> No records in generated result");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			exists=resultSet.next();
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return exists;

		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : exists() " + exception.getMessage());
		}

	}


//tested
	public boolean existsByUsername(String username,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			boolean exists=false;
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call admin_exists_by_username(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,username);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO :existsByUsername() --> No records in generated result");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			exists=resultSet.next();
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : existsByUsername() " + exception.getMessage());
		}

	}

//tested
	public boolean existsByName(String name,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			boolean exists=false;
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call admin_exists_by_name(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,name);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO :existsByName() --> No records in generated result");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			exists=resultSet.next();
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : existsByName() " + exception.getMessage());
		}

	}

//tested
	public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			boolean exists=false;
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call admin_exists_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO :existsByContactNumber() --> No records in generated result");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			exists=resultSet.next();
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : existsByContactNumber() " + exception.getMessage());
		}

	}

//tested
	public boolean existsByEmailId(String emailId,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			boolean exists=false;
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call admin_exists_by_mail_id(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,emailId);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			if(closeConnection)
{
	connection.close();
}
			throw new DAOException("AdminDAO :existsByEmailId() --> No records in generated result");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			exists=resultSet.next();
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("AdminDAO : existsByEmailId() " + exception.getMessage());
		}

	}



}

