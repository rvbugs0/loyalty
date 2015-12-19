package com.thinking.machines.loyalty.interfaces;
import java.io.*;
public interface StudentInterface extends Serializable
// , Comparable<StudentInterface>

{
public void setCustomerCode(int customerCode);
public void setStream(String stream);
public void setCourseDetails(String courseDetails);

public int getCustomerCode();
public String getStream();
public String getCourseDetails();

}








