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
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null;
try
{
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
}
catch(IOException ioe)
{
pw.println(ioe.getMessage());
}
catch(ApplicationException ae)
{
pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":\""+ae.getMessage()+"\"");
pw.println("}");
}
catch(Exception e)
{
pw.println(e.getMessage());
}

}

}