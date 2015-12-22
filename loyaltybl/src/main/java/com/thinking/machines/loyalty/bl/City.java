package com.thinking.machines.loyalty.bl;

import java.util.*;
public class City implements CityBLInterface
{
int code;
String name;
String state;
String country;
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setState(String state)
{
this.state=state;
}
public String getState()
{
return this.state;
}
public void setCountry(String country)
{
this.country=country;
}
public String getCountry()
{
return this.country;
}
public boolean equals(Object object)
{
if(!(object instanceof CityBLInterface)) return false;
City city;
city=(City)object;
return this.code==city.code;
}
public int compareTo(CityBLInterface cityInterface)
{
return this.name.compareTo(cityInterface.getName());
}

}