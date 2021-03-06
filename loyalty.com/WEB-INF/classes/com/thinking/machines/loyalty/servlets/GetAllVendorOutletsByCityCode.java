package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetAllVendorOutletsByCityCode extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorOutletBLInterface vendorOutletInterface;
ArrayList<VendorOutletBLInterface> vendorOutlets=new ArrayList<VendorOutletBLInterface>();
int cityCode=Integer.parseInt(rq.getParameter("cityCode").trim());
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
vendorOutlets=loyaltyApplication.getAllVendorOutletsByCityCode(cityCode);
System.out.println(vendorOutlets.size());
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