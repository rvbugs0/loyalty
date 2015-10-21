package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;

public interface VendorDAOInterface
{
	public void add(VendorInterface vendorInterface) throws DAOException;
	public void update(VendorInterface vendorInterface) throws DAOException;
	public void remove(int code) throws DAOException;
	public VendorInterface getByCode(int code) throws DAOException;
	public VendorInterface getByEmailId(String emailId) throws DAOException;
	public void removeAll() throws DAOException;
	public boolean exists(int code) throws DAOException;
	public ArrayList<VendorInterface> getAll() throws DAOException;
	public long getCount() throws DAOException;
	public int getCountByUsername(String username) throws DAOException;
	public VendorInterface getByUsername(String username) throws DAOException;
	public boolean existsByUsername(String username) throws DAOException;
	public boolean existsByEmailId(String emailId) throws DAOException;
}
