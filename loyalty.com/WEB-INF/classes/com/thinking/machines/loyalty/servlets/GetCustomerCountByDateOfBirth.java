package com.thinking.machines.loyalty.servlets;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import java.text.*;//for SimpleDateFormat
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetCustomerCountByDateOfBirth extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
long count=loyaltyApplication.getCustomerCountByDateOfBirth(dateFormat.parse(rq.getParameter("dateOfBirth")));
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"count\":"+count);
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