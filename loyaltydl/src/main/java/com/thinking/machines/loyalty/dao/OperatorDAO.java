package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.exceptions.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.sql.*;
import java.util.*;
public class OperatorDAO implements OperatorDAOInterface
{
public void add(OperatorInterface operatorInterface,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job;
CallableStatement callableStatement;

/*
String job="{call get_operator_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,operatorInterface.getUsername());
boolean resultGenerated=callableStatement.execute();
if(resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("username already exists");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next())
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("username already exists");
}
*/
if(existsByUsername(operatorInterface.getUsername(),connection)) throw new DAOException("username already exists");
job="{call add_operator(?,?,?,?,?)}";
callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,operatorInterface.getVendorOutletCode());
callableStatement.setString(2,operatorInterface.getName());
callableStatement.setString(3,operatorInterface.getUsername());
callableStatement.setString(4,operatorInterface.getPassword());
callableStatement.registerOutParameter(5,Types.INTEGER); 
callableStatement.execute();
operatorInterface.setCode(callableStatement.getInt(5)); 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{

throw new DAOException("OperatorDAO : add(OperatorInterface)  ---> "+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : add(OperatorInterface)  ---> "+exception.getMessage());
}
}

public void update(OperatorInterface operatorInterface,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,operatorInterface.getCode());

boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("invalid operator code:"+operatorInterface.getCode());
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("invalid operator code:"+operatorInterface.getCode());
}

/*
job="{call get_operator_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,operatorInterface.getUsername());

boolean resultGenerated=callableStatement.execute();
if(resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("operator username already exists:"+operatorInterface.getUsername());
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next())
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("operator username already exists:"+operatorInterface.getUsername());
}
*/
job="{call update_operator(?,?,?,?,?)}";
callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,operatorInterface.getCode());
callableStatement.setInt(2,operatorInterface.getVendorOutletCode());
callableStatement.setString(3,operatorInterface.getName());
callableStatement.setString(4,operatorInterface.getUsername());
callableStatement.setString(5,operatorInterface.getPassword());
resultGenerated=callableStatement.execute();
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : update(OperatorInterface)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : update(OperatorInterface)  --->"+exception.getMessage());
}

}

public ArrayList<OperatorInterface> getAll(Connection connection) throws DAOException
{
ArrayList<OperatorInterface> operators=null;
boolean closeConnection=false;
try
{

if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}


String job="{call get_all_operators()}";
CallableStatement callableStatement=connection.prepareCall(job);


boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no records");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("No records");
}
operators=new ArrayList<OperatorInterface>();
OperatorInterface operatorInterface;
do
{operatorInterface=new Operator();
operatorInterface.setCode(resultSet.getInt("code"));
operatorInterface.setVendorOutletCode(resultSet.getInt("vendor_outlet_code"));
operatorInterface.setName(resultSet.getString("name"));
operatorInterface.setUsername(resultSet.getString("username"));
operatorInterface.setPassword(resultSet.getString("password"));

operators.add(operatorInterface);
}while(resultSet.next());
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return operators;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getAll()  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getAll()  --->"+exception.getMessage());
}
}
public ArrayList<OperatorInterface> getAllByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException
{
boolean closeConnection=false;
ArrayList<OperatorInterface> operators=null;
try
{if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_all_operators_by_vendor_outlet_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,vendorOutletCode);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no records");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("No records");
}
operators=new ArrayList<OperatorInterface>();
OperatorInterface operatorInterface;
do
{operatorInterface=new Operator();
operatorInterface.setCode(resultSet.getInt("code"));
operatorInterface.setVendorOutletCode(resultSet.getInt("vendor_outlet_code"));
operatorInterface.setName(resultSet.getString("name"));
operatorInterface.setUsername(resultSet.getString("username"));
operatorInterface.setPassword(resultSet.getString("password"));

operators.add(operatorInterface);
}while(resultSet.next());
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return operators;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getAllByVendorOutletCode(int vendorOutletCode)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getAllByVendorOutletCode(int vendorOutletCode)  --->"+exception.getMessage());
}
}
public OperatorInterface get(int code,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no records");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("No records");
}
OperatorInterface operatorInterface;
operatorInterface=new Operator();
operatorInterface.setCode(resultSet.getInt("code"));
operatorInterface.setVendorOutletCode(resultSet.getInt("vendor_outlet_code"));
operatorInterface.setName(resultSet.getString("name"));
operatorInterface.setUsername(resultSet.getString("username"));
operatorInterface.setPassword(resultSet.getString("password"));
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return operatorInterface;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : get(int code)  ---> "+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : get(int code)  ---> "+exception.getMessage());
}
}


public OperatorInterface getByName(String name,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_name(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,name);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no records");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("No records");
}
OperatorInterface operatorInterface;
operatorInterface=new Operator();
operatorInterface.setCode(resultSet.getInt("code"));
operatorInterface.setVendorOutletCode(resultSet.getInt("vendor_outlet_code"));
operatorInterface.setName(resultSet.getString("name"));
operatorInterface.setUsername(resultSet.getString("username"));
operatorInterface.setPassword(resultSet.getString("password"));
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return operatorInterface;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getByName(String name)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getByName(String name)  --->"+exception.getMessage());
}

}
public OperatorInterface getByUsername(String username,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no records");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("No records");
}
OperatorInterface operatorInterface;
operatorInterface=new Operator();
operatorInterface.setCode(resultSet.getInt("code"));
operatorInterface.setVendorOutletCode(resultSet.getInt("vendor_outlet_code"));
operatorInterface.setName(resultSet.getString("name"));
operatorInterface.setUsername(resultSet.getString("username"));
operatorInterface.setPassword(resultSet.getString("password"));
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return operatorInterface;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getByUsername(String username)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getByUsername(String username)  --->"+exception.getMessage());
}
}


public long getCount(Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_count()}";
CallableStatement callableStatement=connection.prepareCall(job);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}
ResultSet resultSet=callableStatement.getResultSet();

resultSet.next();
int count=resultSet.getInt("cnt");

resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return count;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getCount()  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getCount()  --->"+exception.getMessage());
}
}
public int getCountByName(String name,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_count_by_name(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,name);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}
ResultSet resultSet=callableStatement.getResultSet();
resultSet.next();
int count=resultSet.getInt("cnt");
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return count;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getCountByName(String name)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getCountByName(String name)  --->"+exception.getMessage());
}

}
public int getCountByUsername(String username,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_count_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}
ResultSet resultSet=callableStatement.getResultSet();
resultSet.next();
int count=resultSet.getInt("cnt");
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return count;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getCountByUsername(String username)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getCountByUsername(String username)  --->"+exception.getMessage());
}
}


public int getCountByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_count_by_vendor_outlet_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,vendorOutletCode);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}
ResultSet resultSet=callableStatement.getResultSet();
resultSet.next();
int count=resultSet.getInt("cnt");
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return count;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : getCountByVendorOutletCode(int vendorOutletCode)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : getCountByVendorOutletCode(int vendorOutletCode)  --->"+exception.getMessage());
}
}


public void removeAll(Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call remove_all_operators()}";
CallableStatement callableStatement=connection.prepareCall(job);
boolean resultGenerated=callableStatement.execute();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : removeAll()  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : removeAll()  --->"+exception.getMessage());
}
}

public void remove(int code,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);

boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("invalid operator code:"+code);
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("invalid operator code:"+code);
}
job="{call remove_operator(?)}";
callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);
resultGenerated=callableStatement.execute();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : remove(int code)  --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : remove(int code)  --->"+exception.getMessage());
}

}
public void removeAllByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_all_operators_by_vendor_outlet_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,vendorOutletCode);

boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no operators exist against given vendor outlet code: "+vendorOutletCode);
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no operators exist against given vendor outlet code: "+vendorOutletCode);
}
job="{call remove_all_operators_by_vendor_outlet_code(?)}";
callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,vendorOutletCode);
resultGenerated=callableStatement.execute();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : removeAllByVendorOutletCode(int vendorOutletCode) --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : removeAllByVendorOutletCode(int vendorOutletCode) --->"+exception.getMessage());
}

}
public void removeByUsername(String username,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call get_operator_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);

boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{ 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no operators exist against given username: "+username);
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
throw new DAOException("no operators against given username: "+username);
}
job="{call remove_operator_by_username(?)}";
callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);
resultGenerated=callableStatement.execute();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : removeByUsername(String username) --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : removeByUsername(String username) --->"+exception.getMessage());
}

}


public boolean exists(int code,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call operator_exists_by_code(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);
boolean resultGenerated=callableStatement.execute();
ResultSet resultSet=callableStatement.getResultSet();
boolean found=resultSet.next();
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return found;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : exists(int code) --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : exists(int code) --->"+exception.getMessage());
}
}
public boolean existsByUsername(String username,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
		{
		connection=DAOConnection.getConnection();	
		closeConnection=true;
		}
String job="{call operator_exists_by_username(?)}";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);
boolean resultGenerated=callableStatement.execute();
ResultSet resultSet=callableStatement.getResultSet();
boolean found=resultSet.next();
resultSet.close();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return found;
}catch(SQLException sqlException)
{
throw new DAOException("OperatorDAO : existsByUsername(String username) --->"+sqlException.getMessage());
} catch(Exception exception)
{
throw new DAOException("OperatorDAO : existsByUsername(String username) --->"+exception.getMessage());
}
}
}
