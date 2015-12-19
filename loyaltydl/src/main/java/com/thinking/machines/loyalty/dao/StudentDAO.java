package com.thinking.machines.loyalty.dao; 

import java.util.*; 

import java.sql.*; 

import com.thinking.machines.loyalty.interfaces.*;
 
import com.thinking.machines.loyalty.exceptions.*; 

public class StudentDAO implements StudentDAOInterface

{

public void add(StudentInterface studentInterface,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

if(exists(studentInterface.getCustomerCode(),connection))

{

throw new DAOException("StudentDAO : add()" +studentInterface.getCustomerCode()+" already exists");
 
}


if(!(new CustomerDAO().exists(studentInterface.getCustomerCode(),connection)))

{
throw new DAOException("StudentDAO : add() invalid customer code : " + studentInterface.getCustomerCode());	
		}

boolean isStudent=new CustomerDAO().getByCode(studentInterface.getCustomerCode(),connection).getIsStudent();
if(!isStudent)
{
throw new DAOException("StudentDAO : add() : Customer with code " +studentInterface.getCustomerCode()+" is not student");
}

 
String job="{ call add_student(?,?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setInt(1,studentInterface.getCustomerCode()); 

callableStatement.setString(2,studentInterface.getStream()); 

callableStatement.setString(3,studentInterface.getCourseDetails()); 

callableStatement.execute();
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}

}
catch(Exception exception)

{

throw new DAOException("StudentDAO --> add() --> "+exception.getMessage());
 
}

}



public void update(StudentInterface studentInterface,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

if(!exists(studentInterface.getCustomerCode(),connection))

{

throw new DAOException("StudentDAO : update() --> Invalid Student Code :"+studentInterface.getCustomerCode());
 
}


boolean isStudent=new CustomerDAO().getByCode(studentInterface.getCustomerCode(),connection).getIsStudent();
if(!isStudent)
{
throw new DAOException("StudentDAO: update() : Customer with code "+studentInterface.getCustomerCode()+"is not student");
}
String job="{ call update_student(?,?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job);
 
callableStatement.setInt(1,studentInterface.getCustomerCode()); 

callableStatement.setString(2,studentInterface.getStream()); 

callableStatement.setString(3,studentInterface.getCourseDetails()); 


callableStatement.execute(); 

callableStatement.close(); 

if(closeConnection)
		{
			connection.close();
		}

 
}

catch(Exception exception)

{

throw new DAOException("StudentDAO --> update() --> "+exception.getMessage()); 
}


}






public StudentInterface getByCustomerCode(int customerCode,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

 
String job="{ call get_student_by_customer_code(?) }";
 
CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setInt(1,customerCode);
 
boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{

callableStatement.close(); 

connection.close();
 
throw new DAOException("StudentDAO : getByCustomerCode() --> No ResultSet object");
 
}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)
{
	
resultSet.close(); 
	
callableStatement.close(); 
	
connection.close(); 
	
throw new DAOException("StudentDAO : getByCustomerCode() --> Invalid  Customer Code "+customerCode); 

}

StudentInterface studentInterface=new Student();
 
studentInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
studentInterface.setStream(resultSet.getString("stream").trim()); 

studentInterface.setCourseDetails(resultSet.getString("course_details").trim());
 callableStatement.close(); 

if(closeConnection)
		{
			connection.close();
		}
return studentInterface;
 
}
catch(Exception exception)

{

throw new DAOException("StudentDAO --> getByCustomerCode() --> "+exception.getMessage());
 
}


}



public ArrayList<StudentInterface> getAll(Connection connection) throws DAOException

{
boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}


 
String job="{ call get_all_students() }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{
callableStatement.close();
 
connection.close(); 

throw new DAOException("StudentDAO : getAll() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	callableStatement.close();
 connection.close(); 
	
throw new DAOException("StudentDAO : getAll() --> No records ");
 
}


ArrayList<StudentInterface> students;
 
students=new ArrayList<StudentInterface>(); 

StudentInterface studentInterface;
  
do

{

studentInterface=new Student(); 


studentInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
studentInterface.setStream(resultSet.getString("stream").trim()); 

studentInterface.setCourseDetails(resultSet.getString("course_details").trim());
 students.add(studentInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return students;
 
}
catch(SQLException sqlException)

{

throw new DAOException("StudentDAO : getAll() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("StudentDAO : getAll() --> "+exception.getMessage()); 

}

}




public ArrayList<StudentInterface> getAllByStream(String stream,Connection connection) throws DAOException

{boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}


 
String job="{ call get_all_students_by_stream(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setString(1,stream);
boolean resultGenerated=callableStatement.execute();
 
if(!resultGenerated)

{
callableStatement.close();
 
connection.close(); 

throw new DAOException("StudentDAO : getAllByStream() --> No ResultSet object"); 

}

ResultSet resultSet=callableStatement.getResultSet();
 
if(resultSet.next()==false)

{

resultSet.close(); 
	callableStatement.close();
 connection.close(); 
	
throw new DAOException("StudentDAO : getAllByStream() --> No records ");
 
}


ArrayList<StudentInterface> students;
 
students=new ArrayList<StudentInterface>(); 

StudentInterface studentInterface;
  
do

{

studentInterface=new Student(); 


studentInterface.setCustomerCode(resultSet.getInt("customer_code"));
 
studentInterface.setStream(resultSet.getString("stream").trim()); 

studentInterface.setCourseDetails(resultSet.getString("course_details").trim());
 students.add(studentInterface);
 
}
while(resultSet.next());
 
resultSet.close();callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}
return students;
 
}
catch(SQLException sqlException)

{

throw new DAOException("StudentDAO : getAllByStream() --> "+sqlException.getMessage());
 
}
 
catch(Exception exception)

{

throw new DAOException("StudentDAO : getAllByStream() --> "+exception.getMessage()); 

}

}




public int getCountByStream(String stream,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

 
String job="{ call get_student_count_by_stream(?,?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.setString(1,stream); 

callableStatement.registerOutParameter(2, java.sql.Types.INTEGER); 

callableStatement.execute(); 

int count=callableStatement.getInt(2);
 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}

 
return count;
 
}

catch(Exception exception)

{

throw new DAOException("StudentDAO --> getCountByStream() --> "+exception.getMessage()); 

}

}

public boolean exists(int customerCode,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

boolean exists=false;
String job="{ call student_exists_by_customer_code(?) }"; 

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

if(closeConnection)
		{
			connection.close();
		}

return exists;
 
}

catch(Exception exception)

{

throw new DAOException("StudentDAO --> exists() --> "+exception.getMessage()); 

}

}


public long getCount(Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

String job="{ call get_student_count(?) }"; 

CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
 
callableStatement.execute();
 
long count=callableStatement.getInt(1); 

callableStatement.close(); 

if(closeConnection)
		{
			connection.close();
		}
return count; 

}
catch(Exception exception)

{

throw new DAOException("StudentDAO --> getCount() --> "+exception.getMessage()); 

}

}


      


public void removeAll(Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

String job="{ call remove_all_students() }";
 
CallableStatement callableStatement=connection.prepareCall(job); 

callableStatement.execute();
 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}

 
}
catch(Exception exception)

{

throw new DAOException("StudentDAO --> removeAll() --> "+exception.getMessage()); 

}


}




public void remove(int customerCode,Connection connection) throws DAOException

{

boolean closeConnection=false;
try{

if(connection==null)
{
connection=DAOConnection.getConnection();
closeConnection=true;

}

CustomerDAOInterface customerDAOInterface=new CustomerDAO();	
if(!customerDAOInterface.exists(customerCode,connection))	
{
throw new DAOException("StudentDAO --> remove() --> invalid customer code"); 	
}
if(customerDAOInterface.getByCode(customerCode,connection).getIsStudent())
{
throw new DAOException("StudentDAO --> remove() --> Customer is student - cannot remove details");
}

String job="{ call remove_student_by_customer_code(?) }";
 
CallableStatement callableStatement=connection.prepareCall(job); 
callableStatement.setInt(1,customerCode);
callableStatement.execute();
 
callableStatement.close();
if(closeConnection)
		{
			connection.close();
		}

 
}
catch(Exception exception)

{

throw new DAOException("StudentDAO --> remove() --> "+exception.getMessage()); 

}



}
}