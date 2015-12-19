import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class UpdateCustomerTestCase
{
	public static void main(String data[])
	{
		try
		{

			CustomerInterface customerInterface=new Customer();
			customerInterface.setName("Ravi Ailani");
			customerInterface.setUsername("railani1");
			customerInterface.setPassword("@Ravi_00017");
			customerInterface.setPasswordKey("6g5g98fd7fds545fds");
			customerInterface.setPermanentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCurrentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCityCode(777);
			customerInterface.setDateOfBirth(new java.util.Date());
			customerInterface.setGender("M");
			customerInterface.setOccupation("Student");
			customerInterface.setIsMarried(false);
			customerInterface.setIsStudent(true);
			customerInterface.setContactNumber("7869053131");
			customerInterface.setEmailId("ravibugs@yahoo.co.in");
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			customerDAOInterface.add(customerInterface);
			System.out.println("Customer Added");
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}