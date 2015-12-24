package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetByCityCode extends HttpServlet
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
cityInterface=loyaltyApplication.getByCityCode(Integer.parseInt(rq.getParameter("code")));
cityInterface.setCode(Integer.parseInt(rq.getParameter("code")));
//System.out.println(code);

pw.println("{");
pw.println("\"success\":true,");
pw.println("\"code\":"+ cityInterface.getCode() );
pw.println(",\"name\":"+ "\""+cityInterface.getName()+"\"" );
pw.println(",\"state\":"+ "\""+cityInterface.getState() +"\"");
pw.println(",\"country\":"+ "\""+cityInterface.getCountry() +"\"");

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