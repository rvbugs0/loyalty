package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class UpdateVendorOutlet extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorOutletBLInterface vendorOutletInterface=new VendorOutlet();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
vendorOutletInterface.setCode(Integer.parseInt(rq.getParameter("code")));
vendorOutletInterface.setVendorCode(Integer.parseInt(rq.getParameter("vendorCode")));
vendorOutletInterface.setAddress(rq.getParameter("address"));
vendorOutletInterface.setLatitude(rq.getParameter("latitude"));
vendorOutletInterface.setLongitude(rq.getParameter("longitude"));
vendorOutletInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode")));
vendorOutletInterface.setContactNumber(rq.getParameter("contactNumber"));
loyaltyApplication.updateVendorOutlet(vendorOutletInterface);
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