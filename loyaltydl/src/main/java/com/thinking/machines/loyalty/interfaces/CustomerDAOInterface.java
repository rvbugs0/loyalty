package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;

public interface CustomerDAOInterface

{

public enum CustomerType{STUDENT,MARRIED,FEMALE,MALE};
public void add(CustomerInterface customerInterface) throws DAOException;

public void update(CustomerInterface customerInterface) throws DAOException;

public void remove(int code) throws DAOException;

public CustomerInterface getByCode(int code) throws DAOException;

public ArrayList<CustomerInterface> getAllByName(String name) throws DAOException;

public ArrayList<CustomerInterface> getAll() throws DAOException;
public ArrayList<CustomerInterface> getAllByCustomerType(CustomerType customerType) throws DAOException;

public ArrayList<CustomerInterface> getAllByOccupation(String occupation) throws DAOException;
public ArrayList<CustomerInterface> getAllByCity(int cityCode) throws DAOException;
public ArrayList<CustomerInterface> getAllByDateOfBirth(java.util.Date dateOfBirth) throws DAOException;
public long getCount() throws DAOException;

public int getCountByName(String name) throws DAOException;

public int getCountByCustomerType(CustomerType customerType) throws DAOException;

public int getCountByOccupation(String occupation) throws DAOException;

public int getCountByCity(int cityCode) throws DAOException;

public int getCountByDateOfBirth(java.util.Date dateOfBirth) throws DAOException;

public boolean exists(int code) throws DAOException;

public boolean existsByUsername(String username) throws DAOException;


public boolean existsByEmailId(String emailId) throws DAOException;
public boolean existsByContactNumber(String contactNumber) throws DAOException;
public void removeAll() throws DAOException;

}
