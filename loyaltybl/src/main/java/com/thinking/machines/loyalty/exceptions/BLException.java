package com.thinking.machines.loyalty.exceptions;
import java.io.*;
public class BLException extends Exception implements Serializable
{
private String message;
public BLException()
{
this.message=null;
}
public BLException(String message)
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
return "com.thinking.machines.loyalty.exceptions.BLException";
}
else
{
return "com.thinking.machines.loyalty.exceptions.BLException"+this.message;
}
}

}