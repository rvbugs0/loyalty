package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;


import java.sql.*;public interface CustomerDAOInterface

{

public enum CustomerType{STUDENT,MARRIED,FEMALE,MALE};
public void add(CustomerInterface customerInterface,Connection connection) throws DAOException;

public void update(CustomerInterface customerInterface,Connection connection) throws DAOException;

public void remove(int code,Connection connection) throws DAOException;

public CustomerInterface getByCode(int code,Connection connection) throws DAOException;

public ArrayList<CustomerInterface> getAllByName(String name,Connection connection) throws DAOException;

public ArrayList<CustomerInterface> getAll(Connection connection) throws DAOException;
public ArrayList<CustomerInterface> getAllByCustomerType(CustomerType customerType,Connection connection) throws DAOException;

public ArrayList<CustomerInterface> getAllByOccupation(String occupation,Connection connection) throws DAOException;
public ArrayList<CustomerInterface> getAllByCity(int cityCode,Connection connection) throws DAOException;
public ArrayList<CustomerInterface> getAllByDateOfBirth(java.util.Date dateOfBirth,Connection connection) throws DAOException;
public long getCount(Connection connection) throws DAOException;

public int getCountByName(String name,Connection connection) throws DAOException;

public int getCountByCustomerType(CustomerType customerType,Connection connection) throws DAOException;

public int getCountByOccupation(String occupation,Connection connection) throws DAOException;

public int getCountByCity(int cityCode,Connection connection) throws DAOException;

public int getCountByDateOfBirth(java.util.Date dateOfBirth,Connection connection) throws DAOException;

public boolean exists(int code,Connection connection) throws DAOException;

public boolean existsByUsername(String username,Connection connection) throws DAOException;


public boolean existsByEmailId(String emailId,Connection connection) throws DAOException;
public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException;
public CustomerInterface getByUsername(String username,Connection connection) throws DAOException;

public CustomerInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException;

public CustomerInterface getByEmailId(String emailId,Connection connection) throws DAOException;
public void removeAll(Connection connection) throws DAOException;

}
