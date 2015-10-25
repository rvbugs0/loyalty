package com.thinking.machines.loyalty.interfaces;

import com.thinking.machines.loyalty.exceptions.*;

import java.util.*;

public interface StudentDAOInterface

{

public void add(StudentInterface studentInterface) throws DAOException;

public void update(StudentInterface studentInterface) throws DAOException;

public void remove(int customerCode) throws DAOException;

public StudentInterface getByCustomerCode(int customerCode) throws DAOException;

public ArrayList<StudentInterface> getAllByStream(String stream) throws DAOException;

public ArrayList<StudentInterface> getAll() throws DAOException;
public long getCount() throws DAOException;

public int getCountByStream(String stream) throws DAOException;

public boolean exists(int customerCode) throws DAOException;

public void removeAll() throws DAOException;

}