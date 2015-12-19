package com.thinking.machines.loyalty.interfaces;
import java.io.*;
import java.util.*;
public interface AdminInterface extends Serializable , Comparable<AdminInterface>
{
public void setCode(int code);
public int getCode();

public void setName(String name);
public String getName();

public void setUsername(String username);
public String getUsername();

public void setPassword(String password);
public String getPassword();

public void setPasswordKey(String passwordKey);
public String getPasswordKey();

public void setEmailId(String emailId);
public String getEmailId();

public void setContactNumber(String contactNumber);
public String getContactNumber();

}