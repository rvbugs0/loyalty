package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetVendorOutletByCode extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
VendorOutletBLInterface vendorOutletInterface;
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
int code=Integer.parseInt(rq.getParameter("code"));
vendorOutletInterface=loyaltyApplication.getVendorOutletByCode(code);
pw.println("{");
pw.println("\"success\":true,");
pw.print("\"VendorOutlet\":");
pw.print("{\"code\":"+vendorOutletInterface.getCode());
pw.print(",\"vendorCode\":"+vendorOutletInterface.getVendorCode());
pw.print(",\"address\":\""+vendorOutletInterface.getAddress()+"\"");
pw.print(",\"latitude\":\""+vendorOutletInterface.getLatitude()+"\"");
pw.print(",\"longitude\":\""+vendorOutletInterface.getLongitude()+"\"");
pw.print(",\"cityCode\":"+vendorOutletInterface.getCityCode());
pw.print(",\"contactNumber\":\""+vendorOutletInterface.getContactNumber()+"\"");
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