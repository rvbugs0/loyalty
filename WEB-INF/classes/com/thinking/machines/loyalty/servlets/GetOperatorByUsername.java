package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.manager.*;
import com.thinking.machines.loyalty.manager.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetOperatorByUsername extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
OperatorBLInterface operatorInterface=new Operator();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
operatorInterface=loyaltyApplication.getOperatorByUsername(rq.getParameter("username"));
operatorInterface.setUsername(rq.getParameter("username"));
pw.println("{");
pw.println("\"success\":true,");
pw.println("\"code\":"+ operatorInterface.getCode() );
pw.println(",\"name\":"+ "\""+operatorInterface.getName()+"\"" );
pw.println(",\"username\":"+ "\""+operatorInterface.getUsername() +"\"");
pw.println(",\"password\":"+ "\""+operatorInterface.getPassword() +"\"");
pw.println(",\"passwordkey\":"+"\""+ operatorInterface.getPasswordKey()+"\"" );
pw.println(",\"vendorOutletCode\":"+ operatorInterface.getVendorOutletCode() );

pw.println("}");
}catch(ApplicationException ae)
{
System.out.println(ae);

pw.println("{");
pw.println("\"success\":false,");
pw.println("\"errorMessage\":"+"\""+ae+"\"");
pw.println("}");
}
catch(Exception e)
{
System.out.println(e);
}
}
}