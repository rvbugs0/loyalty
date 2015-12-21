package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class Admin extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
PrintWriter pw=null; 
try
{
pw=rs.getWriter();
rs.setContentType("application/html");
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
long count=loyaltyApplication.getCountAdmin();
RequestDispatcher requestDispatcher;
if(count==0)
{
requestDispatcher=rq.getRequestDispatcher("/AdminFormCreation.jsp");
requestDispatcher.forward(rq,rs);
}
else
{
requestDispatcher=rq.getRequestDispatcher("/AdminLoginForm.jsp");
requestDispatcher.forward(rq,rs);
}
}catch(ApplicationException ae)
{
pw.println(ae.getMessage());
}
	catch(Exception e)
{
System.out.println(e);
}
}
}