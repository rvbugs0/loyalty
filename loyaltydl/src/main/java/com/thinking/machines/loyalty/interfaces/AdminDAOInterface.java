package com.thinking.machines.loyalty.interfaces;
import com.thinking.machines.loyalty.exceptions.*;
import java.util.*;
import java.sql.*;

public interface AdminDAOInterface
{
	public void add(AdminInterface adminInterface,Connection connection) throws DAOException;
	public void update(AdminInterface adminInterface,Connection connection) throws DAOException;
	public void remove(int code,Connection connection) throws DAOException;
	
	
	public long getCount(Connection connection) throws DAOException;

	public AdminInterface getByName(String name,Connection connection) throws DAOException;
	public AdminInterface getByUsername(String username,Connection connection) throws DAOException;
	public AdminInterface getByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public AdminInterface getByCode(int code,Connection connection) throws DAOException;
	public AdminInterface getByEmailId(String emailId,Connection connection) throws DAOException;
	

	public boolean exists(int code,Connection connection) throws DAOException;
	public boolean existsByUsername(String username,Connection connection) throws DAOException;
	public boolean existsByEmailId(String emailId,Connection connection) throws DAOException;
	public boolean existsByContactNumber(String contactNumber,Connection connection) throws DAOException;
	public boolean existsByName(String name,Connection connection) throws DAOException;
}
 		