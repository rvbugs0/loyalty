package com.thinking.machines.loyalty.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
public class AdminFormCreation extends HttpServlet
{
public void doPost(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null;
try
{
System.out.println("Request Arrived - AdminFormCreation servlet");	
pw=rs.getWriter();
rs.setContentType("text/html");
String name=rq.getParameter("name");
String username=rq.getParameter("username");
String password=rq.getParameter("password");
String passwordKey=password;
String contactNumber=rq.getParameter("contactNumber");
String emailId=rq.getParameter("emailId");
com.thinking.machines.loyalty.bl.interfaces.AdminInterface adminInterface=new com.thinking.machines.loyalty.bl.Admin();
adminInterface.setName(name);
adminInterface.setUsername(username);
adminInterface.setPassword(password);
adminInterface.setPasswordKey(passwordKey);
adminInterface.setContactNumber(contactNumber);
adminInterface.setEmailId(emailId);
LoyaltyApplication loyaltyApplication=new LoyaltyApplication();
loyaltyApplication.addAdmin(adminInterface);
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"errorMessage\":\"added\"");
pw.println("}");
System.out.println("Admin added");
}
catch(IOException ioe)
{
System.out.println(ioe.getMessage());		
pw.println(ioe.getMessage());
}
catch(ApplicationException ae)
{
System.out.println(ae.getMessage());	
pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":\""+ae.getMessage()+"\"");
pw.println("}");
}
catch(Exception e)
{
System.out.println(e.getMessage());	
pw.println(e.getMessage());
}

}

}