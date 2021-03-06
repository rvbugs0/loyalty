package com.thinking.machines.loyalty.bl;
import com.thinking.machines.loyalty.bl.interfaces.*;
import java.util.*;

public class Vendor implements VendorBLInterface
{
	private int code;
	private String name;
	private int cityCode;
	private String emailId;
	private String username;
	private String password;
	private	String address;
	private String contactNumber;
	private String passwordKey;

public void setPasswordKey(String passwordKey)
{
	this.passwordKey=passwordKey;
}
public String getPasswordKey()
{
	return this.passwordKey;
}
public Vendor()
{
}
public void setAddress(String address)
{
	this.address=address;
}
public String getAddress()
{
	return this.address;
}
public void setContactNumber(String contactNumber)
{
	this.contactNumber=contactNumber;
}
public String getContactNumber()
{
return this.contactNumber;
}

public void setUsername(String username)
{
	this.username=username;
}
public String getUsername()
{
	return this.username;
}
public void setPassword(String password)
{
	this.password=password;
}	
public String getPassword()
{
	return this.password;
}

public void setName(String name)
{
	this.name=name;
}
public String getName()
{
	return this.name;
}
public void setCode(int code)
{
	this.code=code;
}
public int getCode()
{
	return this.code;
}
public void setCityCode(int cityCode)
{
	this.cityCode=cityCode;
}
public int getCityCode()
{

	return this.cityCode;
}
public void setEmailId(String emailId)
{
	this.emailId=emailId;
}
public String getEmailId()
{
	return this.emailId;
}



}
