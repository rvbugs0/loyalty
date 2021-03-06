package com.thinking.machines.loyalty.bl.interfaces;

import java.io.*;

public interface CustomerBLInterface extends Serializable , Comparable<CustomerBLInterface>

{
 public void setCode(int code);

public void setName(String name);
public void setUsername(String username);
public void setPassword(String password);
public void setPasswordKey(String passwordKey);
public void setPermanentAddress(String permanentAddress);
public void setCurrentAddress(String currentAddress);
public void setCityCode(int cityCode);
public void setDateOfBirth(java.util.Date dateOfBirth);
public void setGender(String gender);
public void setOccupation(String occupation);
public void setIsMarried(boolean isMarried);
public void setIsStudent(boolean isStudent);
public void setContactNumber(String contactNumber);
public void setEmailId(String emailId);
public int getCode();

public String getName();
public String getUsername();
public String getPassword();
public String getPasswordKey();
public String getPermanentAddress();
public String getCurrentAddress();
public int getCityCode();
public java.util.Date getDateOfBirth();
public String getGender();
public String getOccupation();
public boolean getIsMarried();
public boolean getIsStudent();
public String getContactNumber();
public String getEmailId();
public void setSpouseName(String spouseName); 
public void setSpouseDateOfBirth(java.util.Date dateOfBirth);
public void setAnniversaryDate(java.util.Date anniversaryDate);
public void setSpouseOccupation(String spouseOccupation); 
public void setNumberOfGirlChild(int numberOfGirlChild); 
public void setNumberOfBoyChild(int numberOfBoyChild); 
public String getSpouseName(); 

public java.util.Date getSpouseDateOfBirth();

public java.util.Date getAnniversaryDate();
public String getSpouseOccupation(); 

public int getNumberOfGirlChild(); 

public int getNumberOfBoyChild(); 

public void setStream(String stream);
public void setCourseDetails(String courseDetails);
public String getStream();
public String getCourseDetails();

}
