package com.thinking.machines.loyalty.bl;

import java.util.*;
public class Operator implements OperatorBLInterface
{
	private int code;
	private String name;
	private int vendorOutletCode;
	
	private String username;
	private String password;
                 private String passwordKey;

public void setPasswordKey(String passwordKey)
{
	this.passwordKey=passwordKey;
}
public String getPasswordKey()
{
	return this.passwordKey;
}
public Operator()
{
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
public void setVendorOutletCode(int vendorOutletCode)
{
	this.vendorOutletCode=vendorOutletCode;
}
public int getVendorOutletCode()
{

	return this.vendorOutletCode;
}


}