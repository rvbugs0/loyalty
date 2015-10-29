package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;
public class VendorOutletDAO implements VendorOutletDAOInterface
{
	//tested-unique constraint fails for latitude and longitude
	public void add(VendorOutletInterface vendorOutletInterface,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
		try
		{
		if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
		if(!(new CityDAO().exists(vendorOutletInterface.getCityCode(),connection)))
		{	
		throw new DAOException("VendorOutletDAO : add() invalid city code : " + vendorOutletInterface.getCityCode());	
		}
		if(!(new VendorDAO().exists(vendorOutletInterface.getVendorCode(),connection)))
		{	
		throw new DAOException("VendorOutletDAO : add() invalid vendor code : " + vendorOutletInterface.getVendorCode());	
		}
		if(existsByCoordinates(vendorOutletInterface.getLatitude(),vendorOutletInterface.getLongitude(),connection))
		{
		throw new DAOException("VendorOutletDAO : add() Outlet exists with same Coordinates: " + vendorOutletInterface.getLatitude()+" , " + vendorOutletInterface.getLongitude());	
		}
		if(existsByContactNumber(vendorOutletInterface.getContactNumber(),connection))
		{
				throw new DAOException("VendorOutletDAO : add() Outlet exists with same Contact Number: " + vendorOutletInterface.getContactNumber());	
		}


		String job="{ call add_vendor_outlet(?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setInt(1,vendorOutletInterface.getVendorCode());
		callableStatement.setString(2,vendorOutletInterface.getAddress());
		callableStatement.setString(3,vendorOutletInterface.getLatitude());
		callableStatement.setString(4,vendorOutletInterface.getLongitude());
		callableStatement.setInt(5,vendorOutletInterface.getCityCode());
		callableStatement.setString(6,vendorOutletInterface.getContactNumber());
		callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
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
			throw new DAOException("VendorOutletDAO : add() "+exception.getMessage());
		}
	}
	

	//tested
	public boolean existsByCoordinates(String latitude,String longitude,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			boolean exists=false;
			
			String job="{ call vendor_outlet_exists_by_coordinates(?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,latitude);
			callableStatement.setString(2,longitude);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO :existsByCoordinates() --> No records in generated result");
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
			throw new DAOException("VendorDAO : existsByCoordinates() " + exception.getMessage());
		}

	}

	//tested
	public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException
	{
		boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			boolean exists=false;
			
			String job="{ call vendor_outlet_exists_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO :existsByContactNumber() --> No records in generated result");
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
	public VendorOutletInterface getByCoordinates(String latitude,String longitude,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_outlet_by_coordinates(?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,latitude);
			callableStatement.setString(2,longitude);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO : getByCoordinates() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorOutletDAO : getByCoordinates() --> Invalid Coordinates "+ latitude +" , "+longitude);
			}
			VendorOutletInterface vendorOutletInterface = new VendorOutlet();
			vendorOutletInterface.setCode(resultSet.getInt("code"));
			vendorOutletInterface.setVendorCode(resultSet.getInt("vendor_code"));
			vendorOutletInterface.setCityCode(resultSet.getInt("city_code"));
			vendorOutletInterface.setAddress(resultSet.getString("address").trim());
			vendorOutletInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorOutletInterface.setLatitude(resultSet.getString("latitude").trim());
			vendorOutletInterface.setLongitude(resultSet.getString("longitude").trim());
			resultSet.close();
			callableStatement.close();
if(closeConnection)
{
	connection.close();
}
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCoordinates() "+exception.getMessage());
		}	
	}

//tested
	public VendorOutletInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_outlet_by_contact_number(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO : getByContactNumber() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorOutletDAO : getByContactNumber() --> Invalid contactNumber " + contactNumber);
			}
			VendorOutletInterface vendorOutletInterface = new VendorOutlet();
			vendorOutletInterface.setCode(resultSet.getInt("code"));
			vendorOutletInterface.setVendorCode(resultSet.getInt("vendor_code"));
			vendorOutletInterface.setCityCode(resultSet.getInt("city_code"));
			vendorOutletInterface.setAddress(resultSet.getString("address").trim());
			vendorOutletInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorOutletInterface.setLatitude(resultSet.getString("latitude").trim());
			vendorOutletInterface.setLongitude(resultSet.getString("longitude").trim());
			resultSet.close();
			callableStatement.close();
if(closeConnection)
{
	connection.close();
}
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByContactNumber() " + exception.getMessage());
		}

	}

//tested
	public void update(VendorOutletInterface vendorOutletInterface,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			boolean valid =true;
			if(!exists(vendorOutletInterface.getCode(),connection))
			{
			throw new DAOException("VendorOutletDAO : update() --> Invalid vendorOutlet Code :"+vendorOutletInterface.getCode());
			}

			VendorOutletInterface vVendorOutletInterface;
			try
			{	
				vVendorOutletInterface = getByContactNumber(vendorOutletInterface.getContactNumber(),connection);

				if(vendorOutletInterface.getCode()!= vVendorOutletInterface.getCode())
				{
					valid=false;			
				}
			}
			catch(DAOException daoException)
			{

			}
			if(!valid)
			{
				throw new DAOException("VendorOutletDAO : update() phone number already exists "+vendorOutletInterface.getContactNumber());
			}
			valid =true;
			try
			{	
				vVendorOutletInterface= getByCoordinates(vendorOutletInterface.getLatitude(),vendorOutletInterface.getLongitude(),connection);
				
				if(vendorOutletInterface.getCode()!=vVendorOutletInterface.getCode())
				{
				valid=false;
				}
			}
			catch(DAOException dAOException)
			{

			}
			if(!valid)
			{
			throw new DAOException("VendorOutletDAO : update() --> VendorOutlet with same Coordinates Already Exists : "+vendorOutletInterface.getLatitude()+", "+vendorOutletInterface.getLongitude());
			}

			if(!(new CityDAO().exists(vendorOutletInterface.getCityCode(),connection)))
			{
			throw new DAOException("VendorOutletDAO : update() invalid city code : " + vendorOutletInterface.getCityCode());	
			}
	
		String job="{ call update_vendor_outlet(?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setInt(1,vendorOutletInterface.getCode());
		callableStatement.setInt(2,vendorOutletInterface.getVendorCode());
		callableStatement.setString(3,vendorOutletInterface.getAddress());
		callableStatement.setString(4,vendorOutletInterface.getLatitude());
		callableStatement.setString(5,vendorOutletInterface.getLongitude());
		callableStatement.setInt(6,vendorOutletInterface.getCityCode());
		callableStatement.setString(7,vendorOutletInterface.getContactNumber());
		callableStatement.execute();
		callableStatement.close();
if(closeConnection)
{
	connection.close();
}

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : update() "+exception.getMessage());
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
		
		if(!exists(code,null))
		{
			throw new DAOException("VendorOutletDAO : remove() -> invalid vendor code :"+code);
		}
		/*
		if(new OperatorDAO().getCountByVendorCode(code,null)>0)
		{
			throw new DAOException("VendorOutletDAO : remove() ->operator exists against this vendor code :"+code);
		}

		String job="{ call remove_vendor_outlet(?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setInt(1,code);
		callableStatement.execute();
		callableStatement.close();
		*/
		if(closeConnection)
		{
			connection.close();
		}
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : remove() "+exception.getMessage());
		}
	}


//tested
	public VendorOutletInterface getByCode(int code,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_vendor_outlet_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO : getByCode() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorOutletDAO : getByCode() --> Invalid code " + code);
			}
		
			VendorOutletInterface vendorOutletInterface = new VendorOutlet();
			vendorOutletInterface.setCode(resultSet.getInt("code"));
			vendorOutletInterface.setVendorCode(resultSet.getInt("vendor_code"));
			vendorOutletInterface.setCityCode(resultSet.getInt("city_code"));
			vendorOutletInterface.setAddress(resultSet.getString("address").trim());
			vendorOutletInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorOutletInterface.setLatitude(resultSet.getString("latitude").trim());
			vendorOutletInterface.setLongitude(resultSet.getString("longitude").trim());
			resultSet.close();
			callableStatement.close();
if(closeConnection)
{
	connection.close();
}
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCode() "+exception.getMessage());
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
		/*
		if(new OperatorDAO().getCount(null)>0)
		{
			throw new DAOException("VendorOutletDAO : removeAll() : operators exists against vendor outlets");
		}
		String job="{ call remove_all_vendor_outlets() }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.execute();
		callableStatement.close();

		*/
if(closeConnection)
{
	connection.close();
}
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : removeAll() "+exception.getMessage());
		}
	}


	//tested
	public boolean exists(int code,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			boolean exists=false;

			String job="{ call vendor_outlet_exists_by_code(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,code);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO :exists() --> No records in generated result");
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
			throw new DAOException("VendorOutletDAO : exists() "+exception.getMessage());
		}

	}

//tested
	public ArrayList<VendorOutletInterface> getAll(Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_all_vendor_outlets() }";
			CallableStatement callableStatement=connection.prepareCall(job);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO : getAll() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorOutletDAO : getAll() --> No records ");
			}

			ArrayList<VendorOutletInterface> vendorOutlets;
			vendorOutlets=new ArrayList<VendorOutletInterface>();
			VendorOutletInterface vendorOutletInterface; 
			do
			{
			vendorOutletInterface = new VendorOutlet();
			vendorOutletInterface.setCode(resultSet.getInt("code"));
			vendorOutletInterface.setVendorCode(resultSet.getInt("vendor_code"));
			vendorOutletInterface.setCityCode(resultSet.getInt("city_code"));
			vendorOutletInterface.setAddress(resultSet.getString("address").trim());
			vendorOutletInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorOutletInterface.setLatitude(resultSet.getString("latitude").trim());
			vendorOutletInterface.setLongitude(resultSet.getString("longitude").trim());			
			vendorOutlets.add(vendorOutletInterface);
			}while(resultSet.next());
			resultSet.close();
			callableStatement.close();
if(closeConnection)
{
	connection.close();
}
			return vendorOutlets;


		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getAll() "+exception.getMessage());
		}

	}

//tested
	public ArrayList<VendorOutletInterface> getByCity(int cityCode,Connection connection) throws DAOException
	{
			boolean closeConnection=false;
			try
			{
			if(connection==null)
			{
			connection=DAOConnection.getConnection();	
			closeConnection=true;
			}
			String job="{ call get_all_vendor_outlets_by_city(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setInt(1,cityCode);
			boolean resultGenerated=callableStatement.execute();
			if(!resultGenerated)
			{
			callableStatement.close();
			connection.close();
			throw new DAOException("VendorOutletDAO : getByCity() --> No ResultSet object");
			}
			ResultSet resultSet=callableStatement.getResultSet();
			if(resultSet.next()==false)
			{
				resultSet.close();
				callableStatement.close();
				connection.close();
				throw new DAOException("VendorOutletDAO : getByCity() --> No records ");
			}

			ArrayList<VendorOutletInterface> vendorOutlets;
			vendorOutlets=new ArrayList<VendorOutletInterface>();
			VendorOutletInterface vendorOutletInterface; 
			do
			{
			vendorOutletInterface = new VendorOutlet();
			vendorOutletInterface.setCode(resultSet.getInt("code"));
			vendorOutletInterface.setVendorCode(resultSet.getInt("vendor_code"));
			vendorOutletInterface.setCityCode(resultSet.getInt("city_code"));
			vendorOutletInterface.setAddress(resultSet.getString("address").trim());
			vendorOutletInterface.setContactNumber(resultSet.getString("contact_number").trim());
			vendorOutletInterface.setLatitude(resultSet.getString("latitude").trim());
			vendorOutletInterface.setLongitude(resultSet.getString("longitude").trim());			
			vendorOutlets.add(vendorOutletInterface);
			}while(resultSet.next());
			resultSet.close();
			callableStatement.close();
if(closeConnection)
{
	connection.close();
}
			return vendorOutlets;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCity() "+exception.getMessage());
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
			String job="{ call get_vendor_outlet_count(?) }";
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
			throw new DAOException("VendorOutletDAO : getCount() "+exception.getMessage());
		}

	}


}
	