package com.thinking.machines.loyalty.interfaces;
import java.io.*;
public interface CityInterface extends Serializable , Comparable<CityInterface>
{
public void setName(String name);
public void setState(String state);
public void setCode(int code);
public void setCountry(String country);
public int getCode();
public String getName();
public String getState();
public String getCountry();

}