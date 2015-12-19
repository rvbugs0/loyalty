package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
public class Admin implements AdminInterface
{
	private int code;
	private String name;
	private String username;
	private String password;
	private String passwordKey;
	private String contactNumber;
	private String emailId;
	private String copyOfName;	
public void setName(String name)
{
	this.name=name;
	this.copyOfName=this.name.toUpperCase();
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

public boolean equals(Object object)
{ 
if(!(object instanceof AdminInterface))
{
return false;
}
AdminInterface adminInterface;
adminInterface=(AdminInterface)object;
return this.code==adminInterface.getCode();
}
public int compareTo(AdminInterface adminInterface)
{
Admin admin;
admin=(Admin)adminInterface;
return this.copyOfName.compareTo(admin.copyOfName);
}

}