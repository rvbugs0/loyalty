package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class VendorExistsByContactNumber extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
boolean exists=false;
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorBLInterface vendorInterface=new Vendor();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
String contactNumber=rq.getParameter("contactNumber");
exists=loyaltyApplication.vendorExistsByContactNumber(contactNumber);
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":"+exists);
pw.println("}");
}catch(ApplicationException ae)
{
pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":\""+ae.getMessage()+"\"");
pw.println("}");
}
catch(Exception e)
{
System.out.println(e);
}
}
}