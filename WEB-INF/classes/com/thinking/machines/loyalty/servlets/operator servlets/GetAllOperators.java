package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.bl.*;
//import com.thinking.machines.loyalty.interfaces.*;

public class GetAllOperators extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
ArrayList<OperatorBLInterface>operators=loyaltyApplication.getAllOperators();

OperatorBLInterface operatorInterface;
int x=0;
pw.println("[");

while(x<operators.size())
{
operatorInterface=operators.get(x);

pw.println("{");


pw.println("\"code\":"+ operatorInterface.getCode() );
pw.println(",\"name\":"+ "\""+operatorInterface.getName()+"\"" );
pw.println(",\"username\":"+ "\""+operatorInterface.getUsername() +"\"");
pw.println(",\"password\":"+ "\""+operatorInterface.getPassword() +"\"");
pw.println(",\"passwordkey\":"+"\""+ operatorInterface.getPasswordKey()+"\"" );
pw.println(",\"vendorOutletCode\":"+ operatorInterface.getVendorOutletCode() );

if(x<(operators.size()-1))
{
pw.println("},");
}
else
{
pw.println("}");
}

x++;
}

pw.println("]");

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