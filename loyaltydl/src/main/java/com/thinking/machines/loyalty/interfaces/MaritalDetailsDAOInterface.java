package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;


import java.sql.*;
public interface MaritalDetailsDAOInterface

{

public void add(MaritalDetailsInterface maritalDetailsInterface,Connection connection) throws DAOException;

public void update(MaritalDetailsInterface maritalDetailsInterface,Connection connection) throws DAOException;

public void remove(int customerCode,Connection connection) throws DAOException;

public MaritalDetailsInterface getByCustomerCode(int customerCode,Connection connection) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllBySpouseDateOfBirth(java.util.Date spouseDateOfBirth,Connection connection) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllByAnniversaryDate(java.util.Date anniversaryDate,Connection connection) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllBySpouseOccupation(String spouseOccupation,Connection connection) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAll(Connection connection) throws DAOException;
public long getCount(Connection connection) throws DAOException;

public int getCountBySpouseDateOfBirth(java.util.Date spouseDateOfBirth,Connection connection) throws DAOException;

public int getCountByAnniversaryDate(java.util.Date anniversaryDate,Connection connection) throws DAOException;

public int getCountBySpouseOccupation(String spouseOccupation,Connection connection) throws DAOException;

public boolean exists(int customerCode,Connection connection) throws DAOException;

public void removeAll(Connection connection) throws DAOException;

}