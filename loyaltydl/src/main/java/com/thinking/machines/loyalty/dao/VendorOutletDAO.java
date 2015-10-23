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
		Connection connection=DAOConnection.getConnection();
		String job="{ call add_vendor_outlet(?,?,?,?,?,?,?) }";
		CallableStatement callableStatement=connection.prepareCall(job);
		callableStatement.setInt(1,vendorOutletInterface.getVendorCode());
		callableStatement.setString(2,vendorOutletInterface.getAddress());
		callableStatement.setString(3,vendorOutletInterface.getLatitude());
		callableStatement.setString(4,vendorOutletInterface.getLongitude());
		callableStatement.setInt(5,vendorOutletInterface.getCityCode());
		
		String contactNumbersString="";
		int x=0;
		ArrayList<String> contactNumbers=vendorOutletInterface.getContactNumbers();
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
		callableStatement.setString(6,contactNumbersString);
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
	

	public void update(VendorOutletInterface vendorOutletInterface) throws DAOException
	{
		try
		{

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

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCode() "+exception.getMessage());
		}
	return null;
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

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getAll() "+exception.getMessage());
		}
	return null;
	}


	public ArrayList<VendorOutletInterface> getByCity(int cityCode) throws DAOException
	{
		try
		{

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getByCity() "+exception.getMessage());
		}
	return null;
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
	