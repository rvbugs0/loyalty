package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
public class Vendor implements VendorInterface
{
	private int code;
	private String name;
	private int cityCode;
	private String emailId;
	private String username;
	private String password;
	private	String address;
	private ArrayList<String> contactNumbers;
	private String copyOfName;

public Vendor()
{
	contactNumbers=new ArrayList<String>();
}
public void setAddress(String address)
{
	this.address=address;
}
public String getAddress()
{
	return this.address;
}
public void setContactNumbers(ArrayList<String> contactNumbers)
{
	this.contactNumbers=contactNumbers;
}
public ArrayList<String> getContactNumbers()
{
return this.contactNumbers;
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
	this.copyOfName=this.name.toUpperCase();
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
public boolean equals(Object object)
{ 
if(!(object instanceof VendorInterface))
{
return false;
}
VendorInterface vendorInterface;
vendorInterface=(VendorInterface)object;
return this.code==vendorInterface.getCode();
}

public int compareTo(VendorInterface vendorInterface)
{
Vendor vendor;
vendor=(Vendor)vendorInterface;
return this.copyOfName.compareTo(vendor.copyOfName);
}

}