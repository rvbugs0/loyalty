package com.thinking.machines.loyalty.manager.exceptions;
import java.io.*;
public class ApplicationException extends Exception implements Serializable
{
private String message;
public ApplicationException()
{
 this.message=null;
}
public ApplicationException(String message)
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
return "com.thinking.machines.loyalty.manager.exceptions.ApplicationException";
}
 else
{
return "com.thinking.machines.loyalty.manager.exceptions.ApplicationException : "+this.message;
}
}
}