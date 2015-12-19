package com.thinking.machines.loyalty.interfaces;
import java.io.*;
public interface MaritalDetailsInterface extends Serializable 
// , Comparable<MaritalDetailsInterface>

{


public void setCustomerCode(int customerCode); 
public void setSpouseName(String spouseName); 
public void setSpouseDateOfBirth(java.util.Date dateOfBirth);
public void setAnniversaryDate(java.util.Date anniversaryDate);
public void setSpouseOccupation(String spouseOccupation); 
public void setNumberOfGirlChild(int numberOfGirlChild); 
public void setNumberOfBoyChild(int numberOfBoyChild); 



public int getCustomerCode(); 
public String getSpouseName(); 

public java.util.Date getSpouseDateOfBirth();

public java.util.Date getAnniversaryDate();
public String getSpouseOccupation(); 

public int getNumberOfGirlChild(); 

public int getNumberOfBoyChild(); 
}


