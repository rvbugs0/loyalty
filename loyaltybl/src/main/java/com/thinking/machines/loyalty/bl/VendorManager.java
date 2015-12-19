package com.thinking.machines.loyalty.bl;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
public class VendorManager
{
public void add(com.thinking.machines.loyalty.bl.interfaces.VendorInterface vendorInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendor=new com.thinking.machines.loyalty.dao.Vendor();
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setCityCode(vendorInterface.getCityCode());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorDAOInterface.add(vendor,connection);
vendorInterface.setCode(vendor.getCode());
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void update(com.thinking.machines.loyalty.bl.interfaces.VendorInterface vendorInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendor=new com.thinking.machines.loyalty.dao.Vendor();
vendor.setCode(vendorInterface.getCode());
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setCityCode(vendorInterface.getCityCode());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorDAOInterface.update(vendor,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public void getByCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.bl.interfaces.VendorInterface vendor=new Vendor();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface=vendorDAOInterface.getByCode(code,connection);
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface> getAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.VendorInterface> vendorInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface> vendors= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface>();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterfaces=vendorDAOInterface.getAll(connection);
com.thinking.machines.loyalty.bl.interfaces.VendorInterface vendor;
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
int x=0;
while(x<vendorInterfaces.size())
{
vendorInterface=vendorInterfaces.get(x);
vendor=new Vendor();
vendor.setCode(vendorInterface.getCode());
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
vendors.add(vendor);
x++;
}
return vendors;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface> getAllByCityCode(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.VendorInterface> vendorInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface> vendors= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.VendorInterface>();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterfaces=vendorDAOInterface.getByCityCode(cityCode,connection);
com.thinking.machines.loyalty.bl.interfaces.VendorInterface vendor;
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
int x=0;
while(x<vendorInterfaces.size())
{
vendorInterface=vendorInterfaces.get(x);
vendor=new Vendor();
vendor.setCode(vendorInterface.getCode());
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
vendors.add(vendor);
x++;
}
return vendors;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public long getCountByCity(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
long count=vendorDAOInterface.getCountByCity(cityCode,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public void removeAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorDAOInterface.removeAll(connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public void remove(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorDAOInterface.remove(code,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

}
