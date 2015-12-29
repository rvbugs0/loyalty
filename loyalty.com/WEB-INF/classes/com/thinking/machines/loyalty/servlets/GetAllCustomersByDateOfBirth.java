package com.thinking.machines.loyalty.servlets;
import java.io.*;
import java.util.*;
import java.text.*;//for SimpleDateFormat
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.loyalty.application.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.bl.interfaces.*;

public class GetAllCustomersByDateOfBirth extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
ArrayList<CustomerBLInterface>customers=loyaltyApplication.getAllCustomersByDateOfBirth(dateFormat.parse(rq.getParameter("dateOfBirth")));
CustomerBLInterface customerInterface;
int x=0;
pw.println("[");

while(x<customers.size())
{
customerInterface=customers.get(x);

pw.println("{");


pw.println("\"code\":"+ customerInterface.getCode() );
pw.println(",\"name\":"+ "\""+customerInterface.getName()+"\"" );
pw.println(",\"username\":"+ "\""+customerInterface.getUsername() +"\"");
pw.println(",\"password\":"+ "\""+customerInterface.getPassword() +"\"");
pw.println(",\"passwordkey\":"+"\""+ customerInterface.getPasswordKey()+"\"" );
pw.println(",\"permanentAddress\":"+ "\""+customerInterface.getPermanentAddress().replace("\n", " ").replace("\r", " ")+"\"" );
pw.println(",\"currentAddress\":"+"\""+ customerInterface.getCurrentAddress().replace("\n", " ").replace("\r", " ")+"\"" );
pw.println(",\"cityCode\":"+ customerInterface.getCityCode() );
pw.println(",\"dateOfBirth\":"+ "\""+customerInterface.getDateOfBirth() +"\"");
pw.println(",\"gender\":"+"\""+ customerInterface.getGender()+"\"" );
pw.println(",\"occupation\":"+"\""+ customerInterface.getOccupation() +"\"");
pw.println(",\"isMarried\":"+ customerInterface.getIsMarried() );
pw.println(",\"isStudent\":"+ customerInterface.getIsStudent() );
pw.println(",\"contactNumber\":"+"\""+ customerInterface.getContactNumber()+"\"" );
pw.println(",\"emailId\":"+ "\""+customerInterface.getEmailId() +"\"");
pw.println(",\"spouseName\":"+"\""+ customerInterface.getSpouseName()+"\"" );
pw.println(",\"spouseDateOfBirth\":"+"\""+ customerInterface.getSpouseDateOfBirth()+"\"" );
pw.println(",\"anniversaryDate\":"+"\""+ customerInterface.getAnniversaryDate()+"\"" );
pw.println(",\"spouseOccupation\":"+"\""+ customerInterface.getSpouseOccupation() +"\"");
pw.println(",\"numberOfGirlChild\":"+ customerInterface.getNumberOfGirlChild() );
pw.println(",\"numberOfBoyChild\":"+ customerInterface.getNumberOfBoyChild() );
pw.println(",\"stream\":"+ "\""+customerInterface.getStream() +"\"");
pw.println(",\"courseDetails\":"+"\""+ customerInterface.getCourseDetails()+"\"" );


if(x<(customers.size()-1))
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