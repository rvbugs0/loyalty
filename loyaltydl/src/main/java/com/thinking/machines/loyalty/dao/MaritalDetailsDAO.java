package com.thinking.machines.loyalty.dao;
import java.util.*;

import java.sql.*;
import com.thinking.machines.loyalty.interfaces.*;

import com.thinking.machines.loyalty.exceptions.*;

public class MaritalDetailsDAO implements MaritalDetailsDAOInterface
{
public void add(MaritalDetailsInterface maritalDetailsInterface) throws DAOException
{
try

{

if(exists(maritalDetailsInterface.getCustomerCode()))

{

throw new DAOException("MaritalDetailsDAO : add()" +maritalDetailsInterface.getCustomerCode()+" already exists");
 
}



if(!(new CustomerDAO().exists(maritalDetailsInterface.getCustomerCode())))

{
throw new DAOException("MaritalDetailsDAO : add() invalid customer code : " + maritalDetailsInterface.getCustomerCode());	
		}
Connection connection=DAOConnection.getConnection();
 
String job="{ call add_marital_details(?,?,?,?,?,?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setInt(1,maritalDetailsInterface.getCustomerCode()); 

callableStatement.setString(2,maritalDetailsInterface.getSpouseName()); 

java.util.Date utilDateOfBirth=maritalDetailsInterface.getSpouseDateOfBirth();
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(3,sqlDateOfBirth); 

java.util.Date utilDateOfBirth1=maritalDetailsInterface.getAnniversaryDate();
java.sql.Date sqlDateOfBirth1=new java.sql.Date(utilDateOfBirth1.getYear(),utilDateOfBirth1.getMonth(),utilDateOfBirth1.getDate());
callableStatement.setDate(4,sqlDateOfBirth1); 

callableStatement.setString(5,maritalDetailsInterface.getSpouseOccupation()); 

callableStatement.setInt(6,maritalDetailsInterface.getNumberOfGirlChild()); 

callableStatement.setInt(7,maritalDetailsInterface.getNumberOfBoyChild()); 

callableStatement.execute();
callableStatement.close();
 
connection.close(); 

}
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> add() --> "+exception.getMessage());
 
}



}
public void update(MaritalDetailsInterface maritalDetailsInterface) throws DAOException
{
try

{

if(!exists(maritalDetailsInterface.getCustomerCode()))

{

throw new DAOException("MaritalDetailsDAO : update() --> Invalid MaritalDetails Code :"+maritalDetailsInterface.getCustomerCode());
 
}


Connection connection=DAOConnection.getConnection(); 

String job="{ call update_marital_details(?,?,?,?,?,?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job);
callableStatement.setInt(1,maritalDetailsInterface.getCustomerCode()); 

callableStatement.setString(2,maritalDetailsInterface.getSpouseName()); 

java.util.Date utilDateOfBirth=maritalDetailsInterface.getSpouseDateOfBirth();
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(3,sqlDateOfBirth); 

java.util.Date utilDateOfBirth1=maritalDetailsInterface.getAnniversaryDate();
java.sql.Date sqlDateOfBirth1=new java.sql.Date(utilDateOfBirth1.getYear(),utilDateOfBirth1.getMonth(),utilDateOfBirth1.getDate());
callableStatement.setDate(4,sqlDateOfBirth1); 

callableStatement.setString(5,maritalDetailsInterface.getSpouseOccupation()); 

callableStatement.setInt(6,maritalDetailsInterface.getNumberOfGirlChild()); 

callableStatement.setInt(7,maritalDetailsInterface.getNumberOfBoyChild()); 

callableStatement.execute(); 

callableStatement.close(); 

connection.close();
 
}

catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> update() --> "+exception.getMessage()); 
}



}

public void remove(int customerCode) throws DAOException
{
try

{

	Connection connection=DAOConnection.getConnection(); 

String job="{ call remove__marital_details_by_customer_code(?) }";
 
CallableStatement callableStatement=connection.prepareCall(job); 


callableStatement.setInt(1,customerCode);
callableStatement.execute();
 
callableStatement.close();
 
connection.close();
 
}
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> remove() --> "+exception.getMessage()); 

}




}
public MaritalDetailsInterface getByCustomerCode(int customerCode) throws DAOException
{


try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_marital_details_by_customer_code(?) }";
 
CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setInt(1,customerCode);
 
boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{

callableStatement.close(); 

connection.close();
 
throw new DAOException("MaritalDetailsDAO : getByCustomerCode() --> No ResultSet object");
 
}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)
{
	
resultSet.close(); 
	
callableStatement.close(); 
	
connection.close(); 
	
throw new DAOException("MaritalDetailsDAO : getByCustomerCode() --> Invalid  Customer Code "+customerCode); 

}

MaritalDetailsInterface maritalDetailsInterface=new MaritalDetails();
 
maritalDetailsInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
maritalDetailsInterface.setSpouseName(resultSet.getString("name").trim()); 


java.sql.Date sqlDateOfBirth=resultSet.getDate("spouse_date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
maritalDetailsInterface.setSpouseDateOfBirth(utilDateOfBirth);
java.sql.Date sqlDateOfBirth1=resultSet.getDate("anniversary_date");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
 maritalDetailsInterface.setAnniversaryDate(utilDateOfBirth1);
maritalDetailsInterface.setSpouseOccupation(resultSet.getString("spouse_occupation").trim());
maritalDetailsInterface.setNumberOfGirlChild(resultSet.getInt("number_of_girl_child"));
maritalDetailsInterface.setNumberOfBoyChild(resultSet.getInt("number_of_boy_child"));
callableStatement.close(); 

connection.close(); 

return maritalDetailsInterface;
 
}
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> getByCustomerCode() --> "+exception.getMessage());
 
}



}



public ArrayList<MaritalDetailsInterface> getAll() throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
 
String job="{ call get_all_marital_details() }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{
callableStatement.close();
 
connection.close(); 

throw new DAOException("MaritalDetailsDAO : getAll() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	
callableStatement.close();
 connection.close(); 
	
throw new DAOException("MaritalDetailsDAO : getAll() --> No records ");
 
}


ArrayList<MaritalDetailsInterface> maritalDetails;
 
maritalDetails=new ArrayList<MaritalDetailsInterface>(); 

MaritalDetailsInterface maritalDetailsInterface;
  
do

{

maritalDetailsInterface=new MaritalDetails(); 


 
maritalDetailsInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
maritalDetailsInterface.setSpouseName(resultSet.getString("name").trim()); 


java.sql.Date sqlDateOfBirth=resultSet.getDate("spouse_date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
maritalDetailsInterface.setSpouseDateOfBirth(utilDateOfBirth);
java.sql.Date sqlDateOfBirth1=resultSet.getDate("anniversary_date");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
 maritalDetailsInterface.setAnniversaryDate(utilDateOfBirth1);
maritalDetailsInterface.setSpouseOccupation(resultSet.getString("spouse_occupation").trim());
maritalDetailsInterface.setNumberOfGirlChild(resultSet.getInt("number_of_girl_child"));
maritalDetailsInterface.setNumberOfBoyChild(resultSet.getInt("number_of_boy_child"));
 maritalDetails.add(maritalDetailsInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
 
connection.close(); 

return maritalDetails;
 
}
catch(SQLException sqlException)

{

throw new DAOException("MaritalDetailsDAO : getAll() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO : getAll() --> "+exception.getMessage()); 

}

}



public long getCount() throws DAOException
{
try

{

Connection connection=DAOConnection.getConnection(); 

String job="{ call get_marital_details_count(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
 
callableStatement.execute();
 
long count=callableStatement.getInt(1); 

callableStatement.close(); 

connection.close(); 

return count; 

}
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> getCount() --> "+exception.getMessage()); 

}

}
public boolean exists(int customerCode) throws DAOException
{
try

{

boolean exists=false;
 
Connection connection=DAOConnection.getConnection(); 

String job="{ call marital_details_exists_by_customer_code(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setInt(1,customerCode); 

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

throw new DAOException("MaritalDetailsDAO --> exists() --> "+exception.getMessage()); 

}

}
public void removeAll() throws DAOException
{

try

{

	Connection connection=DAOConnection.getConnection(); 

String job="{ call remove_all_marital_details() }";
 
CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.execute();
 
callableStatement.close();
 
connection.close();
 
}
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> removeAll() --> "+exception.getMessage()); 

}


}

public ArrayList<MaritalDetailsInterface> getAllBySpouseDateOfBirth(java.util.Date spouseDateOfBirth) throws DAOException
{

try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_all_married_customers_by_spouse_date_of_birth(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

java.util.Date utilDateOfBirth=spouseDateOfBirth;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 

boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{

callableStatement.close();
 
connection.close(); 

throw new DAOException("MaritalDetailsDAO : getAllBySpouseDateOfBirth() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	callableStatement.close();
 connection.close(); 
	
throw new DAOException("MaritalDetailsDAO : getAllBySpouseDateOfBirth() --> No records ");
 
}


ArrayList<MaritalDetailsInterface> maritalDetails;
 
maritalDetails=new ArrayList<MaritalDetailsInterface>(); 

MaritalDetailsInterface maritalDetailsInterface;
  
do

{

maritalDetailsInterface=new MaritalDetails(); 


 
maritalDetailsInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
maritalDetailsInterface.setSpouseName(resultSet.getString("name").trim()); 


java.sql.Date sqlDateOfBirth2=resultSet.getDate("spouse_date_of_birth");
java.util.Date utilDateOfBirth2=new java.util.Date(sqlDateOfBirth2.getYear(),sqlDateOfBirth2.getMonth(),sqlDateOfBirth2.getDate());
maritalDetailsInterface.setSpouseDateOfBirth(utilDateOfBirth2);
java.sql.Date sqlDateOfBirth1=resultSet.getDate("anniversary_date");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
 maritalDetailsInterface.setAnniversaryDate(utilDateOfBirth1);
maritalDetailsInterface.setSpouseOccupation(resultSet.getString("spouse_occupation").trim());
maritalDetailsInterface.setNumberOfGirlChild(resultSet.getInt("number_of_girl_child"));
maritalDetailsInterface.setNumberOfBoyChild(resultSet.getInt("number_of_boy_child"));
 maritalDetails.add(maritalDetailsInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
 
connection.close(); 

return maritalDetails;
 
}
catch(SQLException sqlException)

{

throw new DAOException("MaritalDetailsDAO : getAllBySpouseDateOfBirth() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO : getAllBySpouseDateOfBirth() --> "+exception.getMessage()); 

}



}
public ArrayList<MaritalDetailsInterface> getAllByAnniversaryDate(java.util.Date anniversaryDate) throws DAOException
{
try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_all_married_customers_by_anniversary_date(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

java.util.Date utilDateOfBirth=anniversaryDate;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 

boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{

callableStatement.close();
 
connection.close(); 

throw new DAOException("MaritalDetailsDAO : getAllByAnniversaryDate() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	callableStatement.close();
 connection.close(); 
	
throw new DAOException("MaritalDetailsDAO : getAllByAnniversaryDate() --> No records ");
 
}


ArrayList<MaritalDetailsInterface> maritalDetails;
 
maritalDetails=new ArrayList<MaritalDetailsInterface>(); 

MaritalDetailsInterface maritalDetailsInterface;
  
do

{

maritalDetailsInterface=new MaritalDetails(); 


 
maritalDetailsInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
maritalDetailsInterface.setSpouseName(resultSet.getString("name").trim()); 


java.sql.Date sqlDateOfBirth2=resultSet.getDate("spouse_date_of_birth");
java.util.Date utilDateOfBirth2=new java.util.Date(sqlDateOfBirth2.getYear(),sqlDateOfBirth2.getMonth(),sqlDateOfBirth2.getDate());
maritalDetailsInterface.setSpouseDateOfBirth(utilDateOfBirth2);
java.sql.Date sqlDateOfBirth1=resultSet.getDate("anniversary_date");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
 maritalDetailsInterface.setAnniversaryDate(utilDateOfBirth1);
maritalDetailsInterface.setSpouseOccupation(resultSet.getString("spouse_occupation").trim());
maritalDetailsInterface.setNumberOfGirlChild(resultSet.getInt("number_of_girl_child"));
maritalDetailsInterface.setNumberOfBoyChild(resultSet.getInt("number_of_boy_child"));
 maritalDetails.add(maritalDetailsInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
 
connection.close(); 

return maritalDetails;
 
}
catch(SQLException sqlException)

{

throw new DAOException("MaritalDetailsDAO : getAllByAnniversaryDate() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO : getAllByAnniversaryDate() --> "+exception.getMessage()); 

}




}
public ArrayList<MaritalDetailsInterface> getAllBySpouseOccupation(String spouseOccupation) throws DAOException
{
try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_all_married_customers_by_spouse_occupation(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setString(1,spouseOccupation);
boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{

callableStatement.close();
 
connection.close(); 

throw new DAOException("MaritalDetailsDAO : getAllBySpouseOccupation() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	callableStatement.close();
 connection.close(); 
	
throw new DAOException("MaritalDetailsDAO : getAllBySpouseOccupation() --> No records ");
 
}


ArrayList<MaritalDetailsInterface> maritalDetails;
 
maritalDetails=new ArrayList<MaritalDetailsInterface>(); 

MaritalDetailsInterface maritalDetailsInterface;
  
do

{

maritalDetailsInterface=new MaritalDetails(); 


 
maritalDetailsInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
maritalDetailsInterface.setSpouseName(resultSet.getString("name").trim()); 


java.sql.Date sqlDateOfBirth=resultSet.getDate("spouse_date_of_birth");
java.util.Date utilDateOfBirth=new java.util.Date(sqlDateOfBirth.getYear(),sqlDateOfBirth.getMonth(),sqlDateOfBirth.getDate());
maritalDetailsInterface.setSpouseDateOfBirth(utilDateOfBirth);
java.sql.Date sqlDateOfBirth1=resultSet.getDate("anniversary_date");
java.util.Date utilDateOfBirth1=new java.util.Date(sqlDateOfBirth1.getYear(),sqlDateOfBirth1.getMonth(),sqlDateOfBirth1.getDate());
 maritalDetailsInterface.setAnniversaryDate(utilDateOfBirth1);
maritalDetailsInterface.setSpouseOccupation(resultSet.getString("spouse_occupation").trim());
maritalDetailsInterface.setNumberOfGirlChild(resultSet.getInt("number_of_girl_child"));
maritalDetailsInterface.setNumberOfBoyChild(resultSet.getInt("number_of_boy_child"));
 maritalDetails.add(maritalDetailsInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
 
connection.close(); 

return maritalDetails;
 
}
catch(SQLException sqlException)

{

throw new DAOException("MaritalDetailsDAO : getAllBySpouseOccupation() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO : getAllBySpouseOccupation() --> "+exception.getMessage()); 

}



}
public int getCountBySpouseDateOfBirth(java.util.Date spouseDateOfBirth) throws DAOException
{
try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_married_customer_count_by_spouse_date_of_birth(?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

java.util.Date utilDateOfBirth=spouseDateOfBirth;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 

callableStatement.registerOutParameter(2,Types.INTEGER); 

callableStatement.execute(); 

int count=callableStatement.getInt(2);
 
callableStatement.close();
 
connection.close();
 
return count;
 
}

catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> getCountBySpouseDateOfBirth() --> "+exception.getMessage()); 

}



}
public int getCountByAnniversaryDate(java.util.Date anniversaryDate) throws DAOException
{
try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_married_customer_count_by_anniversary_date(?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

java.util.Date utilDateOfBirth=anniversaryDate;
java.sql.Date sqlDateOfBirth=new java.sql.Date(utilDateOfBirth.getYear(),utilDateOfBirth.getMonth(),utilDateOfBirth.getDate());
callableStatement.setDate(1,sqlDateOfBirth); 

callableStatement.registerOutParameter(2,Types.INTEGER); 

callableStatement.execute(); 

int count=callableStatement.getInt(2);
 
callableStatement.close();
 
connection.close();
 
return count;
 
}

catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> getCountByAnniversaryDate() --> "+exception.getMessage()); 

}



}
public int getCountBySpouseOccupation(String spouseOccupation) throws DAOException
{

try

{

Connection connection=DAOConnection.getConnection();
 
String job="{ call get_married_customer_count_by_spouse_occupation(?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setString(1,spouseOccupation); 

callableStatement.registerOutParameter(2,Types.INTEGER); 

callableStatement.execute(); 

int count=callableStatement.getInt(2);
 
callableStatement.close();
 
connection.close();
 
return count;
 
}

catch(Exception exception)

{

throw new DAOException("MaritalDetailsDAO --> getCountBySpouseOccupation() --> "+exception.getMessage()); 

}


}

}
