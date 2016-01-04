package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetAllVendorsByCityCode extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
VendorBLInterface vendorInterface;
ArrayList<VendorBLInterface> vendors=new ArrayList<VendorBLInterface>();
int cityCode=Integer.parseInt(rq.getParameter("cityCode").trim());
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
vendors=loyaltyApplication.getAllVendorsByCityCode(cityCode);
System.out.println(vendors.size());
pw.println("{");
pw.println("\"success\":true,");
pw.print("\"Vendors\":");
pw.print("[");
int x=0;
while(x<vendors.size())
{
vendorInterface=vendors.get(x);
pw.print("{\"code\":"+vendorInterface.getCode());
pw.print(",\"name\":\""+vendorInterface.getName()+"\"");
pw.print(",\"username\":\""+vendorInterface.getUsername()+"\"");
pw.print(",\"password\":\""+vendorInterface.getPassword()+"\"");
pw.print(",\"passwordKey\":\""+vendorInterface.getPasswordKey()+"\"");
pw.print(",\"address\":\""+vendorInterface.getAddress().replace("\n", " ").replace("\r", " ")+"\"");
pw.print(",\"cityCode\":"+vendorInterface.getCityCode());
pw.print(",\"contactNumber\":\""+vendorInterface.getContactNumber()+"\"");
pw.print(",\"emailId\":\""+vendorInterface.getEmailId()+"\"");
if(x==(vendors.size()-1))
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
pw.print("\"Vendors\":");
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