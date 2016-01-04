package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import java.text.*;//for SimpleDateFormat
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
public class UpdateCity extends HttpServlet
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

cityInterface.setCode(Integer.parseInt(rq.getParameter("code").trim()));
cityInterface.setName(rq.getParameter("name").trim());
cityInterface.setState(rq.getParameter("state").trim());
cityInterface.setCountry(rq.getParameter("country").trim());
loyaltyApplication.updateCity(cityInterface);
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":\"updated\"");
pw.println("}");

}catch(ApplicationException ae)
{

System.out.println(ae);

pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":"+"\""+ae+"\"");
pw.println("}");

}catch(IOException ioe)
{
System.out.println(ioe);
}
}}