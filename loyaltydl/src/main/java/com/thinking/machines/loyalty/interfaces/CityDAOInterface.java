package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
public interface CityDAOInterface
{
public void add(CityInterface cityInterface) throws DAOException;
public void update(CityInterface cityInterface) throws DAOException;
public void remove(int code) throws DAOException;
public CityInterface getByCode(int code) throws DAOException;
public ArrayList<CityInterface> getByName(String name) throws DAOException;
public ArrayList<CityInterface> getAll() throws DAOException;
public void removeAll() throws DAOException;
public long getCount() throws DAOException;
public boolean exists(int code) throws DAOException;
//public boolean existsByName(String name) throws DAOException;
//public int getCountByName(String name) throws DAOException;
}