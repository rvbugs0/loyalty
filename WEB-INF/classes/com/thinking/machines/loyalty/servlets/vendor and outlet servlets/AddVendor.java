package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class AddVendor extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorBLInterface vendorInterface=new Vendor();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
vendorInterface.setName(rq.getParameter("name"));
vendorInterface.setUsername(rq.getParameter("username"));
vendorInterface.setPassword(rq.getParameter("password"));
vendorInterface.setPasswordKey(rq.getParameter("password"));
vendorInterface.setAddress(rq.getParameter("address"));
vendorInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode")));
vendorInterface.setContactNumber(rq.getParameter("contactNumber"));
vendorInterface.setEmailId(rq.getParameter("emailId"));
loyaltyApplication.addVendor(vendorInterface);
int code=vendorInterface.getCode();
System.out.println(code);
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"code\":"+code);
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