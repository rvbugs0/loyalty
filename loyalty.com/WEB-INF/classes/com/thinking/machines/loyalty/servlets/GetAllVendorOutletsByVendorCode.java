package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetAllVendorOutletsByVendorCode extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorOutletBLInterface vendorOutletInterface;
int code;
try
{
code=Integer.parseInt(rq.getParameter("code").trim());	
}
catch(Exception e)
{
throw new ApplicationException("code -> "+e.getMessage());	
}
ArrayList<VendorOutletBLInterface> vendorOutlets=new ArrayList<VendorOutletBLInterface>();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
vendorOutlets=loyaltyApplication.getAllVendorOutletsByVendorCode(code);
pw.println("{");
pw.println("\"success\":true,");
pw.print("\"VendorOutlets\":");
pw.print("[");
int x=0;
while(x<vendorOutlets.size())
{
vendorOutletInterface=vendorOutlets.get(x);
pw.print("{\"code\":"+vendorOutletInterface.getCode());
pw.print(",\"vendorCode\":"+vendorOutletInterface.getVendorCode());
pw.print(",\"address\":\""+vendorOutletInterface.getAddress().replace("\n", " ").replace("\r", " ")+"\"");
pw.print(",\"latitude\":\""+vendorOutletInterface.getLatitude()+"\"");
pw.print(",\"longitude\":\""+vendorOutletInterface.getLongitude()+"\"");
pw.print(",\"cityCode\":"+vendorOutletInterface.getCityCode());
pw.print(",\"contactNumber\":\""+vendorOutletInterface.getContactNumber()+"\"");
if(x==(vendorOutlets.size()-1))
{
pw.print("}");
}
else
{
pw.print("},");
}
x++;
}
pw.println("]");
pw.println("}");

}catch(ApplicationException ae)
{
pw.println("{");
pw.println("\"success\":false,");
pw.print("\"VendorOutlets\":");
pw.print("[],");
pw.println("\"errorMessage\":\""+ae.getMessage()+"\"");
pw.println("}");
}
catch(Exception e)
{
System.out.println(e);
}
}
}