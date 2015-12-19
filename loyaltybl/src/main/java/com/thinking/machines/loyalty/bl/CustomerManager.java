package com.thinking.machines.loyalty.bl;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
public class CustomerManager
{
public void add(com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customerInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CustomerInterface customer=new com.thinking.machines.loyalty.dao.Customer();
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setOccupation(customerInterface.getOccupation());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.add(customer,connection);
customerInterface.setCode(customer.getCode());
if(customerInterface.getIsMarried())
{
MaritalDetailsInterface maritalDetails=new MaritalDetails();
maritalDetails.setCustomerCode(customer.getCode());
maritalDetails.setSpouseName(customerInterface.getSpouseName());
maritalDetails.setSpouseDateOfBirth(customerInterface.getSpouseDateOfBirth());
maritalDetails.setAnniversaryDate(customerInterface.getAnniversaryDate());
maritalDetails.setSpouseOccupation(customerInterface.getSpouseOccupation());
maritalDetails.setNumberOfGirlChild(customerInterface.getNumberOfGirlChild());
maritalDetails.setNumberOfBoyChild(customerInterface.getNumberOfBoyChild());
MaritalDetailsDAOInterface maritalDetailsDAO=new MaritalDetailsDAO();
maritalDetailsDAO.add(maritalDetails,connection);
}
if(customerInterface.getIsStudent())
{
StudentInterface student=new Student();
student.setCustomerCode(customer.getCode());
student.setStream(customerInterface.getStream());
student.setCourseDetails(customerInterface.getCourseDetails());
StudentDAOInterface studentDAO=new StudentDAO();
studentDAO.add(student,connection);
}
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void update(com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customerInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CustomerInterface customer=new com.thinking.machines.loyalty.dao.Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setOccupation(customerInterface.getOccupation());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.update(customer,connection);
if(customerInterface.getIsMarried())
{
MaritalDetailsInterface maritalDetails=new MaritalDetails();
maritalDetails.setCustomerCode(customerInterface.getCode());
maritalDetails.setSpouseName(customerInterface.getSpouseName());
maritalDetails.setSpouseDateOfBirth(customerInterface.getSpouseDateOfBirth());
maritalDetails.setAnniversaryDate(customerInterface.getAnniversaryDate());
maritalDetails.setSpouseOccupation(customerInterface.getSpouseOccupation());
maritalDetails.setNumberOfGirlChild(customerInterface.getNumberOfGirlChild());
maritalDetails.setNumberOfBoyChild(customerInterface.getNumberOfBoyChild());
MaritalDetailsDAOInterface maritalDetailsDAO=new MaritalDetailsDAO();
maritalDetailsDAO.update(maritalDetails,connection);
}
if(customerInterface.getIsStudent())
{
StudentInterface student=new Student();
student.setCustomerCode(customerInterface.getCode());
student.setStream(customerInterface.getStream());
student.setCourseDetails(customerInterface.getCourseDetails());
StudentDAOInterface studentDAO=new StudentDAO();
studentDAO.update(student,connection);
}
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public void getByCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer=new Customer();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface=customerDAOInterface.getByCode(code,connection);
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setOccupation(customerInterface.getOccupation());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
MaritalDetailsDAOInterface maritalDetailsDAOInterface=new MaritalDetailsDAO();
MaritalDetailsInterface maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(code,connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
StudentDAOInterface studentDAOInterface=new StudentDAO();
StudentInterface studentInterface=studentDAOInterface.getByCustomerCode(code,connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAll(connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setOccupation(customerInterface.getOccupation());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAllByName(String name) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByName(name,connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setOccupation(customerInterface.getOccupation());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAllByOccupation(String occupation) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByOccupation(occupation,connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setCityCode(customerInterface.getCityCode());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAllByCityCode(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByCity(cityCode,connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setOccupation(customerInterface.getOccupation());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setGender(customerInterface.getGender());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAllByDateOfBirth(java.util.Date dateOfBirth) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByDateOfBirth(dateOfBirth,connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setOccupation(customerInterface.getOccupation());
customer.setCityCode(customerInterface.getCityCode());
customer.setGender(customerInterface.getGender());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> getAllByCustomerType(com.thinking.machines.loyalty.interfaces.CustomerDAOInterface.CustomerType customerType) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface> customers= new ArrayList<com.thinking.machines.loyalty.bl.interfaces.CustomerInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByCustomerType(customerType,connection);
com.thinking.machines.loyalty.bl.interfaces.CustomerInterface customer;

MaritalDetailsInterface maritalDetailsInterface;
MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
StudentInterface studentInterface;
StudentDAOInterface studentDAOInterface= new StudentDAO();
com.thinking.machines.loyalty.interfaces.CustomerInterface customerInterface;
int x=0;
while(x<customerInterfaces.size())
{
customerInterface=customerInterfaces.get(x);
customer=new Customer();
customer.setCode(customerInterface.getCode());
customer.setName(customerInterface.getName());
customer.setUsername(customerInterface.getUsername());
customer.setPassword(customerInterface.getPassword());
customer.setPasswordKey(customerInterface.getPasswordKey());
customer.setPermanentAddress(customerInterface.getPermanentAddress());
customer.setCurrentAddress(customerInterface.getCurrentAddress());
customer.setOccupation(customerInterface.getOccupation());
customer.setDateOfBirth(customerInterface.getDateOfBirth());
customer.setCityCode(customerInterface.getCityCode());
customer.setGender(customerInterface.getGender());
customer.setIsMarried(customerInterface.getIsMarried());
customer.setIsStudent(customerInterface.getIsStudent());
customer.setContactNumber(customerInterface.getContactNumber());
customer.setEmailId(customerInterface.getEmailId());
if(customerInterface.getIsMarried())
{
maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setSpouseName(maritalDetailsInterface.getSpouseName());
customer.setSpouseDateOfBirth(maritalDetailsInterface.getSpouseDateOfBirth());
customer.setAnniversaryDate(maritalDetailsInterface.getAnniversaryDate());
customer.setSpouseOccupation(maritalDetailsInterface.getSpouseOccupation());
customer.setNumberOfGirlChild(maritalDetailsInterface.getNumberOfGirlChild());
customer.setNumberOfBoyChild(maritalDetailsInterface.getNumberOfBoyChild());
}
if(customerInterface.getIsStudent())
{
studentInterface=studentDAOInterface.getByCustomerCode(customerInterface.getCode(),connection);
customer.setStream(studentInterface.getStream());
customer.setCourseDetails(studentInterface.getCourseDetails());
}
customers.add(customer);
x++;
}
return customers;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public int getCountByName(String name) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
int count=customerDAOInterface.getCountByName(name,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public long getCount() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
long count=customerDAOInterface.getCount(connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public int getCountByOccupation(String occupation) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
int count=customerDAOInterface.getCountByOccupation(occupation,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public int getCountByCity(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
int count=customerDAOInterface.getCountByCity(cityCode,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public int getCountByDateOfBirth(java.util.Date dateOfBirth) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
int count=customerDAOInterface.getCountByDateOfBirth(dateOfBirth,connection);
return count;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
/*
no need
public boolean exists(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
return customerDAOInterface.exists(code,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public boolean existsByUsername(String username) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
return customerDAOInterface.existsByUsername(username,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public boolean existsByEmailId(String emailId) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
return customerDAOInterface.existsByEmailId(emailId,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public boolean existsByContactNumber(String contactNumber) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
return customerDAOInterface.existsByContactNumber(contactNumber,connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
*/
public void removeAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.removeAll(connection);
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}
public void remove(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
StudentDAOInterface studentDAOInterface=new StudentDAO();
studentDAOInterface.remove(code,connection);
MaritalDetailsDAOInterface maritalDetailsDAOInterface=new MaritalDetailsDAO();
maritalDetailsDAOInterface.remove(code,connection);
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.remove(code,connection);

}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

}
