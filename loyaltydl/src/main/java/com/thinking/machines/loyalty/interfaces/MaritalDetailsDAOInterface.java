package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;

public interface MaritalDetailsDAOInterface

{

public void add(MaritalDetailsInterface maritalDetailsInterface) throws DAOException;

public void update(MaritalDetailsInterface maritalDetailsInterface) throws DAOException;

public void remove(int customerCode) throws DAOException;

public MaritalDetailsInterface getByCustomerCode(int customerCode) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllBySpouseDateOfBirth(java.util.Date spouseDateOfBirth) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllByAnniversaryDate(java.util.Date anniversaryDate) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAllBySpouseOccupation(String spouseOccupation) throws DAOException;

public ArrayList<MaritalDetailsInterface> getAll() throws DAOException;
public long getCount() throws DAOException;

public int getCountBySpouseDateOfBirth(java.util.Date spouseDateOfBirth) throws DAOException;

public int getCountByAnniversaryDate(java.util.Date anniversaryDate) throws DAOException;

public int getCountBySpouseOccupation(String spouseOccupation) throws DAOException;

public boolean exists(int customerCode) throws DAOException;

public void removeAll() throws DAOException;

}