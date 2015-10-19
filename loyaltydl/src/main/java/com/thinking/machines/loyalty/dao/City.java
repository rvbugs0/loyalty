package com.thinking.machines.loyalty.dao;
import com.thinking.machines.loyalty.interfaces.*;
public class City implements CityInterface
{
	private int code;
	private String name;
	private String state;
	private String country;
	private String copyOfName;
public void setName(String name)
{
	this.name=name;
	this.copyOfName=this.name.toUpperCase();
}
public void setState(String state)
{
	this.state=state;
}
public void setCode(int code)
{
	this.code=code;
}
public void setCountry(String country)
{
	this.country=country;
}
public int getCode()
{
	return this.code;
}
public String getName()
{
	return this.name;
}
public String getState()
{
	return this.state;
}
public String getCountry()
{
return this.country;
}
public boolean equals(Object object)
{ 
if(!(object instanceof CityInterface))
{
return false;
}
CityInterface cityInterface;
cityInterface=(CityInterface)object;
return this.code==cityInterface.getCode();
}
public int compareTo(CityInterface cityInterface)
{
City city;
city=(City)cityInterface;
return this.copyOfName.compareTo(city.copyOfName);
}

}