package com.thinking.machines.loyalty.bl;
import com.thinking.machines.loyalty.bl.interfaces.*;
public class VendorOutlet implements VendorOutletInterface
{
private int code;
private int cityCode;
private	String address;
private int vendorCode;
private String contactNumber;
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
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
}
public String getContactNumber()
{
return this.contactNumber;
}
public void setAddress(String address)
{
this.address=address;
}
public String getAddress()
{
return this.address;
}


}

