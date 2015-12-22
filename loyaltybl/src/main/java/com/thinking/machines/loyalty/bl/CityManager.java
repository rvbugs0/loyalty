package com.thinking.machines.loyalty.bl;
import java.util.*;
 import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
public class CityManager
{


public void add(CityBLInterface cityInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CityInterface city=new com.thinking.machines.loyalty.dao.City();
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
CityDAOInterface cityDAOInterface=new CityDAO();
cityDAOInterface.add(city,connection);
cityInterface.setCode(city.getCode());
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void update(CityBLInterface cityInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CityInterface city=new com.thinking.machines.loyalty.dao.City();
city.setCode(cityInterface.getCode());
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
CityDAOInterface cityDAOInterface=new CityDAO();
cityDAOInterface.update(city,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public CityBLInterface getByCityCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CityBLInterface city=new City();
CityDAOInterface cityDAOInterface=new CityDAO();
com.thinking.machines.loyalty.interfaces.CityInterface cityInterface=cityDAOInterface.getByCode(code,connection);
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
return city;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}





public ArrayList<CityBLInterface> getAllCities() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CityInterface> cityInterfaces;
ArrayList<CityBLInterface> cities= new ArrayList<CityBLInterface>();
CityDAOInterface cityDAOInterface=new CityDAO();
cityInterfaces=cityDAOInterface.getAll(connection);
CityBLInterface city;
com.thinking.machines.loyalty.interfaces.CityInterface cityInterface;
int x=0;
while(x<cityInterfaces.size())
{
cityInterface=cityInterfaces.get(x);
city=new City();
city.setCode(cityInterface.getCode());
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
cities.add(city);
x++;
}
return cities;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

/*
public ArrayList<CityBLInterface> getByState(String state) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CityInterface> cityInterfaces;
ArrayList<CityBLInterface> cities= new ArrayList<CityBLInterface>();
CityDAOInterface cityDAOInterface=new CityDAO();
cityInterfaces=cityDAOInterface.getByState(state,connection);
CityBLInterface city;
com.thinking.machines.loyalty.interfaces.CityInterface cityInterface;
int x=0;
while(x<cityInterfaces.size())
{
cityInterface=cityInterfaces.get(x);
city=new City();
city.setCode(cityInterface.getCode());
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
cities.add(city);
x++;
}
return cities;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}




public ArrayList<CityBLInterface> getByCountry(String country) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CityInterface> cityInterfaces;
ArrayList<CityBLInterface> cities= new ArrayList<CityBLInterface>();
CityDAOInterface cityDAOInterface=new CityDAO();
cityInterfaces=cityDAOInterface.getByCountry(country,connection);
CityBLInterface city;
com.thinking.machines.loyalty.interfaces.CityInterface cityInterface;
int x=0;
while(x<cityInterfaces.size())
{
cityInterface=cityInterfaces.get(x);
city=new City();
city.setCode(cityInterface.getCode());
city.setName(cityInterface.getName());
city.setState(cityInterface.getState());
city.setCountry(cityInterface.getCountry());
cities.add(city);
x++;
}
return cities;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


*/

public long getCount() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CityDAOInterface cityDAOInterface=new CityDAO();
long count=cityDAOInterface.getCount(connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


/*

public int getCountByState(String state) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CityDAOInterface cityDAOInterface=new CityDAO();
int count=cityDAOInterface.getCountByState(state,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public int  getCountByCountry(String country) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CityDAOInterface cityDAOInterface=new CityDAO();
int count=cityDAOInterface.getCountByCountry(country,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

*/

public void remove(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CityDAOInterface cityDAOInterface=new CityDAO();
cityDAOInterface.remove(code,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


}