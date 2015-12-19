package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;
public interface CityDAOInterface
{
public void add(CityInterface cityInterface,Connection connection) throws DAOException;
public void update(CityInterface cityInterface,Connection connection) throws DAOException;
public void remove(int code,Connection connection) throws DAOException;
public CityInterface getByCode(int code,Connection connection) throws DAOException;
public ArrayList<CityInterface> getByName(String name,Connection connection) throws DAOException;
public ArrayList<CityInterface> getAll(Connection connection) throws DAOException;
public void removeAll(Connection connection) throws DAOException;
public long getCount(Connection connection) throws DAOException;
public boolean exists(int code,Connection connection) throws DAOException;
//public boolean existsByName(String name) throws DAOException;
//public int getCountByName(String name) throws DAOException;
}