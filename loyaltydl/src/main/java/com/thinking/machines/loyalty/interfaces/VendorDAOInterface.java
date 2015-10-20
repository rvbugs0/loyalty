package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;

public interface VendorDAOInterface
{
	public void addVendor(VendorInterface vendorInterface) throws DAOException;
	public void remove(int code) throws DAOException;
	public VendorInterface getByPrimaryKey(int code) throws DAOException;
	public void removeAll() throws DAOException;
	public boolean exists(int code) throws DAOException;
	public ArrayList<VendorInterface> getAll() throws DAOException;
	public long getCount() throws DAOException;
	public VendorInterface getByUsername(String username) throws DAOException;
	public boolean existsByUsername(String username) throws DAOException;
}
