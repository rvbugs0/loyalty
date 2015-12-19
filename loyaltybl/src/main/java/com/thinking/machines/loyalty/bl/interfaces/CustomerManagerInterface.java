package com.thinking.machines.loyalty.bl.interfaces;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;

public interface CustomerManagerInterface extends Serializable
{
public void add(CustomerInterface customerInterface) throws BLException;
public void update(CustomerInterface customerInterface) throws BLException;
public void getByCode(int code) throws BLException;
public ArrayList<CustomerInterface> getAll() throws BLException;
public ArrayList<CustomerInterface> getAllByName(String name) throws BLException;
public ArrayList<CustomerInterface> getAllByOccupation(String occupation) throws BLException;
public ArrayList<CustomerInterface> getAllByCityCode(int cityCode) throws BLException;
public ArrayList<CustomerInterface> getAllByDateOfBirth(java.util.Date dateOfBirth) throws BLException;
public ArrayList<CustomerInterface> getAllByCustomerType(com.thinking.machines.loyalty.interfaces.CustomerDAOInterface.CustomerType customerType) throws BLException;
public int getCountByName(String name) throws BLException;
public long getCount() throws BLException;
public int getCountByOccupation(String occupation) throws BLException;
public int getCountByCity(int cityCode) throws BLException;
public int getCountByDateOfBirth(java.util.Date dateOfBirth) throws BLException;
//public boolean exists(int code) throws BLException;
//public boolean existsByUsername(String username) throws BLException;
//public boolean existsByEmailId(String emailId) throws BLException;
//public boolean existsByContactNumber(String contactNumber) throws BLException;
public void removeAll() throws BLException;
public void remove(int code) throws BLException;
}
