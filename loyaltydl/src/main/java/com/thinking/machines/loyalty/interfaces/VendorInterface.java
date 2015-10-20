package com.thinking.machines.loyalty.interfaces;
import java.io.*;
import java.util.*;
public interface VendorInterface extends Serializable , Comparable<VendorInterface>
{
public void setCode(int code);
public int getCode();

public void setName(String name);
public String getName();

public void setUsername(String username);
public String getUsername();

public void setPassword(String password);
public String getPassword();

public void setAddress(String address);
public String getAddress();

public void setCityCode(int cityCode);
public int getCityCode();

public void setEmailId(String emailId);
public String getEmailId();

public void setContactNumbers(ArrayList<String> contactNumbers);
public ArrayList<String> getContactNumbers();

}