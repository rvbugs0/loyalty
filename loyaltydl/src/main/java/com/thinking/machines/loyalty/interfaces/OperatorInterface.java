package com.thinking.machines.loyalty.interfaces;
import java.io.*;
public interface OperatorInterface extends Serializable,Comparable<OperatorInterface>
{
public void setCode(int code);
public void setVendorOutletCode(int vendorOutletCode);
public void setName(String name);
public void setUsername(String username);
public void setPassword(String password);
public void setPasswordKey(String passwordKey);
public int getCode();
public int getVendorOutletCode();
public String getName();
public String getUsername();
public String getPassword();
public String getPasswordKey();
}