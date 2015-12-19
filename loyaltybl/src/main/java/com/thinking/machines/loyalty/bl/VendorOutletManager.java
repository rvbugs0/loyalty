package com.thinking.machines.loyalty.bl;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
//import com.thinking.machines.loyalty.bl.interfaces.*;
import java.util.*;
import java.sql.*;
public class VendorOutletManager 
{
public void add(VendorOutletBLInterface vendorOutletInterface) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vOutletInterface=new com.thinking.machines.loyalty.dao.VendorOutlet();
//vendorOutletInterface.setCode(vendorInterface.getVendorOutletCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletDAOInterface.add(vOutletInterface,connection);
int code=vOutletInterface.getCode();
vendorOutletInterface.setCode(code);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->add()"+daoException.getMessage());
}
}


public void update(VendorOutletBLInterface vendorOutletInterface) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vOutletInterface=new com.thinking.machines.loyalty.dao.VendorOutlet();
vOutletInterface.setCode(vendorOutletInterface.getCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletDAOInterface.update(vOutletInterface,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->update()"+daoException.getMessage());
}
}

public void remove(int code) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletDAOInterface.remove(code,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->remove()"+daoException.getMessage());
}
}


public VendorOutletBLInterface getByCode(int code) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vendorOutletInterface;
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletInterface=vendorOutletDAOInterface.getByCode(code,connection);
VendorOutletBLInterface vOutletInterface=new com.thinking.machines.loyalty.bl.VendorOutlet();
vOutletInterface.setCode(vendorOutletInterface.getCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
return vOutletInterface;
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getByCode()"+daoException.getMessage());
}
}

public ArrayList<VendorOutletBLInterface> getAll() throws BLException
{
ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface> vendorOutlets;
ArrayList<VendorOutletBLInterface> vOutlets;
try{
Connection connection=DAOConnection.getConnection();
//vendorOutlets=new ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface>();
vOutlets=new ArrayList<VendorOutletBLInterface>();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutlets=vendorOutletDAOInterface.getAll(connection);
System.out.println(vendorOutlets.size());
VendorOutletBLInterface vOutletInterface;
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vendorOutletInterface;
int x=0;
while(x<vendorOutlets.size())
{
vendorOutletInterface=vendorOutlets.get(x);
vOutletInterface=new com.thinking.machines.loyalty.bl.VendorOutlet(); 
vOutletInterface.setCode(vendorOutletInterface.getCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
vOutlets.add(vOutletInterface);
x++;
}
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getAll()"+daoException.getMessage());
}
return vOutlets;
}


public ArrayList<VendorOutletBLInterface> getAllByCityCode(int cityCode) throws BLException
{
ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface> vendorOutlets;
ArrayList<VendorOutletBLInterface> vOutlets;
try{
Connection connection=DAOConnection.getConnection();
//vendorOutlets=new ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface>();
vOutlets=new ArrayList<VendorOutletBLInterface>();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutlets=vendorOutletDAOInterface.getByCity(cityCode,connection);
System.out.println(vendorOutlets.size());
VendorOutletBLInterface vOutletInterface;
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vendorOutletInterface;
int x=0;
while(x<vendorOutlets.size())
{
vendorOutletInterface=vendorOutlets.get(x);
vOutletInterface=new com.thinking.machines.loyalty.bl.VendorOutlet(); 
vOutletInterface.setCode(vendorOutletInterface.getCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
vOutlets.add(vOutletInterface);
x++;
}
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getAllByCityCode()"+daoException.getMessage());
}
return vOutlets;
}

public ArrayList<VendorOutletBLInterface> getAllByVendorCode(int vendorCode) throws BLException
{
ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface> vendorOutlets;
ArrayList<VendorOutletBLInterface> vOutlets;
try{
Connection connection=DAOConnection.getConnection();
//vendorOutlets=new ArrayList<com.thinking.machines.loyalty.interfaces.VendorOutletInterface>();
vOutlets=new ArrayList<VendorOutletBLInterface>();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutlets=vendorOutletDAOInterface.getByVendor(vendorCode,connection);
System.out.println(vendorOutlets.size());
VendorOutletBLInterface vOutletInterface;
com.thinking.machines.loyalty.interfaces.VendorOutletInterface vendorOutletInterface;
int x=0;
while(x<vendorOutlets.size())
{
vendorOutletInterface=vendorOutlets.get(x);
vOutletInterface=new com.thinking.machines.loyalty.bl.VendorOutlet(); 
vOutletInterface.setCode(vendorOutletInterface.getCode());
vOutletInterface.setVendorCode(vendorOutletInterface.getVendorCode());
vOutletInterface.setAddress(vendorOutletInterface.getAddress());
vOutletInterface.setLatitude(vendorOutletInterface.getLatitude());
vOutletInterface.setLongitude(vendorOutletInterface.getLongitude());
vOutletInterface.setCityCode(vendorOutletInterface.getCityCode());
vOutletInterface.setContactNumber(vendorOutletInterface.getContactNumber());
vOutlets.add(vOutletInterface);
x++;
}
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getAllByVendorCode()"+daoException.getMessage());
}
return vOutlets;
}


public long getCount() throws BLException
{
long count=0;
try{
Connection connection=DAOConnection.getConnection();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
count=vendorOutletDAOInterface.getCount(connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getCount()"+daoException.getMessage());
}
return count;
}

public long getCountByCity(int cityCode) throws BLException
{
long count=0;
try{
Connection connection=DAOConnection.getConnection();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
count=vendorOutletDAOInterface.getCountByCity(cityCode,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->getCountByCity()"+daoException.getMessage());
}
return count;
}

public boolean exists(int code) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
exists=vendorOutletDAOInterface.exists(code,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->exists()"+daoException.getMessage());
}
return exists;
}

public void removeAll() throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletDAOInterface.removeAll(connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorOutletManager-->removeAll()"+daoException.getMessage());
}
}


}
