package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;

public interface VendorOutletDAOInterface
{
	public void add(VendorOutletInterface vendorOutletInterface,Connection connection) throws DAOException;
	public void update(VendorOutletInterface vendorOutletInterface,Connection connection) throws DAOException;
	public void remove(int code,Connection connection) throws DAOException;
	public VendorOutletInterface getByCode(int code,Connection connection) throws DAOException;
	public VendorOutletInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public VendorOutletInterface getByCoordinates(String latitude,String longitude,Connection connection) throws DAOException;
	public void removeAll(Connection connection) throws DAOException;
	public boolean exists(int code,Connection connection) throws DAOException;


	public boolean existsByCoordinates(String latitude,String longitude,Connection connection) throws DAOException;
	public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public ArrayList<VendorOutletInterface> getAll(Connection connection) throws DAOException;
	public ArrayList<VendorOutletInterface> getByCity(int cityCode,Connection connection) throws DAOException;
	public ArrayList<VendorOutletInterface> getByVendor(int vendorCode,Connection connection) throws DAOException;
	public long getCount(Connection connection) throws DAOException;
	public long getCountByCity(int cityCode,Connection connection) throws DAOException;	
}
