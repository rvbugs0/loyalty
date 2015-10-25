package com.thinking.machines.loyalty.interfaces;

import java.io.*;

public class Customer implements CustomerInterface 
{
private int code;
private String name;
private String copyOfName;
private String username;
private String password;
private String passwordKey;
private String permanentAddress;
private String currentAddress;
private int cityCode;
private java.util.Date dateOfBirth;
private String gender;
private String occupation;
private boolean isMarried;
private boolean isStudent;
private String contactNumber;
private String emailId;
 public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;
this.copyOfName=this.name.toUpperCase();

}
public void setUsername(String username)
{
this.username=username;
}
public void setPassword(String password)
{
this.password=password;
}
public void setPasswordKey(String passwordKey)
{
this.passwordKey=passwordKey;
}
public void setPermanentAddress(String permanentAddress)
{
this.permanentAddress=permanentAddress;
}
public void setCurrentAddress(String currentAddress)
{
this.currentAddress=currentAddress;
}
public void setCityCode(int cityCode)
{
this.cityCode=cityCode;
}
public void setDateOfBirth(java.util.Date dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public void setGender(String gender)
{
this.gender=gender;
}
public void setOccupation(String occupation)
{
this.occupation=occupation;
}
public void setIsMarried(boolean isMarried)
{
this.isMarried=isMarried;
}
public void setIsStudent(boolean isStudent)
{
this.isStudent=isStudent;
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
public String getPasswordKey()
{
return this.passwordKey;
}
public String getPermanentAddress()
{
return this.permanentAddress;
}
public String getCurrentAddress()
{
return this.currentAddress;
}
public int getCityCode()
{
return this.cityCode;
}
public java.util.Date getDateOfBirth()
{
return this.dateOfBirth;
}
public String getGender()
{
return this.gender;
}
public String getOccupation()
{
return this.occupation;
}
public boolean getIsMarried()
{
return this.isMarried;
}
public boolean getIsStudent()
{
return this.isStudent;
}
public String getContactNumber()
{
return this.contactNumber;
}
public String getEmailId()
{
return this.emailId;
}
public boolean equals(Object object)

{ 

if(!(object instanceof CustomerInterface))

{

return false;

}

CustomerInterface customerInterface;
customerInterface=(CustomerInterface)object;

return this.code==customerInterface.getCode();

}

public int compareTo(CustomerInterface customerInterface)

{

Customer customer;

customer=(Customer)customerInterface;

return this.copyOfName.compareTo(customer.copyOfName);

}


}

