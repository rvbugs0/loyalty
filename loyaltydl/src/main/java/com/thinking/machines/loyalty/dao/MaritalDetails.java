package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
public class MaritalDetails implements MaritalDetailsInterface

{

private int customerCode;
private String spouseName;
private java.util.Date spouseDateOfBirth;
private java.util.Date anniversaryDate;
private String spouseOccupation;
private int numberOfGirlChild;
private int numberOfBoyChild;
public void setCustomerCode(int customerCode)
{
this.customerCode=customerCode;
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


public int getCustomerCode()
{
return this.customerCode;
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
public boolean equals(Object object)

{ 

if(!(object instanceof MaritalDetailsInterface))

{

return false;

}

MaritalDetailsInterface maritalDetailsInterface;
maritalDetailsInterface=(MaritalDetailsInterface)object;

return this.customerCode==maritalDetailsInterface.getCustomerCode();

}

/*
public int compareTo(MaritalDetailsInterface maritalDetailsInterface)
{
}
*/

}


	
