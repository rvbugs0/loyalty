package com.thinking.machines.loyalty.dao;

import com.thinking.machines.loyalty.interfaces.*;

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
public boolean equalsForCustomer(Object object)

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


private int marriedCustomerCode;
private String spouseName;
private java.util.Date spouseDateOfBirth;
private java.util.Date anniversaryDate;
private String spouseOccupation;
private int numberOfGirlChild;
private int numberOfBoyChild;
public void setMarriedCustomerCode(int customerCode)
{
this.marriedCustomerCode=customerCode;
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


public int getMarriedCustomerCode()
{
return this.marriedCustomerCode;
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
public boolean equalsForMarriedDetails(Object object)

{ 

if(!(object instanceof MaritalDetailsInterface))

{

return false;

}

MaritalDetailsInterface maritalDetailsInterface;
maritalDetailsInterface=(MaritalDetailsInterface)object;

return this.marriedCustomerCode==maritalDetailsInterface.getCustomerCode();

}





private int studentCustomerCode;
private String stream;
private String courseDetails;
public void setStudentCustomerCode(int customerCode)
{
this.studentCustomerCode=customerCode;
}
public void setStream(String stream)
{
this.stream=stream;
}
public void setCourseDetails(String courseDetails)
{
this.courseDetails=courseDetails;
}

public int getStudentCustomerCode()
{
return this.studentCustomerCode;
}
public String getStream()
{
return this.stream;
}
public String getCourseDetails()
{
return this.courseDetails;
}

public boolean equalsForStudent(Object object)

{ 

if(!(object instanceof StudentInterface))

{

return false;

}

StudentInterface studentInterface;
studentInterface=(StudentInterface)object;

return this.studentCustomerCode==studentInterface.getCustomerCode();

}



}