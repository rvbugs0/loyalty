package com.thinking.machines.loyalty.bl;
import java.io.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
public class Customer implements CustomerInterface 
{
private int code;
private String name;
private String copyOfUsername;
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
private String spouseName;
private java.util.Date spouseDateOfBirth;
private java.util.Date anniversaryDate;
private String spouseOccupation;
private int numberOfGirlChild;
private int numberOfBoyChild;
private String stream;
private String courseDetails;

 public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;


}
public void setUsername(String username)
{
this.username=username;
this.copyOfUsername=this.username.toUpperCase();
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
public void setStream(String stream)
{
this.stream=stream;
}
public void setCourseDetails(String courseDetails)
{
this.courseDetails=courseDetails;
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

public void setSpouseName(String spouseName)
{
this.spouseName=spouseName;
}
public void setSpouseDateOfBirth(java.util.Date spouseDateOfBirth)
{
this.spouseDateOfBirth=spouseDateOfBirth;
}
public void setAnniversaryDate(java.util.Date anniversaryDate)
{
this.anniversaryDate=anniversaryDate;
}
public void setSpouseOccupation(String spouseOccupation)
{
this.spouseOccupation=spouseOccupation;
}
public void setNumberOfGirlChild(int numberOfGirlChild)
{
this.numberOfGirlChild=numberOfGirlChild;
}
public void setNumberOfBoyChild(int numberOfBoyChild)
{
this.numberOfBoyChild=numberOfBoyChild;
}



public String getSpouseName()
{
return this.spouseName;
}
public java.util.Date getSpouseDateOfBirth()
{return this.spouseDateOfBirth;
}
public java.util.Date getAnniversaryDate()
{return this.anniversaryDate;
}
public String getSpouseOccupation()
{return this.spouseOccupation;
}
public int getNumberOfGirlChild()
{return this.numberOfGirlChild;
}
public int getNumberOfBoyChild()
{return this.numberOfBoyChild;
}
public String getStream()
{
return this.stream;
}
public String getCourseDetails()
{
return this.courseDetails;
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

return this.copyOfUsername.compareTo(customer.copyOfUsername);

}


}

