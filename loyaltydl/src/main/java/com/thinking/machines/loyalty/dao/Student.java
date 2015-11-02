package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
public class Student implements StudentInterface

{
	
private int customerCode;
private String stream;
private String courseDetails;
public void setCustomerCode(int customerCode)
{
this.customerCode=customerCode;
}
public void setStream(String stream)
{
this.stream=stream;
}
public void setCourseDetails(String courseDetails)
{
this.courseDetails=courseDetails;
}

public int getCustomerCode()
{
return this.customerCode;
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

if(!(object instanceof StudentInterface))

{

return false;

}

StudentInterface studentInterface;
studentInterface=(StudentInterface)object;

return this.customerCode==studentInterface.getCustomerCode();

}

/*
public int compareTo(StudentInterface studentInterface)
{
}
*/
}