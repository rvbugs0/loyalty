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
//import com.thinking.machines.loyalty.interfaces.*;

public class AddCustomer extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
 PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
CustomerBLInterface customerInterface=new Customer();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();
customerInterface.setName(rq.getParameter("name"));
customerInterface.setUsername(rq.getParameter("username"));
customerInterface.setPassword(rq.getParameter("password"));
customerInterface.setPasswordKey(rq.getParameter("passwordKey"));
customerInterface.setPermanentAddress(rq.getParameter("permanentAddress"));
customerInterface.setCurrentAddress(rq.getParameter("currentAddress"));
customerInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode")));
try
{
customerInterface.setDateOfBirth(dateFormat.parse(rq.getParameter("dateOfBirth")));
}catch(ParseException pe)
{
System.out.println(pe);
}
customerInterface.setGender(rq.getParameter("gender"));
customerInterface.setOccupation(rq.getParameter("occupation"));
customerInterface.setIsMarried(Boolean.parseBoolean(rq.getParameter("isMarried")));
customerInterface.setIsStudent(Boolean.parseBoolean(rq.getParameter("isStudent")));
customerInterface.setContactNumber(rq.getParameter("contactNumber"));
customerInterface.setEmailId(rq.getParameter("emailId"));
customerInterface.setSpouseName(rq.getParameter("spouseName"));
try
{
customerInterface.setSpouseDateOfBirth(dateFormat.parse(rq.getParameter("spouseDateOfBirth")));
}catch(ParseException pe)
{
System.out.println(pe);
}
try
{
customerInterface.setAnniversaryDate(dateFormat.parse(rq.getParameter("anniversaryDate")));
}catch(ParseException pe)
{
System.out.println(pe);
}
customerInterface.setSpouseOccupation(rq.getParameter("spouseOccupation"));
customerInterface.setNumberOfGirlChild(Integer.parseInt(rq.getParameter("numberOfGirlChild")));
customerInterface.setNumberOfBoyChild(Integer.parseInt(rq.getParameter("numberOfBoyChild")));
customerInterface.setStream(rq.getParameter("stream"));
customerInterface.setCourseDetails(rq.getParameter("courseDetails"));

loyaltyApplication.addCustomer(customerInterface);
int code=customerInterface.getCode();
//System.out.println(code);

pw.println("{");
pw.println("\"success\":true,");
pw.println("\"code\":"+code);
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