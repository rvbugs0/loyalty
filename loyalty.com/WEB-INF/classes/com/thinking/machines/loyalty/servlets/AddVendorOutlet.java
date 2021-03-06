package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class AddVendorOutlet extends HttpServlet
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
try
{
vendorOutletInterface.setVendorCode(Integer.parseInt(rq.getParameter("vendorCode").trim()));	
vendorOutletInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode").trim()));
}
catch(Exception e)
{
throw new ApplicationException(e.getMessage());	
}
vendorOutletInterface.setAddress(rq.getParameter("address").trim());
vendorOutletInterface.setLatitude(rq.getParameter("latitude").trim());
vendorOutletInterface.setLongitude(rq.getParameter("longitude").trim());

vendorOutletInterface.setContactNumber(rq.getParameter("contactNumber").trim());

loyaltyApplication.addVendorOutlet(vendorOutletInterface);
int code=vendorOutletInterface.getCode();
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