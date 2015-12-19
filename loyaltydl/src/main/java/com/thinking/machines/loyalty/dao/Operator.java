package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
public class Operator implements OperatorInterface
{
private int code;
private String name;
private String copyOfName;
private int vendorOutletCode;
private String username;
private String copyOfUsername;
private String password;
private String passwordKey;
public void setCode(int code)
{
this.code=code;
}
public void setVendorOutletCode(int vendorOutletCode)
{
this.vendorOutletCode=vendorOutletCode;
}
public void setName(String name)
{
this.name=name;
this.copyOfName=name.toUpperCase();
}
public void setUsername(String username)
{
this.username=username;
this.copyOfUsername=username.toUpperCase();
}
public void setPassword(String password)
{
this.password=password;
}
public void setPasswordKey(String passwordKey)
{
this.passwordKey=passwordKey;
}
public int getCode()
{
return this.code;
}
public int getVendorOutletCode()
{
return this.vendorOutletCode;
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
public String getPasswordKey()
{
return this.passwordKey;
}
public boolean equals(Object object)
{ if(!(object instanceof OperatorInterface))
{
return false;
}
OperatorInterface operatorInterface;
operatorInterface=(OperatorInterface)object;
return this.code==operatorInterface.getCode();
}
public int compareTo(OperatorInterface operatorInterface)
{
Operator operator;
operator=(Operator)operatorInterface;
return this.copyOfName.compareTo(operator.copyOfName);
}
}