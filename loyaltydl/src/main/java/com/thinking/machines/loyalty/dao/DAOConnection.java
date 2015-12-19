package com.thinking.machines.loyalty.dao;
import java.sql.*;

public class DAOConnection
{
private DAOConnection()
{
}
public static Connection getConnection()
{
Connection connection=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/loyalty","loyalty","loyalty");
}
catch(Exception exception)
{
System.out.println(exception);
System.exit(0);
}
return connection;
}
}