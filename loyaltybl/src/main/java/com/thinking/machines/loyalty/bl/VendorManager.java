package com.thinking.machines.loyalty.bl;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
public class VendorManager
{
public void add(VendorBLInterface vendorInterface) throws BLException
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


public void update(VendorBLInterface vendorInterface) throws BLException
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

public VendorBLInterface getByCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
VendorBLInterface vendor=new Vendor();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface=vendorDAOInterface.getByCode(code,connection);
vendor.setName(vendorInterface.getName());
vendor.setUsername(vendorInterface.getUsername());
vendor.setPassword(vendorInterface.getPassword());
vendor.setPasswordKey(vendorInterface.getPasswordKey());
vendor.setAddress(vendorInterface.getAddress());
vendor.setContactNumber(vendorInterface.getContactNumber());
vendor.setEmailId(vendorInterface.getEmailId());
return vendor;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public VendorBLInterface getByUsername(String username) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterface=vendorDAOInterface.getByUsername(username,connection);
VendorBLInterface vInterface=new com.thinking.machines.loyalty.bl.Vendor();
vInterface.setCode(vendorInterface.getCode());
vInterface.setName(vendorInterface.getName());
vInterface.setUsername(vendorInterface.getUsername());
vInterface.setPassword(vendorInterface.getPassword());
vInterface.setPasswordKey(vendorInterface.getPasswordKey());
vInterface.setAddress(vendorInterface.getAddress());
vInterface.setCityCode(vendorInterface.getCityCode());
vInterface.setContactNumber(vendorInterface.getContactNumber());
vInterface.setEmailId(vendorInterface.getEmailId());
return vInterface;
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->getByUsername()"+daoException.getMessage());
}
}

public VendorBLInterface getByName(String name) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterface=vendorDAOInterface.getByName(name,connection);
VendorBLInterface vInterface=new com.thinking.machines.loyalty.bl.Vendor();
vInterface.setCode(vendorInterface.getCode());
vInterface.setName(vendorInterface.getName());
vInterface.setUsername(vendorInterface.getUsername());
vInterface.setPassword(vendorInterface.getPassword());
vInterface.setPasswordKey(vendorInterface.getPasswordKey());
vInterface.setAddress(vendorInterface.getAddress());
vInterface.setCityCode(vendorInterface.getCityCode());
vInterface.setContactNumber(vendorInterface.getContactNumber());
vInterface.setEmailId(vendorInterface.getEmailId());
return vInterface;
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->getByName()"+daoException.getMessage());
}
}

public VendorBLInterface getByContactNumber(String contactNumber) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterface=vendorDAOInterface.getByContactNumber(contactNumber,connection);
VendorBLInterface vInterface=new com.thinking.machines.loyalty.bl.Vendor();
vInterface.setCode(vendorInterface.getCode());
vInterface.setName(vendorInterface.getName());
vInterface.setUsername(vendorInterface.getUsername());
vInterface.setPassword(vendorInterface.getPassword());
vInterface.setPasswordKey(vendorInterface.getPasswordKey());
vInterface.setAddress(vendorInterface.getAddress());
vInterface.setCityCode(vendorInterface.getCityCode());
vInterface.setContactNumber(vendorInterface.getContactNumber());
vInterface.setEmailId(vendorInterface.getEmailId());
return vInterface;
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->getByContactNumber()"+daoException.getMessage());
}
}

public VendorBLInterface getByEmailId(String emailId) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.VendorInterface vendorInterface;
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterface=vendorDAOInterface.getByEmailId(emailId,connection);
VendorBLInterface vInterface=new com.thinking.machines.loyalty.bl.Vendor();
vInterface.setCode(vendorInterface.getCode());
vInterface.setName(vendorInterface.getName());
vInterface.setUsername(vendorInterface.getUsername());
vInterface.setPassword(vendorInterface.getPassword());
vInterface.setPasswordKey(vendorInterface.getPasswordKey());
vInterface.setAddress(vendorInterface.getAddress());
vInterface.setCityCode(vendorInterface.getCityCode());
vInterface.setContactNumber(vendorInterface.getContactNumber());
vInterface.setEmailId(vendorInterface.getEmailId());
return vInterface;
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->getByEmailId()"+daoException.getMessage());
}
}

public ArrayList<VendorBLInterface> getAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.VendorInterface> vendorInterfaces;
ArrayList<VendorBLInterface> vendors= new ArrayList<VendorBLInterface>();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterfaces=vendorDAOInterface.getAll(connection);
VendorBLInterface vendor;
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


public ArrayList<VendorBLInterface> getAllByCityCode(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.VendorInterface> vendorInterfaces;
ArrayList<VendorBLInterface> vendors= new ArrayList<VendorBLInterface>();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterfaces=vendorDAOInterface.getByCityCode(cityCode,connection);
VendorBLInterface vendor;
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

public long getCount() throws BLException
{
long count=0;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
count=vendorDAOInterface.getCount(connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->getCount()"+daoException.getMessage());
}
return count;
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

public boolean exists(int code) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
exists=vendorDAOInterface.exists(code,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->exists()"+daoException.getMessage());
}
return exists;
}

public boolean existsByUsername(String username) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
exists=vendorDAOInterface.existsByUsername(username,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->existsByUsername()"+daoException.getMessage());
}
return exists;
}

public boolean existsByName(String name) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
exists=vendorDAOInterface.existsByName(name,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->existsByName()"+daoException.getMessage());
}
return exists;
}

public boolean existsByEmailId(String emailId) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
exists=vendorDAOInterface.existsByEmailId(emailId,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->existsByEmailId()"+daoException.getMessage());
}
return exists;
}

public boolean existsByContactNumber(String contactNumber) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
exists=vendorDAOInterface.existsByContactNumber(contactNumber,connection);
}
catch(DAOException daoException)
{
throw new BLException("VendorManager-->existsByContactNumber()"+daoException.getMessage());
}
return exists;
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


}
