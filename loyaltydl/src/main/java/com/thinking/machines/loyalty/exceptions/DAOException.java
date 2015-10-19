package com.thinking.machines.loyalty.exceptions;
import java.io.*;
public class DAOException extends Exception implements Serializable
{
private String message;
public DAOException()
{
this.message=null;
}
public DAOException(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public String toString()
{
if(this.message==null)
{
return "com.thinking.machines.loyalty.exceptions.DAOException";
}
else
{
return "com.thinking.machines.loyalty.exceptions.DAOException"+this.message;
}
}

}