package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
import java.sql.*;
public class VendorDAO implements VendorDAOInterface
{

//tested
	public void add(VendorInterface vendorInterface,Connection connection) throws DAOException
	{
		boolean closeConnection=false;	

		try
		{
		if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
		if(existsByName(vendorInterface.getName(),connection))
		{
		throw new DAOException("VendorDAO : add() Name :" +vendorInterface.getName()+" already exists");
		}
		if(existsByUsername(vendorInterface.getUsername(),connection))
		{
		throw new DAOException("VendorDAO : add() Username:" +vendorInterface.getUsername()+" already exists");
		}
		if(existsByEmailId(vendorInterface.getEmailId(),connection))
		{
		throw new DAOException("VendorDAO : add() Email :" +vendorInterface.getEmailId()+" already exists");
		}
		if(existsByContactNumber(vendorInterface.getContactNumber(),connection))
		{
		throw new DAOException("VendorDAO : add() --> Vendor with same contactNumber Already Exists");
		}
		if(!(new CityDAO().exists(vendorInterface.getCityCode(),connection)))
		{	
		throw new DAOException("VendorDAO : add() invalid city code : " + vendorInterface.getCityCode());	
		}
		String job="{ call add_vendor(?,?,?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setString(1,vendorInterface.getName());
		callableStatement.setString(2,vendorInterface.getUsername());
		callableStatement.setString(3,vendorInterface.getPasswordKey());
		callableStatement.setString(4,vendorInterface.getPassword());
		callableStatement.setInt(5,vendorInterface.getCityCode());
		callableStatement.setString(6,vendorInterface.getAddress());
		callableStatement.setString(7,vendorInterface.getEmailId());
		callableStatement.setString(8,vendorInterface.getContactNumber());
		callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
		//callableStatement.setString(10,);
		callableStatement.execute();
		//int code=callableStatement.getInt(4);
		callableStatement.close();
		//System.out.println(code);
		if(closeConnection)
		{
			connection.close();
		}
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : add() " + exception.getMessage());
		}
	}

//tested
	public void update(VendorInterface vendorInterface,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}			
			if(!exists(vendorInterface.getCode(),connection))
			{
			throw new DAOException("VendorDAO : update() --> Invalid vendor Code :"+vendorInterface.getCode());
			}

			VendorInterface vVendorInterface;
			boolean valid=true;
			try
			{
			vVendorInterface = getByName(vendorInterface.getName(),connection);				
			if(vendorInterface.getCode()!=vVendorInterface.getCode())
			{
				valid=false;
				
			}
			}
			catch(Exception exception)
			{
				
			}
			if(!valid)
			{
				throw new DAOException("VendorDAO : update() --> vendor with same name already exists :"+vendorInterface.getName());
			}

			valid=true;
			try
			{
			vVendorInterface = getByContactNumber(vendorInterface.getContactNumber(),connection);		
			if(vendorInterface.getCode()!=vVendorInterface.getCode())
			{
				valid=false;
				
			}}
			catch(Exception exception)
			{
		
			}
			if(!valid)
			{
			throw new DAOException("VendorDAO : update() phone number already exists "+vendorInterface.getContactNumber());		
			}

			valid=true;
			try
			{
			vVendorInterface= getByEmailId(vendorInterface.getEmailId(),connection);
			if(vendorInterface.getCode()!=vVendorInterface.getCode())
			{
				valid=false;
				
			}}
			catch(Exception exception)
			{

			}
			if(!valid)
			{
			throw new DAOException("VendorDAO : update() --> Vendor with same email id Already Exists : "+vendorInterface.getEmailId());		
			}			
			
			if(!(new CityDAO().exists(vendorInterface.getCityCode(),connection)))
			{
			throw new DAOException("VendorDAO : update() invalid city code : " + vendorInterface.getCityCode());	
			}
			String job="{ call update_vendor(?,?,?,?,?,?,?,?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,vendorInterface.getCode());
			callableStatement.setString(2,vendorInterface.getName());
			callableStatement.setString(3,vendorInterface.getUsername());
			callableStatement.setString(4,vendorInterface.getPasswordKey());
			callableStatement.setString(5,vendorInterface.getPassword());
			callableStatement.setInt(6,vendorInterface.getCityCode());
			callableStatement.setString(7,vendorInterface.getAddress());
			callableStatement.setString(8,vendorInterface.getEmailId());
			callableStatement.setString(9,vendorInterface.getContactNumber());
			callableStatement.execute();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : update() " + exception.getMessage());
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
		if(closeConnection)
		{
		connection.close();
		}
		}		
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : remove() " + exception.getMessage());
		}
	}


	






	public void removeAll(Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			if(closeConnection)
			{
			connection.close();
			}
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : removeAll() " + exception.getMessage());
		}
	}


//tested
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
			String job="{ call get_vendor_count(?) }";
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
			throw new DAOException("VendorDAO : getCount() " + exception.getMessage());
		}

	}


public long getCountByCity(int cityCode,Connection connection) throws DAOException
{

	boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_count_by_city(?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,cityCode);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callableStatement.execute();
			long count=callableStatement.getInt(2);
			callableStatement.close();
			if(closeConnection)
			{
			connection.close();
			}
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getCountByCity() " + exception.getMessage());
		}


}

//tested
	public ArrayList<VendorInterface> getAll(Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_all_vendors() }";
			CallableStatement callableStatement=connection.prepareCall(job);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getAll() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getAll() --> No records ");
			}

			ArrayList<VendorInterface> vendors;
			vendors=new ArrayList<VendorInterface>();
			VendorInterface vendorInterface; 
			do
			{
			vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			vendors.add(vendorInterface);
			}while(resultSet.next());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
			connection.close();
			}
			return vendors;


		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getAll() " + exception.getMessage());
		}

	}

//tested
public VendorInterface getByCode(int code,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByCode() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByCode() --> Invalid Code "+code);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByPrimaryKey() " + exception.getMessage());
		}

	}
	

	//tested
		public VendorInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByContactNumber() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByContactNumber() --> Invalid contactNumber " + contactNumber);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByContactNumber() " + exception.getMessage());
		}

	}

//tested
	public VendorInterface getByEmailId(String emailId,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_by_mail_id(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,emailId);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByEmailId() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByEmailId() --> Invalid emailId "+ emailId);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByEmailId() "+exception.getMessage());			
		}
	}


//tested
	public VendorInterface getByUsername(String username,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
				{
				connection=DAOConnection.getConnection();	
				closeConnection=true;
				}
			String job="{ call get_vendor_by_username(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,username);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByUsername() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByUsername() --> Invalid Username "+username);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByUsername() "+exception.getMessage());			
		}
	}

//tested
	public VendorInterface getByName(String name,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_by_name_of_firm(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,name);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByName() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByName() --> Invalid name "+name);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			vendorInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorInterface.setPassword(resultSet.getString("password").trim());
			resultSet.close();
			callableStatement.close();
			if(closeConnection)
			{
				connection.close();
			}
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByName() "+exception.getMessage());			
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
			String job="{ call vendor_exists_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO :exists() --> No records in generated result");
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
			throw new DAOException("VendorDAO : exists() " + exception.getMessage());
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
			String job="{ call vendor_exists_by_username(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,username);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO :existsByUsername() --> No records in generated result");
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
			throw new DAOException("VendorDAO : existsByUsername() " + exception.getMessage());
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
			String job="{ call vendor_exists_by_name_of_firm(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,name);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO :existsByName() --> No records in generated result");
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
			throw new DAOException("VendorDAO : existsByName() " + exception.getMessage());
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
			String job="{ call vendor_exists_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO :existsByContactNumber() --> No records in generated result");
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
			throw new DAOException("VendorDAO : existsByContactNumber() " + exception.getMessage());
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
			String job="{ call vendor_exists_by_mail_id(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,emailId);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO :existsByEmailId() --> No records in generated result");
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
			throw new DAOException("VendorDAO : existsByEmailId() " + exception.getMessage());
		}

	}



}

