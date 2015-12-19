package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;

import java.sql.*;
public interface StudentDAOInterface

{

public void add(StudentInterface studentInterface,Connection connection) throws DAOException;

public void update(StudentInterface studentInterface,Connection connection) throws DAOException;

public void remove(int customerCode,Connection connection) throws DAOException;

public StudentInterface getByCustomerCode(int customerCode,Connection connection) throws DAOException;

public ArrayList<StudentInterface> getAllByStream(String stream,Connection connection) throws DAOException;

public ArrayList<StudentInterface> getAll(Connection connection) throws DAOException;
public long getCount(Connection connection) throws DAOException;

public int getCountByStream(String stream,Connection connection) throws DAOException;

public boolean exists(int customerCode,Connection connection) throws DAOException;

public void removeAll(Connection connection) throws DAOException;

}