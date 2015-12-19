package com.thinking.machines.loyalty.bl;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
public class CustomerManager
{
public void add(CustomerBLInterface customerBLInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CustomerInterface customer=new com.thinking.machines.loyalty.dao.Customer();
customer.setName(customerBLInterface.getName());
customer.setUsername(customerBLInterface.getUsername());
customer.setPassword(customerBLInterface.getPassword());
customer.setPasswordKey(customerBLInterface.getPasswordKey());
customer.setPermanentAddress(customerBLInterface.getPermanentAddress());
customer.setCurrentAddress(customerBLInterface.getCurrentAddress());
customer.setCityCode(customerBLInterface.getCityCode());
customer.setDateOfBirth(customerBLInterface.getDateOfBirth());
customer.setGender(customerBLInterface.getGender());
customer.setOccupation(customerBLInterface.getOccupation());
customer.setIsMarried(customerBLInterface.getIsMarried());
customer.setIsStudent(customerBLInterface.getIsStudent());
customer.setContactNumber(customerBLInterface.getContactNumber());
customer.setEmailId(customerBLInterface.getEmailId());
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.add(customer,connection);
customerBLInterface.setCode(customer.getCode());
if(customerBLInterface.getIsMarried())
{
MaritalDetailsInterface maritalDetails=new MaritalDetails();
maritalDetails.setCustomerCode(customer.getCode());
maritalDetails.setSpouseName(customerBLInterface.getSpouseName());
maritalDetails.setSpouseDateOfBirth(customerBLInterface.getSpouseDateOfBirth());
maritalDetails.setAnniversaryDate(customerBLInterface.getAnniversaryDate());
maritalDetails.setSpouseOccupation(customerBLInterface.getSpouseOccupation());
maritalDetails.setNumberOfGirlChild(customerBLInterface.getNumberOfGirlChild());
maritalDetails.setNumberOfBoyChild(customerBLInterface.getNumberOfBoyChild());
MaritalDetailsDAOInterface maritalDetailsDAO=new MaritalDetailsDAO();
maritalDetailsDAO.add(maritalDetails,connection);
}
if(customerBLInterface.getIsStudent())
{
StudentInterface student=new Student();
student.setCustomerCode(customer.getCode());
student.setStream(customerBLInterface.getStream());
student.setCourseDetails(customerBLInterface.getCourseDetails());
StudentDAOInterface studentDAO=new StudentDAO();
studentDAO.add(student,connection);
}
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}


public void update(CustomerBLInterface customerBLInterface) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
com.thinking.machines.loyalty.interfaces.CustomerInterface customer=new com.thinking.machines.loyalty.dao.Customer();
customer.setCode(customerBLInterface.getCode());
customer.setName(customerBLInterface.getName());
customer.setUsername(customerBLInterface.getUsername());
customer.setPassword(customerBLInterface.getPassword());
customer.setPasswordKey(customerBLInterface.getPasswordKey());
customer.setPermanentAddress(customerBLInterface.getPermanentAddress());
customer.setCurrentAddress(customerBLInterface.getCurrentAddress());
customer.setCityCode(customerBLInterface.getCityCode());
customer.setDateOfBirth(customerBLInterface.getDateOfBirth());
customer.setGender(customerBLInterface.getGender());
customer.setOccupation(customerBLInterface.getOccupation());
customer.setIsMarried(customerBLInterface.getIsMarried());
customer.setIsStudent(customerBLInterface.getIsStudent());
customer.setContactNumber(customerBLInterface.getContactNumber());
customer.setEmailId(customerBLInterface.getEmailId());
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerDAOInterface.update(customer,connection);
if(customerBLInterface.getIsMarried())
{
MaritalDetailsInterface maritalDetails=new MaritalDetails();
maritalDetails.setCustomerCode(customerBLInterface.getCode());
maritalDetails.setSpouseName(customerBLInterface.getSpouseName());
maritalDetails.setSpouseDateOfBirth(customerBLInterface.getSpouseDateOfBirth());
maritalDetails.setAnniversaryDate(customerBLInterface.getAnniversaryDate());
maritalDetails.setSpouseOccupation(customerBLInterface.getSpouseOccupation());
maritalDetails.setNumberOfGirlChild(customerBLInterface.getNumberOfGirlChild());
maritalDetails.setNumberOfBoyChild(customerBLInterface.getNumberOfBoyChild());
MaritalDetailsDAOInterface maritalDetailsDAO=new MaritalDetailsDAO();
maritalDetailsDAO.update(maritalDetails,connection);
}
if(customerBLInterface.getIsStudent())
{
StudentInterface student=new Student();
student.setCustomerCode(customerBLInterface.getCode());
student.setStream(customerBLInterface.getStream());
student.setCourseDetails(customerBLInterface.getCourseDetails());
StudentDAOInterface studentDAO=new StudentDAO();
studentDAO.update(student,connection);
}
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public CustomerBLInterface getByCode(int code) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
CustomerBLInterface customer=new Customer();
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
return customer;
}
catch(Exception exception)
{
throw new BLException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAll() throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAll(connection);
CustomerBLInterface customer;

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

public ArrayList<CustomerBLInterface> getAllByName(String name) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByName(name,connection);
CustomerBLInterface customer;

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

public ArrayList<CustomerBLInterface> getAllByOccupation(String occupation) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByOccupation(occupation,connection);
CustomerBLInterface customer;

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

public ArrayList<CustomerBLInterface> getAllByCityCode(int cityCode) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByCity(cityCode,connection);
CustomerBLInterface customer;

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

public ArrayList<CustomerBLInterface> getAllByDateOfBirth(java.util.Date dateOfBirth) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByDateOfBirth(dateOfBirth,connection);
CustomerBLInterface customer;

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

public ArrayList<CustomerBLInterface> getAllByCustomerType(com.thinking.machines.loyalty.interfaces.CustomerDAOInterface.CustomerType customerType) throws BLException
{
try
{
Connection connection=DAOConnection.getConnection();
ArrayList<com.thinking.machines.loyalty.interfaces.CustomerInterface> customerInterfaces;
ArrayList<CustomerBLInterface> customers= new ArrayList<CustomerBLInterface>();
CustomerDAOInterface customerDAOInterface=new CustomerDAO();
customerInterfaces=customerDAOInterface.getAllByCustomerType(customerType,connection);
CustomerBLInterface customer;

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
