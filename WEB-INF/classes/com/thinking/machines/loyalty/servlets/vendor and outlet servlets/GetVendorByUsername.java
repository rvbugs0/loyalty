package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetVendorByUsername extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
VendorBLInterface vendorInterface;
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
String username=rq.getParameter("username");
vendorInterface=loyaltyApplication.getVendorByUsername(username);
pw.println("{");
pw.println("\"success\":true,");
pw.print("\"Vendor\":");
pw.print("{\"code\":"+vendorInterface.getCode());
pw.print(",\"name\":\""+vendorInterface.getName()+"\"");
pw.print(",\"username\":\""+vendorInterface.getUsername()+"\"");
pw.print(",\"password\":\""+vendorInterface.getPassword()+"\"");
pw.print(",\"passwordKey\":\""+vendorInterface.getPasswordKey()+"\"");
pw.print(",\"address\":\""+vendorInterface.getAddress()+"\"");
pw.print(",\"cityCode\":"+vendorInterface.getCityCode());
pw.print(",\"contactNumber\":\""+vendorInterface.getContactNumber()+"\"");
pw.print(",\"emailId\":\""+vendorInterface.getEmailId()+"\"");
pw.println("}");
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