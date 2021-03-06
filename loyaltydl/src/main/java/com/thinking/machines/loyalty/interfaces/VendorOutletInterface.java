package com.thinking.machines.loyalty.interfaces;
import java.io.*;
import java.util.*;
public interface VendorOutletInterface extends Serializable 
{
public void setCode(int code);
public int getCode();

public void setCityCode(int cityCode);
public int getCityCode();

public void setContactNumber(String contactNumber);
public String getContactNumber();

public void setAddress(String address);
public String getAddress();

public void setLatitude(String latitude);
public String getLatitude();

public void setLongitude(String longitude);
public String getLongitude();

public void setVendorCode(int vendorCode);
public int getVendorCode();

}