package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
import java.sql.*;
public class VendorDAO implements VendorDAOInterface
{
	public void add(VendorInterface vendorInterface) throws DAOException
	{
		try
		{
		if(existsByUsername(vendorInterface.getName()))
		{
		throw new DAOException("VendorDAO : add() " +vendorInterface.getName()+" already exists");
		}
		if(existsByEmailId(vendorInterface.getEmailId()))
		{
		throw new DAOException("VendorDAO : add() " +vendorInterface.getEmailId()+" already exists");
		}
		if(!(new CityDAO().exists(vendorInterface.getCityCode())))
		{	
		throw new DAOException("VendorDAO : add() invalid city code : " + vendorInterface.getCityCode());	
		}
		Connection connection=DAOConnection.getConnection();
		String job="{ call add_vendor(?,?,?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setString(1,vendorInterface.getName());
		callableStatement.setString(2,vendorInterface.getUsername());
		callableStatement.setString(3,vendorInterface.getPasswordKey());
		callableStatement.setString(4,vendorInterface.getPassword());
		callableStatement.setInt(5,vendorInterface.getCityCode());
		callableStatement.setString(6,vendorInterface.getAddress());
		callableStatement.setString(7,vendorInterface.getEmailId());
		String contactNumbersString="";
		int x=0;
		ArrayList<String> contactNumbers=vendorInterface.getContactNumbers();
		int s=contactNumbers.size();
		while(x<s)
		{
			if(x>0)
			{
			contactNumbersString=contactNumbersString + "#";	
			}
			contactNumbersString=contactNumbersString + contactNumbers.get(x);
		x++;
		}
		callableStatement.setString(8,contactNumbersString);
		callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
		callableStatement.execute();
		//int code=callableStatement.getInt(4);
		callableStatement.close();
		//System.out.println(code);
		connection.close();
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : add() " + exception.getMessage());
		}
	}


	public void update(VendorInterface vendorInterface) throws DAOException
	{
		try
		{
			if(!exists(vendorInterface.getCode()))
			{
			throw new DAOException("VendorDAO : update() --> Invalid vendor Code :"+vendorInterface.getCode());
			}
			if(getCountByUsername(vendorInterface.getUsername())>1)
			{
			throw new DAOException("VendorDAO : update() --> Vendor with same username Already Exists");
			}
			if(existsByEmailId(vendorInterface.getEmailId()))
			{
			throw new DAOException("VendorDAO : add() " +vendorInterface.getEmailId()+" already exists");
			}
				if(!(new CityDAO().exists(vendorInterface.getCityCode())))
			{
			throw new DAOException("VendorDAO : update() invalid city code : " + vendorInterface.getCityCode());	
			}
			Connection connection=DAOConnection.getConnection();
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
			String contactNumbersString="";
			int x=0;
			ArrayList<String> contactNumbers=vendorInterface.getContactNumbers();
			int s=contactNumbers.size();
			while(x<s)
			{
				if(x>0)
				{
				contactNumbersString=contactNumbersString + "#";	
				}
				contactNumbersString=contactNumbersString + contactNumbers.get(x);
			}
			callableStatement.setString(9,contactNumbersString);
			callableStatement.execute();
			callableStatement.close();
			connection.close();
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : update() " + exception.getMessage());
		}
	}


	public void remove(int code) throws DAOException
	{
		try
		{
		
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : remove() " + exception.getMessage());
		}
	}


	public VendorInterface getByCode(int code) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
			String job="{ call get_vendor_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorDAO : getByPrimaryKey() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorDAO : getByPrimaryKey() --> Invalid Code "+code);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			String contactNumbersString = resultSet.getString("contact_numbers").trim();
			String[] numbers=contactNumbersString.split("#");
			ArrayList<String> contactNumbers=new ArrayList<String>();
			int x=0;
			int l=numbers.length;
			while(x<l)
			{
				contactNumbers.add(numbers[x]);
			}
			vendorInterface.setContactNumbers(contactNumbers);
			vendorInterface.setPassword(resultSet.getString("password").trim());
			callableStatement.close();
			connection.close();
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByPrimaryKey() " + exception.getMessage());
		}

	}



	public void removeAll() throws DAOException
	{
		try
		{


		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : removeAll() " + exception.getMessage());
		}
	}



	public boolean exists(int code) throws DAOException
	{
		try
		{
			boolean exists=false;
			Connection connection=DAOConnection.getConnection();
			String job="{ call vendor_exists_by_primary_key(?) }";
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
			connection.close();
			return exists;

		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : exists() " + exception.getMessage());
		}

	}


	public ArrayList<VendorInterface> getAll() throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
			String contactNumbersString = resultSet.getString("contact_numbers").trim();
			String[] numbers=contactNumbersString.split("#");
			ArrayList<String> contactNumbers=new ArrayList<String>();
			int x=0;
			int l=numbers.length;
			while(x<l)
			{
				contactNumbers.add(numbers[x]);
			}
			vendorInterface.setContactNumbers(contactNumbers);
			vendorInterface.setPassword(resultSet.getString("password").trim());
			vendors.add(vendorInterface);
			}while(resultSet.next());
			resultSet.close();
			connection.close();
			return vendors;


		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getAll() " + exception.getMessage());
		}

	}


	public long getCount() throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
			String job="{ call get_vendor_count(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.execute();
			long count=callableStatement.getInt(1);
			callableStatement.close();
			connection.close();
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getCount() " + exception.getMessage());
		}

	}


	public int getCountByUsername(String username) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
			String job="{ call get_vendor_count_by_username(?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,username);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callableStatement.execute();
			int count=callableStatement.getInt(2);
			callableStatement.close();
			connection.close();
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getCountByUsername() " + exception.getMessage());
		}

	}

	public VendorInterface getByEmailId(String emailId) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
				throw new DAOException("VendorDAO : getByEmailId() --> Invalid emailId "+emailId);
			}
			VendorInterface vendorInterface = new Vendor();
			vendorInterface.setCode(resultSet.getInt("code"));
			vendorInterface.setCityCode(resultSet.getInt("city_code"));
			vendorInterface.setName(resultSet.getString("name_of_firm").trim());
			vendorInterface.setEmailId(resultSet.getString("mail_id").trim());
			vendorInterface.setUsername(resultSet.getString("username").trim());
			vendorInterface.setAddress(resultSet.getString("address").trim());
			vendorInterface.setPasswordKey(resultSet.getString("password_key").trim());
			String contactNumbersString = resultSet.getString("contact_numbers").trim();
			String[] numbers=contactNumbersString.split("#");
			ArrayList<String> contactNumbers=new ArrayList<String>();
			int x=0;
			int l=numbers.length;
			while(x<l)
			{
				contactNumbers.add(numbers[x]);
			x++;
			}
			vendorInterface.setContactNumbers(contactNumbers);
			vendorInterface.setPassword(resultSet.getString("password").trim());
			callableStatement.close();
			connection.close();
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByEmailId() "+exception.getMessage());			
		}
	}

	public VendorInterface getByUsername(String username) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
			String contactNumbersString = resultSet.getString("contact_numbers").trim();
			String[] numbers=contactNumbersString.split("#");
			ArrayList<String> contactNumbers=new ArrayList<String>();
			int x=0;
			int l=numbers.length;
			while(x<l)
			{
				contactNumbers.add(numbers[x]);
			x++;
			}
			vendorInterface.setContactNumbers(contactNumbers);
			vendorInterface.setPassword(resultSet.getString("password").trim());
			callableStatement.close();
			connection.close();
			return vendorInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : getByUsername() "+exception.getMessage());			
		}
	}


	public boolean existsByUsername(String username) throws DAOException
	{
		try
		{
			boolean exists=false;
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : existsByUsername() " + exception.getMessage());
		}

	}

	public boolean existsByEmailId(String emailId) throws DAOException
	{
		try
		{
			boolean exists=false;
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : existsByEmailId() " + exception.getMessage());
		}

	}

}

