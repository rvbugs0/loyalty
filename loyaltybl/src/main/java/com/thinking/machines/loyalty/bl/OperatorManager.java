package com.thinking.machines.loyalty.bl;
import java.util.*;
 import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
import com.thinking.machines.loyalty.interfaces.*;
public class OperatorManager
{


public void add(OperatorBLInterface operatorInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.OperatorInterface operator=new com.thinking.machines.loyalty.dao.Operator();
operator.setName(operatorInterface.getName());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());

operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());

OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.add(operator,connection);
operatorInterface.setCode(operator.getCode());
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void update(OperatorBLInterface operatorInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.OperatorInterface operator=new com.thinking.machines.loyalty.dao.Operator();
operator.setCode(operatorInterface.getCode());
operator.setName(operatorInterface.getName());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.update(operator,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public OperatorBLInterface getByCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorBLInterface operator=new Operator();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
com.thinking.machines.loyalty.interfaces.OperatorInterface operatorInterface=operatorDAOInterface.get(code,connection);
operator.setName(operatorInterface.getName());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
return operator;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}





public OperatorBLInterface getByName(String name) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorBLInterface operator=new Operator();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
com.thinking.machines.loyalty.interfaces.OperatorInterface operatorInterface=operatorDAOInterface.getByName(name,connection);
operator.setCode(operatorInterface.getCode());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
return operator;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public OperatorBLInterface getByUsername(String username) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorBLInterface operator=new Operator();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
com.thinking.machines.loyalty.interfaces.OperatorInterface operatorInterface=operatorDAOInterface.getByUsername(username,connection);
operator.setCode(operatorInterface.getCode());
operator.setName(operatorInterface.getName());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
return operator;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<OperatorBLInterface> getAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.OperatorInterface> operatorInterfaces;
ArrayList<OperatorBLInterface> operators= new ArrayList<OperatorBLInterface>();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorInterfaces=operatorDAOInterface.getAll(connection);
OperatorBLInterface operator;
com.thinking.machines.loyalty.interfaces.OperatorInterface operatorInterface;
int x=0;
while(x<operatorInterfaces.size())
{
operatorInterface=operatorInterfaces.get(x);
operator=new Operator();
operator.setCode(operatorInterface.getCode());
operator.setName(operatorInterface.getName());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
operators.add(operator);
x++;
}
return operators;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public ArrayList<OperatorBLInterface> getAllByVendorOutletCode(int vendorOutletCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.OperatorInterface> operatorInterfaces;
ArrayList<OperatorBLInterface> operators= new ArrayList<OperatorBLInterface>();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorInterfaces=operatorDAOInterface.getAllByVendorOutletCode(vendorOutletCode,connection);
OperatorBLInterface operator;
com.thinking.machines.loyalty.interfaces.OperatorInterface operatorInterface;
int x=0;
while(x<operatorInterfaces.size())
{
operatorInterface=operatorInterfaces.get(x);
operator=new Operator();
operator.setCode(operatorInterface.getCode());
operator.setName(operatorInterface.getName());
operator.setUsername(operatorInterface.getUsername());
operator.setPassword(operatorInterface.getPassword());
operator.setPasswordKey(operatorInterface.getPasswordKey());
operator.setVendorOutletCode(operatorInterface.getVendorOutletCode());
operators.add(operator);
x++;
}
return operators;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public long getCountByVendorOutletCode(int vendorOutletCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
long count=operatorDAOInterface.getCountByVendorOutletCode(vendorOutletCode,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}




public long getCount() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
long count=operatorDAOInterface.getCount(connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public long getCountByName(String name) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
long count=operatorDAOInterface.getCountByName(name,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public long getCountByUsername(String username) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
long count=operatorDAOInterface.getCountByUsername(username,connection);
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
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.removeAll(connection);
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
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.remove(code,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public void removeAllByVendorOutletCode(int vendorOutletCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.removeAllByVendorOutletCode(vendorOutletCode,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void removeByUsername(String username) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
operatorDAOInterface.removeByUsername(username,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}



public boolean exists(int code) throws BLException 
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
boolean found=operatorDAOInterface.exists(code,connection);

return found;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public boolean existsByUsername(String name) throws BLException 
{
try
{
Connection connection=DAOConnection.getConnection();
OperatorDAOInterface operatorDAOInterface=new OperatorDAO();
boolean found=operatorDAOInterface.existsByUsername(name,connection);
return found;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


}