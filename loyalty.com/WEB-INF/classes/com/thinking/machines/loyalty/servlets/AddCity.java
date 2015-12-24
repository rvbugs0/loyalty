package com.thinking.machines.loyalty.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class AddCity extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
CityBLInterface cityInterface=new City();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
cityInterface.setName(rq.getParameter("name"));
cityInterface.setState(rq.getParameter("state"));
cityInterface.setCountry(rq.getParameter("country"));
loyaltyApplication.addCity(cityInterface);
int code=cityInterface.getCode();
//System.out.println(code);

pw.println("{");
pw.println("\"success\":true,");
pw.println("\"code\":"+code);
pw.println("}");
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