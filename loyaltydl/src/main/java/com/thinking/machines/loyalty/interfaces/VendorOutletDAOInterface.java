package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;

public interface VendorOutletDAOInterface
{
	public void add(VendorOutletInterface vendorOutletInterface) throws DAOException;
	public void update(VendorOutletInterface vendorOutletInterface) throws DAOException;
	public void remove(int code) throws DAOException;
	public VendorOutletInterface getByCode(int code) throws DAOException;
	public void removeAll() throws DAOException;
	public boolean exists(int code) throws DAOException;
	public ArrayList<VendorOutletInterface> getAll() throws DAOException;
	public ArrayList<VendorOutletInterface> getByCity(int cityCode) throws DAOException;
	public long getCount() throws DAOException;	
}
