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
public class UpdateCustomer extends HttpServlet
{

public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{ 
PrintWriter pw=null;
try
{
pw=rs.getWriter();
rs.setContentType("application/json");   
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
CustomerBLInterface customerInterface=new Customer();
LoyaltyApplication loyaltyApplication =new LoyaltyApplication();

customerInterface.setCode(Integer.parseInt(rq.getParameter("code").trim()));
customerInterface.setName(rq.getParameter("name").trim());
customerInterface.setUsername(rq.getParameter("username").trim());
customerInterface.setPassword(rq.getParameter("password").trim());
customerInterface.setPasswordKey(rq.getParameter("passwordKey").trim());
customerInterface.setPermanentAddress(rq.getParameter("permanentAddress").trim());
customerInterface.setCurrentAddress(rq.getParameter("currentAddress").trim());
customerInterface.setCityCode(Integer.parseInt(rq.getParameter("cityCode").trim()));
try
{
customerInterface.setDateOfBirth(dateFormat.parse(rq.getParameter("dateOfBirth").trim()));
}catch(ParseException pe)
{
System.out.println(pe);
}
customerInterface.setGender(rq.getParameter("gender").trim());
customerInterface.setOccupation(rq.getParameter("occupation").trim());
customerInterface.setIsMarried(Boolean.parseBoolean(rq.getParameter("isMarried").trim()));
customerInterface.setIsStudent(Boolean.parseBoolean(rq.getParameter("isStudent").trim()));
customerInterface.setContactNumber(rq.getParameter("contactNumber").trim());
customerInterface.setEmailId(rq.getParameter("emailId").trim());
customerInterface.setSpouseName(rq.getParameter("spouseName").trim());
try
{
customerInterface.setSpouseDateOfBirth(dateFormat.parse(rq.getParameter("spouseDateOfBirth").trim()));
}catch(ParseException pe)
{
System.out.println(pe);
}
try
{
customerInterface.setAnniversaryDate(dateFormat.parse(rq.getParameter("anniversaryDate").trim()));
}catch(ParseException pe)
{
System.out.println(pe);
}
customerInterface.setSpouseOccupation(rq.getParameter("spouseOccupation").trim());
customerInterface.setNumberOfGirlChild(Integer.parseInt(rq.getParameter("numberOfGirlChild").trim()));
customerInterface.setNumberOfBoyChild(Integer.parseInt(rq.getParameter("numberOfBoyChild").trim()));
customerInterface.setStream(rq.getParameter("stream").trim());
customerInterface.setCourseDetails(rq.getParameter("courseDetails").trim());
loyaltyApplication.updateCustomer(customerInterface);
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

}catch(IOException ioe)
{
System.out.println(ioe);
}
}}