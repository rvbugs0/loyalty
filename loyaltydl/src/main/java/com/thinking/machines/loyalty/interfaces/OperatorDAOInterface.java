package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;
public interface OperatorDAOInterface
{
public void add(OperatorInterface operatorInterface,Connection connection) throws DAOException;


public ArrayList<OperatorInterface> getAll(Connection connection) throws DAOException;
public ArrayList<OperatorInterface> getAllByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException;
public OperatorInterface get(int code,Connection connection) throws DAOException;
public OperatorInterface getByName(String name,Connection connection) throws DAOException;
public OperatorInterface getByUsername(String username,Connection connection) throws DAOException;
public long getCount(Connection connection) throws DAOException;
public int getCountByName(String name,Connection connection) throws DAOException;
public int getCountByUsername(String username,Connection connection) throws DAOException;
public int getCountByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException;


public void removeAll(Connection connection) throws DAOException;
public void remove(int code,Connection connection) throws DAOException;
public void removeAllByVendorOutletCode(int vendorOutletCode,Connection connection) throws DAOException;
public void removeByUsername(String username,Connection connection) throws DAOException;
public void update(OperatorInterface operatorInterface,Connection connection) throws DAOException;
public boolean exists(int code,Connection connection) throws DAOException;
public boolean existsByUsername(String username,Connection connection) throws DAOException;
}
