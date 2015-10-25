package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;
public class VendorOutletDAO implements VendorOutletDAOInterface
{
	public void add(VendorOutletInterface vendorOutletInterface) throws DAOException
	{
		try
		{
		if(!(new CityDAO().exists(vendorOutletInterface.getCityCode())))
		{	
		throw new DAOException("VendorOutletDAO : add() invalid city code : " + vendorOutletInterface.getCityCode());	
		}
		if(!(new VendorDAO().exists(vendorOutletInterface.getVendorCode())))
		{	
		throw new DAOException("VendorOutletDAO : add() invalid vendor code : " + vendorOutletInterface.getVendorCode());	
		}
		if(existsByCoordinates(vendorOutletInterface.getLatitude(),vendorOutletInterface.getLongitude()))
		{
		throw new DAOException("VendorOutletDAO : add() Outlet exists with same Coordinates: " + vendorOutletInterface.getLatitude()+" , " + vendorOutletInterface.getLongitude());	
		}
		if(getCountByContactNumber(vendorOutletInterface.getContactNumber())>0)
		{
				throw new DAOException("VendorOutletDAO : add() Outlet exists with same Contact Number: " + vendorOutletInterface.getContactNumber());	
		}

		Connection connection=DAOConnection.getConnection();
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
		connection.close();
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : add() "+exception.getMessage());
		}
	}
	
	public boolean existsByCoordinates(String latitude,String longitude) throws DAOException
	{
		try
		{
			boolean exists=false;
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("VendorDAO : existsByCoordinates() " + exception.getMessage());
		}

	}

	public int getCountByContactNumber(String contactNumber) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
			String job="{ call get_vendor_outlet_count_by_contact_number(?,?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.setString(1,contactNumber);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callableStatement.execute();
			int count=callableStatement.getInt(2);
			callableStatement.close();
			connection.close();
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getCountByContactNumber() " + exception.getMessage());
		}

	}

	public VendorOutletInterface getByCoordinates(String latitude,String longitude) throws DAOException
	{
	try
		{
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCoordinates() "+exception.getMessage());
		}	
	}

	public VendorOutletInterface getByContactNumber(String contactNumber) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByContactNumber() " + exception.getMessage());
		}

	}

	public void update(VendorOutletInterface vendorOutletInterface) throws DAOException
	{
		try
		{
			boolean valid =true;
			if(!exists(vendorOutletInterface.getCode()))
			{
			throw new DAOException("VendorOutletDAO : update() --> Invalid vendorOutlet Code :"+vendorOutletInterface.getCode());
			}

			VendorOutletInterface vVendorOutletInterface;
			try
			{	
				vVendorOutletInterface = getByContactNumber(vendorOutletInterface.getContactNumber());

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
				vVendorOutletInterface= getByCoordinates(vendorOutletInterface.getLatitude(),vendorOutletInterface.getLongitude());
				
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
			
			if(!(new CityDAO().exists(vendorOutletInterface.getCityCode())))
			{
			throw new DAOException("VendorOutletDAO : update() invalid city code : " + vendorOutletInterface.getCityCode());	
			}
		Connection connection=DAOConnection.getConnection();
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
		connection.close();

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : update() "+exception.getMessage());
		}
	}
	
	public void remove(int code) throws DAOException
	{
		try
		{

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : remove() "+exception.getMessage());
		}
	}


	public VendorOutletInterface getByCode(int code) throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return vendorOutletInterface;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCode() "+exception.getMessage());
		}
	
	}


	public void removeAll() throws DAOException
	{
		try
		{

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : removeAll() "+exception.getMessage());
		}
	}


	public boolean exists(int code) throws DAOException
	{
		try
		{
			boolean exists=false;
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return exists;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : exists() "+exception.getMessage());
		}

	}


	public ArrayList<VendorOutletInterface> getAll() throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return vendorOutlets;


		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getAll() "+exception.getMessage());
		}

	}


	public ArrayList<VendorOutletInterface> getByCity(int cityCode) throws DAOException
	{
		try
		{

			Connection connection=DAOConnection.getConnection();
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
			connection.close();
			return vendorOutlets;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCity() "+exception.getMessage());
		}

	}


	public long getCount() throws DAOException
	{
		try
		{
			Connection connection=DAOConnection.getConnection();
			String job="{ call get_vendor_outlet_count(?) }";
			CallableStatement callableStatement=connection.prepareCall(job);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.execute();
			long count=callableStatement.getInt(1);
			callableStatement.close();
			connection.close();
			return count;
		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getCount() "+exception.getMessage());
		}

	}


}
	