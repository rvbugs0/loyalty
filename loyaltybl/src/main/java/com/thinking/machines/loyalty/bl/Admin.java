package com.thinking.machines.loyalty.bl;
import com.thinking.machines.loyalty.bl.interfaces.*;
public class Admin implements AdminInterface
{
	private int code;
	private String name;
	private String username;
	private String password;
	private String passwordKey;
	private String contactNumber;
	private String emailId;
public void setName(String name)
{
	this.name=name;
}
public void setUsername(String username)
{
	this.username=username;
}
public void setCode(int code)
{
	this.code=code;
}
public void setPassword(String password)
{
	this.password=password;
}
public void setPasswordKey(String passwordKey)
{
	this.passwordKey=passwordKey;
}
public void setContactNumber(String contactNumber)
{
	this.contactNumber=contactNumber;
}
public void setEmailId(String emailId)
{
	this.emailId=emailId;
}


public int getCode()
{
	return this.code;
}
public String getName()
{
	return this.name;
}
public String getUsername()
{
	return this.username;
}

public String getPassword()
{
	return this.password;
}
public String getContactNumber()
{
	return this.contactNumber;
}
public String getPasswordKey()
{
	return this.passwordKey;
}
public String getEmailId()
{
	return this.emailId;
}

}