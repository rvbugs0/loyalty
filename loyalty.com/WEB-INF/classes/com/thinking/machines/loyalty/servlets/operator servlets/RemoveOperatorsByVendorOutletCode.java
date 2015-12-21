package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.bl.*;
public class RemoveOperatorsByVendorOutletCode extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");  
 LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
loyaltyApplication.removeOperatorsByVendorOutletCode(Integer.parseInt(rq.getParameter("vendorOutletCode")));
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":\"removed\"");
pw.println("}");

}catch(ApplicationException ae)
{

System.out.println(ae);

pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":"+"\""+ae+"\"");
pw.println("}");

}catch(IOException ioe)
{
System.out.println(ioe);
}

}}