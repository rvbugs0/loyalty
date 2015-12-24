package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import java.text.*;//for SimpleDateFormat
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetAllCities extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
ArrayList<CityBLInterface>cities=loyaltyApplication.getAllCities();

CityBLInterface cityInterface;
int x=0;
pw.println("[");

while(x<cities.size())
{
cityInterface=cities.get(x);

pw.println("{");


pw.println("\"code\":"+ cityInterface.getCode() );
pw.println(",\"name\":"+ "\""+cityInterface.getName()+"\"" );
pw.println(",\"state\":"+ "\""+cityInterface.getState() +"\"");
pw.println(",\"country\":"+ "\""+cityInterface.getCountry() +"\"");

if(x<(cities.size()-1))
{
pw.println("},");
}
else
{
pw.println("}");
}

x++;
}

pw.println("]");

}catch(ApplicationException ae)
{
System.out.println(ae);

pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":"+"\""+ae+"\"");
pw.println("}");

}
catch(Exception e)
{
System.out.println(e);
}
}
}