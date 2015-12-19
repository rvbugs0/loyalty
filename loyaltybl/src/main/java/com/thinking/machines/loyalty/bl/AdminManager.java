package com.thinking.machines.loyalty.bl;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
//import com.thinking.machines.loyalty.bl.interfaces.*;
import java.util.*;
import java.sql.*;
public class AdminManager 
{
public void add(com.thinking.machines.loyalty.bl.interfaces.AdminInterface adminInterface) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.AdminInterface aInterface=new com.thinking.machines.loyalty.dao.Admin();
aInterface.setName(adminInterface.getName());
aInterface.setUsername(adminInterface.getUsername());
aInterface.setPassword(adminInterface.getPassword());
aInterface.setPasswordKey(adminInterface.getPasswordKey());
aInterface.setEmailId(adminInterface.getEmailId());
aInterface.setContactNumber(adminInterface.getContactNumber());
AdminDAOInterface adminDAOInterface=new AdminDAO();
adminDAOInterface.add(aInterface,connection);
int code=aInterface.getCode();
adminInterface.setCode(code);
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->add()"+daoException.getMessage());
}
}


public void update(com.thinking.machines.loyalty.bl.interfaces.AdminInterface adminInterface) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.AdminInterface aInterface=new com.thinking.machines.loyalty.dao.Admin();
aInterface.setCode(adminInterface.getCode());
aInterface.setName(adminInterface.getName());
aInterface.setUsername(adminInterface.getUsername());
aInterface.setPassword(adminInterface.getPassword());
aInterface.setPasswordKey(adminInterface.getPasswordKey());
aInterface.setEmailId(adminInterface.getEmailId());
aInterface.setContactNumber(adminInterface.getContactNumber());
AdminDAOInterface adminDAOInterface=new AdminDAO();
adminDAOInterface.update(aInterface,connection);
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->update()"+daoException.getMessage());
}
}

public void remove(int code) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
AdminDAOInterface adminDAOInterface=new AdminDAO();
adminDAOInterface.remove(code,connection);
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->remove()"+daoException.getMessage());
}
}


public com.thinking.machines.loyalty.bl.interfaces.AdminInterface getByCode(int code) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.AdminInterface adminInterface;
AdminDAOInterface adminDAOInterface=new AdminDAO();
adminInterface=adminDAOInterface.getByCode(code,connection);
com.thinking.machines.loyalty.bl.interfaces.AdminInterface aInterface=new com.thinking.machines.loyalty.bl.Admin();
aInterface.setCode(adminInterface.getCode());
aInterface.setName(adminInterface.getName());
aInterface.setUsername(adminInterface.getUsername());
aInterface.setPassword(adminInterface.getPassword());
aInterface.setPasswordKey(adminInterface.getPasswordKey());
aInterface.setEmailId(adminInterface.getEmailId());
aInterface.setContactNumber(adminInterface.getContactNumber());
return aInterface;
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->getByCode()"+daoException.getMessage());
}
}

public com.thinking.machines.loyalty.bl.interfaces.AdminInterface getByUsername(String username) throws BLException
{
try{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.AdminInterface adminInterface;
AdminDAOInterface adminDAOInterface=new AdminDAO();
adminInterface=adminDAOInterface.getByUsername(username,connection);
com.thinking.machines.loyalty.bl.interfaces.AdminInterface aInterface=new com.thinking.machines.loyalty.bl.Admin();
aInterface.setCode(adminInterface.getCode());
aInterface.setName(adminInterface.getName());
aInterface.setUsername(adminInterface.getUsername());
aInterface.setPassword(adminInterface.getPassword());
aInterface.setPasswordKey(adminInterface.getPasswordKey());
aInterface.setEmailId(adminInterface.getEmailId());
aInterface.setContactNumber(adminInterface.getContactNumber());
return aInterface;
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->getByUsername()"+daoException.getMessage());
}
}






public long getCount() throws BLException
{
long count=0;
try{
Connection connection=DAOConnection.getConnection();
AdminDAOInterface adminDAOInterface=new AdminDAO();
count=adminDAOInterface.getCount(connection);
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->getCount()"+daoException.getMessage());
}
return count;
}


public boolean exists(int code) throws BLException
{
boolean exists=false;
try{
Connection connection=DAOConnection.getConnection();
AdminDAOInterface adminDAOInterface=new AdminDAO();
exists=adminDAOInterface.exists(code,connection);
}
catch(DAOException daoException)
{
throw new BLException("AdminManager-->exists()"+daoException.getMessage());
}
return exists;
}


}
