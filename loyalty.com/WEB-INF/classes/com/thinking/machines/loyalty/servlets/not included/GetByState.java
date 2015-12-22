package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.manager.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetByState extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");

CityLoyaltyApplication cityLoyaltyApplication =new CityLoyaltyApplication();
ArrayList<CityInterface> cities=cityLoyaltyApplication.getByState(rq.getParameter("state"));

CityInterface cityInterface;
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