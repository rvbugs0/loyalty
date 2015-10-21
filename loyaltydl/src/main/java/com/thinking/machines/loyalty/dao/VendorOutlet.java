package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
public class VendorOutlet implements VendorOutletInterface
{
	private int code;
	private int cityCode;
	private	String address;
	private int vendorCode;
	private ArrayList<String> contactNumbers;
	private String latitude;
	private String longitude;

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
public void setLongitude(String longitude)
{
	this.longitude=longitude;
}
public String getLongitude()
{
	return this.longitude;
}
public void setLatitude(String latitude)
{
	this.latitude=latitude;
}
public String getLatitude()
{
	return this.latitude;
}
public void setVendorCode(int vendorCode)
{
	this.vendorCode=vendorCode;
}
public int getVendorCode()
{
	return this.vendorCode;
}
public void setContactNumbers(ArrayList<String> contactNumbers)
{
	this.contactNumbers=contactNumbers;
}
public ArrayList<String> getContactNumbers()
{
	return this.contactNumbers;
}
public void setAddress(String address)
{
	this.address=address;
}
public String getAddress()
{
	return this.address;
}
public boolean equals(Object object)
{ 
if(!(object instanceof VendorOutletInterface))
{
return false;
}
VendorOutletInterface vendorOutletInterface;
vendorOutletInterface=(VendorOutletInterface)object;
return this.code==vendorOutletInterface.getCode();
}


}