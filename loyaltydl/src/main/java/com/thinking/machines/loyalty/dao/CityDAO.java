package com.thinking.machines.loyalty.dao;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
public class CityDAO implements CityDAOInterface
{

//tested	
public void add(CityInterface cityInterface,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call add_city(?,?,?,?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,cityInterface.getName());
callableStatement.setString(2,cityInterface.getState());
callableStatement.setString(3,cityInterface.getCountry());
callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
callableStatement.execute();
//int code=callableStatement.getInt(4);
callableStatement.close();
//System.out.println(code);
if(closeConnection)
{
	connection.close();
}
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> add() --> "+exception.getMessage());
}
}

//tested
public void update(CityInterface cityInterface,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}
if(!exists(cityInterface.getCode(),connection))
{
throw new DAOException("CityDAO : update() --> Invalid City Code :"+cityInterface.getCode());
}
	
String job="{ call update_city(?,?,?,?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,cityInterface.getCode());
callableStatement.setString(2,cityInterface.getName());
callableStatement.setString(3,cityInterface.getState());
callableStatement.setString(4,cityInterface.getCountry());
callableStatement.execute();
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> update() --> "+exception.getMessage());
}
}

//tested
public CityInterface getByCode(int code,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call get_city_by_code(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("CityDAO : getByCode() --> No ResultSet object");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
	resultSet.close();
	callableStatement.close();
	connection.close();
	throw new DAOException("CityDAO : getByCode() --> Invalid Code "+code);
}
CityInterface cityInterface=new City();
cityInterface.setCode(resultSet.getInt("code"));
cityInterface.setName(resultSet.getString("name").trim());
cityInterface.setState(resultSet.getString("state").trim());
cityInterface.setCountry(resultSet.getString("country").trim());
resultSet.close();
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
return cityInterface;
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> getByCode() --> "+exception.getMessage());
}
}


//tested
public ArrayList<CityInterface> getByName(String name,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call get_cities_by_name(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,name);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("CityDAO : getByName() --> No ResultSet object");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
	resultSet.close();
	callableStatement.close();
	connection.close();
	throw new DAOException("CityDAO : getByName() --> Invalid Name "+name);
}
ArrayList<CityInterface> cities;
cities=new ArrayList<CityInterface>();
CityInterface cityInterface; 
do
{
cityInterface=new City();
cityInterface.setCode(resultSet.getInt("code"));
cityInterface.setName(resultSet.getString("name").trim());
cityInterface.setState(resultSet.getString("state").trim());
cityInterface.setCountry(resultSet.getString("country").trim());
cities.add(cityInterface);
}while(resultSet.next());
resultSet.close();
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
return cities;
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> getByName() --> "+exception.getMessage());
}
}


//tested
public ArrayList<CityInterface> getAll(Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call get_all_cities() }";
CallableStatement callableStatement=connection.prepareCall(job);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("CityDAO : getAll() --> No ResultSet object");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
	resultSet.close();
	callableStatement.close();
	connection.close();
	throw new DAOException("CityDAO : getAll() --> No records ");
}

ArrayList<CityInterface> cities;
cities=new ArrayList<CityInterface>();
CityInterface cityInterface; 
do
{
cityInterface=new City();
cityInterface.setCode(resultSet.getInt("code"));
cityInterface.setName(resultSet.getString("name").trim());
cityInterface.setState(resultSet.getString("state").trim());
cityInterface.setCountry(resultSet.getString("country").trim());
cities.add(cityInterface);
}while(resultSet.next());
resultSet.close();
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
return cities;
}catch(SQLException sqlException)
{
throw new DAOException("CityDAO : getAll() --> "+sqlException.getMessage());
} 
catch(Exception exception)
{
throw new DAOException("CityDAO : getAll() --> "+exception.getMessage());
}
}

/*
public int getCountByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_city_count_by_name(?,?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,name);
callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
callableStatement.execute();
int count=callableStatement.getInt(2);
callableStatement.close();
connection.close();
return count;
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> getCountByName() --> "+exception.getMessage());
}
}
*/

//tested
public boolean exists(int code,Connection connection) throws DAOException
{
boolean closeConnection=false;
try
{
boolean exists=false;
	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call city_exists_by_code(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,code);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("exists() --> No records in generated result");
}
ResultSet resultSet=callableStatement.getResultSet();
exists=resultSet.next();
resultSet.close();
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
return exists;
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> exists() --> "+exception.getMessage());
}
}


//tested
public long getCount(Connection connection) throws DAOException
{
try
{
boolean closeConnection=false;	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}	
String job="{ call get_city_count(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
callableStatement.execute();
long count=callableStatement.getInt(1);
callableStatement.close();
if(closeConnection)
{
	connection.close();
}
return count;
}
catch(Exception exception)
{

throw new DAOException("CityDAO --> getCount() --> "+exception.getMessage());
}
}

/*
public boolean existsByName(String name) throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
String job="{ call city_exists_by_name(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,name);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("existsByName() --> No records in generated result");
}
ResultSet resultSet=callableStatement.getResultSet();
exists=resultSet.next();
resultSet.close();
callableStatement.close();
connection.close();
return exists;
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> existsByName() --> "+exception.getMessage());
}
}
*/

public void removeAll(Connection connection) throws DAOException
{
try
{
boolean closeConnection=false;	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}


if(closeConnection)
{
	connection.close();
}	
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> removeAll() --> "+exception.getMessage());
}
}


public void remove(int code,Connection connection) throws DAOException
{
try
{
boolean closeConnection=false;	
if(connection==null)
{
connection=DAOConnection.getConnection();	
closeConnection=true;
}


if(closeConnection)
{
	connection.close();
}	
}
catch(Exception exception)
{
throw new DAOException("CityDAO --> remove() --> "+exception.getMessage());
}

}


}