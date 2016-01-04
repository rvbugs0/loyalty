package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class UpdateVendor extends HttpServlet
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
vendorInterface.setCode(Integer.parseInt(rq.getParameter("code").trim()));
vendorInterface.setName(rq.getParameter("name").trim());
vendorInterface.setUsername(rq.getParameter("username").trim());
vendorInterface.setPassword(rq.getParameter("password").trim());
vendorInterface.setPasswordKey(rq.getParameter("password").trim());
vendorInterface.setAddress(rq.getParameter("address").trim());
vendorInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode").trim()));
vendorInterface.setContactNumber(rq.getParameter("contactNumber").trim());
vendorInterface.setEmailId(rq.getParameter("emailId").trim());
loyaltyApplication.updateVendor(vendorInterface);
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":\"updated\"");
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