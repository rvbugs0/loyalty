package com.thinking.machines.loyalty.dao;
import java.util.*;
import java.sql.*;
import com.thinking.machines.loyalty.interfaces.*;
import com.thinking.machines.loyalty.exceptions.*;
public class CustomerDAO implements CustomerDAOInterface
{

//tested - works fine
//if customer is a student ,record should be inserted in student table ,same goes for customer who is married.
public void add(CustomerInterface customerInterface) throws DAOException
{
try
{
if(existsByUsername(customerInterface.getUsername()))
{
throw new DAOException("CustomerDAO : add() : Username :" +customerInterface.getUsername()+" already exists");
}

if(existsByEmailId(customerInterface.getEmailId()))
{
throw new DAOException("CustomerDAO : add() : EmailId :" +customerInterface.getEmailId()+" already exists");
}

if(existsByContactNumber(customerInterface.getContactNumber()))
{
throw new DAOException("CustomerDAO : add(): contact Number :" +customerInterface.getContactNumber()+" already exists");
}

if(!(new CityDAO().exists(customerInterface.getCityCode())))
{
throw new DAOException("CustomerDAO : add() invalid city code : " + customerInterface.getCityCode());	
}

Connection connection=DAOConnection.getConnection();
String job="{ call add_customer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setString(1,customerInterface.getName()); 
callableStatement.setString(2,customerInterface.getUsername()); 
callableStatement.setString(3,customerInterface.getPassword()); 
callableStatement.setString(4,customerInterface.getPasswordKey()); 
callableStatement.setString(5,customerInterface.getPermanentAddress()); 
callableStatement.setString(6,customerInterface.getCurrentAddress()); 
callableStatement.setInt(7,customerInterface.getCityCode()); 
java.util.Date utilDateOfBirth=customerInterface.getDateOfBirth();
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(8,sqlDateOfBirth); 
callableStatement.setString(9,customerInterface.getGender()); 
callableStatement.setString(10,customerInterface.getOccupation()); 
callableStatement.setBoolean(11,customerInterface.getIsMarried()); 
callableStatement.setBoolean(12,customerInterface.getIsStudent()); 
callableStatement.setString(13,customerInterface.getContactNumber()); 
callableStatement.setString(14,customerInterface.getEmailId()); 
callableStatement.registerOutParameter(15,Types.INTEGER); 
callableStatement.execute();
int customerCode=callableStatement.getInt(15); 
callableStatement.close();
connection.close(); 
if(customerInterface.getIsMarried())
{
	MaritalDetailsDAOInterface maritalDetailsDAOInterface= new MaritalDetailsDAO();
	MaritalDetailsInterface maritalDetailsInterface=new MaritalDetails();
	maritalDetailsInterface.setCustomerCode(customerCode);
	maritalDetailsDAOInterface.add(maritalDetailsInterface);
}
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}

//incorrect
public void update(CustomerInterface customerInterface) throws DAOException
{
try
{
if(!exists(customerInterface.getCode()))
{
throw new DAOException("CustomerDAO : update() --> Invalid Customer Code:"+customerInterface.getCode());
}

if(existsByUsername(customerInterface.getUsername()))
{
throw new DAOException("CustomerDAO : update()" +customerInterface.getUsername()+" already exists");
}

if(existsByEmailId(customerInterface.getEmailId()))
{
throw new DAOException("CustomerDAO : update()" +customerInterface.getEmailId()+" already exists");
}

if(existsByContactNumber(customerInterface.getContactNumber()))
{
throw new DAOException("CustomerDAO : update()" +customerInterface.getContactNumber()+" already exists");
}

Connection connection=DAOConnection.getConnection(); 
String job="{ call update_customer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,customerInterface.getCode());
callableStatement.setString(2,customerInterface.getName()); 
callableStatement.setString(3,customerInterface.getUsername()); 
callableStatement.setString(4,customerInterface.getPassword()); 
callableStatement.setString(5,customerInterface.getPasswordKey()); 
callableStatement.setString(6,customerInterface.getPermanentAddress()); 
callableStatement.setString(7,customerInterface.getCurrentAddress()); 
callableStatement.setInt(8,customerInterface.getCityCode()); 
java.util.Date utilDateOfBirth=customerInterface.getDateOfBirth();
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(9,sqlDateOfBirth); 
callableStatement.setString(10,customerInterface.getGender()); 
callableStatement.setString(11,customerInterface.getOccupation()); 
callableStatement.setBoolean(12,customerInterface.getIsMarried()); 
callableStatement.setBoolean(13,customerInterface.getIsStudent()); 
callableStatement.setString(14,customerInterface.getContactNumber()); 
callableStatement.setString(15,customerInterface.getEmailId()); 
callableStatement.execute(); 
callableStatement.close(); 
connection.close();
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}

//tested - works fine
public CustomerInterface getByCode(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_customer_by_code(?) }";
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setInt(1,code);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close(); 
connection.close();
throw new DAOException("CustomerDAO : getByCode() --> No ResultSet object");
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close(); 
connection.close(); 
throw new DAOException("CustomerDAO : getByCode() --> Invalid Code "+code); 
}
CustomerInterface customerInterface=new Customer();
customerInterface.setCode(resultSet.getInt("customer_code"));
customerInterface.setName(resultSet.getString("name").trim()); 
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
callableStatement.close(); 
connection.close(); 
return customerInterface;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getByCode() :" +sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}




//tested - works fine
public ArrayList<CustomerInterface> getAll() throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_all_customers() }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAll() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAll() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();
callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAll() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}



//tested - works fine
public ArrayList<CustomerInterface> getAllByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_all_customers_by_name(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setString(1,name);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByName() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByName() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);

customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();
callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAllByName() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO : getAllByName() --> "+exception.getMessage()); 
}
}

//tested - works fine
public ArrayList<CustomerInterface> getAllByOccupation(String occupation) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_all_customers_by_occupation(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setString(1,occupation);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByOccupation() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByOccupation() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAllByOccupation() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}

//tested works fine
public ArrayList<CustomerInterface> getAllByCity(int cityCode) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_all_customers_by_city(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setInt(1,cityCode);
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByCity() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByCity() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAllByCity() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}


//tested - works fine
public ArrayList<CustomerInterface> getAllByDateOfBirth(java.util.Date dateOfBirth) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_all_customers_by_date_of_birth(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
java.util.Date utilDateOfBirth=dateOfBirth;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByDateOfBirth() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByDateOfBirth() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth1=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth1);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAllByDateOfBirth() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}


public ArrayList<CustomerInterface> getAllByCustomerType(CustomerType customerType) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="";
if(customerType==CustomerType.STUDENT)
{
job="{ call get_all_student_customers() }"; 
}
if(customerType==CustomerType.MARRIED)
{
job="{ call get_all_married_customers() }";
}
if(customerType==CustomerType.MALE)
{
job="{ call get_all_male_customers() }"; 
}
if(customerType==CustomerType.FEMALE)
{
job="{ call get_all_female_customers() }"; 
}
CallableStatement callableStatement=connection.prepareCall(job); 
boolean resultGenerated=callableStatement.execute();
if(!resultGenerated)
{
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByCustomerType() --> No ResultSet object"); 
}
ResultSet resultSet=callableStatement.getResultSet();
if(resultSet.next()==false)
{
resultSet.close(); 
callableStatement.close();
connection.close(); 
throw new DAOException("CustomerDAO : getAllByCustomerType() --> No records ");
}
ArrayList<CustomerInterface> customers;
customers=new ArrayList<CustomerInterface>(); 
CustomerInterface customerInterface;
do
{
customerInterface=new Customer(); 
customerInterface.setCode(resultSet.getInt("customer_code")); 
customerInterface.setName(resultSet.getString("name").trim());
customerInterface.setUsername(resultSet.getString("username").trim());
customerInterface.setPassword(resultSet.getString("password").trim());
customerInterface.setPasswordKey(resultSet.getString("password_key").trim());
customerInterface.setPermanentAddress(resultSet.getString("permanent_address").trim());
customerInterface.setCurrentAddress(resultSet.getString("current_address").trim());
customerInterface.setCityCode(resultSet.getInt("city_code"));
java.sql.Date sqlDateOfBirth=resultSet.getDate("date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
customerInterface.setDateOfBirth(utilDateOfBirth);
customerInterface.setGender(resultSet.getString("gender").trim());
customerInterface.setOccupation(resultSet.getString("occupation").trim());
customerInterface.setIsMarried(resultSet.getBoolean("is_married"));              
customerInterface.setIsStudent(resultSet.getBoolean("is_student"));
customerInterface.setContactNumber(resultSet.getString("contact_number").trim());
customerInterface.setEmailId(resultSet.getString("mail_id").trim());
customers.add(customerInterface);
}
while(resultSet.next());
resultSet.close();callableStatement.close();
connection.close(); 
return customers;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO : getAllByCustomerType() --> "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}


//tested - works fine
public int getCountByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_customer_count_by_name(?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setString(1,name); 
callableStatement.registerOutParameter(2,Types.INTEGER); 
callableStatement.execute(); 
int count=callableStatement.getInt(2);
callableStatement.close();
connection.close();
return count;
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> getCountByName() --> "+exception.getMessage()); 
}
}

//tested - works fine
public int getCountByOccupation(String occupation) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_customer_count_by_occupation(?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setString(1,occupation); 
callableStatement.registerOutParameter(2,Types.INTEGER); 
callableStatement.execute(); 
int count=callableStatement.getInt(2);
callableStatement.close();
connection.close();
return count;
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> getCountByOccupation() --> "+exception.getMessage()); 
}
}

//tested - works fine
public int getCountByCity(int cityCode) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_customer_count_by_city(?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setInt(1,cityCode); 
callableStatement.registerOutParameter(2,Types.INTEGER); 
callableStatement.execute(); 
int count=callableStatement.getInt(2);
callableStatement.close();
connection.close();
return count;
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> getCountByCity() --> "+exception.getMessage()); 
}
}


//tested - works fine
public int getCountByDateOfBirth(java.util.Date dateOfBirth) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="{ call get_customer_count_by_date_of_birth(?,?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
java.util.Date utilDateOfBirth=dateOfBirth;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 
callableStatement.registerOutParameter(2,Types.INTEGER); 
callableStatement.execute(); 
int count=callableStatement.getInt(2);
callableStatement.close();
connection.close();
return count;
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO --> getCountByDateOfBirth() --> "+sqlException.getMessage()); 
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}


public int getCountByCustomerType(CustomerType customerType) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
String job="";
if(customerType==CustomerType.STUDENT)
{
job="{ call get_count_of_student_customers() }"; 
}
if(customerType==CustomerType.MARRIED)
{
job="{ call get_count_of_married_customers() }";
}
if(customerType==CustomerType.MALE)
{
job="{ call get_count_of_male_customers() }"; 
}
if(customerType==CustomerType.FEMALE)
{
job="{ call get_count_of_female_customers() }"; 
}

CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.registerOutParameter(1,Types.INTEGER); 
callableStatement.execute(); 
int count=callableStatement.getInt(1);
callableStatement.close();
connection.close();
return count;
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> getCountByCustomerType() --> "+exception.getMessage()); 
}
}



//tested works fine
public boolean exists(int code) throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection(); 
String job="{ call customer_exists_by_code(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setInt(1,code); 
boolean resultGenerated=callableStatement.execute(); 
if(!resultGenerated)
{
callableStatement.close(); 
connection.close(); 
throw new DAOException("exists() --> No records in generated result"); 
}
ResultSet resultSet=callableStatement.getResultSet(); 
exists=resultSet.next(); 
resultSet.close(); 
callableStatement.close(); 
return exists;
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> exists() --> "+exception.getMessage()); 
}
}




//tested - works fine
public boolean existsByUsername(String username) throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
String job="{ call customer_exists_by_username(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,username);
boolean resultGenerated=callableStatement.execute(); 
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("existsByUsername() --> No records in generated result"); 
}
ResultSet resultSet=callableStatement.getResultSet(); 
exists=resultSet.next();
resultSet.close(); 
callableStatement.close();
return exists; 
}catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO --> existsByUsername() --> "+sqlException.getMessage()); 
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 
}
}



//tested - works fine
public boolean existsByEmailId(String emailId) throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
String job="{ call customer_exists_by_mail_id(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,emailId);
boolean resultGenerated=callableStatement.execute(); 
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("existsByEmailId() --> No records in generated result"); 
}
ResultSet resultSet=callableStatement.getResultSet(); 
exists=resultSet.next();
resultSet.close(); 
callableStatement.close();
return exists; 
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO --> existsByEmailId() --> "+sqlException.getMessage()); 	
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 	
}
}



//tested -works fine
public boolean existsByContactNumber(String contactNumber) throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
String job="{ call customer_exists_by_contact_number(?) }";
CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setString(1,contactNumber);
boolean resultGenerated=callableStatement.execute(); 
if(!resultGenerated)
{
callableStatement.close();
connection.close();
throw new DAOException("existsByContactNumber() --> No records in generated result"); 
}
ResultSet resultSet=callableStatement.getResultSet(); 
exists=resultSet.next();
resultSet.close(); 
callableStatement.close();
return exists; 
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO --> existsByContactNumber() --> "+sqlException.getMessage()); 	
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 	
}
}



public void removeAll() throws DAOException
{
}


public void remove(int code) throws DAOException
{
if(new StudentDAO().exists(code))
{
throw new DAOException("CustomerDAO : remove() customer cannot be removed : " + code);	
}
if(new MaritalDetailsDAO().exists(code))
{
throw new DAOException("CustomerDAO : remove() customer cannot be removed : " + code);	
}
try
{
Connection connection=DAOConnection.getConnection(); 
String job="{ call remove_customer(?) }";
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.execute();
callableStatement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException("CustomerDAO --> remove() --> "+exception.getMessage()); 
}
}


//tested -works fine
public long getCount() throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection(); 
String job="{ call get_customer_count(?) }"; 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.registerOutParameter(1,Types.INTEGER);
callableStatement.execute();
long count=callableStatement.getInt(1); 
callableStatement.close(); 
connection.close(); 
return count; 
}
catch(SQLException sqlException)
{
throw new DAOException("CustomerDAO --> getCount() --> "+sqlException.getMessage()); 
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage()); 	
}
}

}









