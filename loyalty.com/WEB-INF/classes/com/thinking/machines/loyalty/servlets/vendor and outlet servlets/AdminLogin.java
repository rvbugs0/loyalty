package com.thinking.machines.loyalty.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
public class AdminLogin extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
String username=rq.getParameter("username");
String password=rq.getParameter("password");
LoyaltyApplication loyaltyApplication=new LoyaltyApplication();
AdminInterface adminInterface;
adminInterface=loyaltyApplication.getAdminByUsername(username);
if(password.equals(adminInterface.getPassword()))
{
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":\"Valid\"");
pw.println("}");
}
else{
pw.println("{");
pw.println("\"success\":false,");
pw.println("\"message\":\"Invalid Password\"");
pw.println("}");
}
}
catch(IOException ioe)
{
//pw.println(ioe.getMessage());
}
catch(ApplicationException ae)
{
pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":\"Invalid Username\"");
pw.println("}");
return;
}
catch(Exception e)
{
//pw.println(e.getMessage());
}

}

}