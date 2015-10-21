package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
public class VendorOutletDAO implements VendorOutletDAOInterface
{
	public void add(VendorOutletInterface vendorOutletInterface) throws DAOException
	{
		try
		{

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

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : exists() "+exception.getMessage());
		}
		return false;
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


	public ArrayList<VendorOutletInterface> getByCity() throws DAOException
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

		}catch(Exception exception)
		{
			throw new DAOException("VendorOutletDAO : getCount() "+exception.getMessage());
		}
		return 0;
	}


}
	