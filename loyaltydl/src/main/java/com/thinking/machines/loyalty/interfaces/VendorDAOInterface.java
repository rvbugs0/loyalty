package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;

public interface VendorDAOInterface
{
	public void add(VendorInterface vendorInterface,Connection connection) throws DAOException;
	public void update(VendorInterface vendorInterface,Connection connection) throws DAOException;
	public void remove(int code,Connection connection) throws DAOException;
	
	
	public long getCount(Connection connection) throws DAOException;
	public long getCountByCity(int cityCode,Connection connection) throws DAOException;


	public ArrayList<VendorInterface> getAll(Connection connection) throws DAOException;
	public void removeAll(Connection connection) throws DAOException;
	
	public VendorInterface getByName(String name,Connection connection) throws DAOException;
	public VendorInterface getByUsername(String username,Connection connection) throws DAOException;
	public VendorInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public VendorInterface getByCode(int code,Connection connection) throws DAOException;
	public VendorInterface getByEmailId(String emailId,Connection connection) throws DAOException;
	

	public boolean exists(int code,Connection connection) throws DAOException;
	public boolean existsByUsername(String username,Connection connection) throws DAOException;
	public boolean existsByEmailId(String emailId,Connection connection) throws DAOException;
	public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public boolean existsByName(String name,Connection connection) throws DAOException;
}
 		