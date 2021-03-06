package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class UpdateOperator extends HttpServlet
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
operatorInterface.setCode(Integer.parseInt(rq.getParameter("code").trim()));
operatorInterface.setName(rq.getParameter("name").trim());
operatorInterface.setUsername(rq.getParameter("username").trim());
operatorInterface.setPassword(rq.getParameter("password").trim());
operatorInterface.setPasswordKey(rq.getParameter("password").trim());

operatorInterface.setVendorOutletCode(Integer.parseInt(rq.getParameter("vendorOutletCode").trim()));

loyaltyApplication.updateOperator(operatorInterface);

//System.out.println(code);

pw.println("{");
pw.println("\"success\":true,");
pw.println("\"message\":\"updated\"");
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