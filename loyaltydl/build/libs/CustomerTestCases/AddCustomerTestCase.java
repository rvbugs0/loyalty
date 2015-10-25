import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddCustomerTestCase
{
	public static void main(String data[])
	{
		try
		{

			CustomerInterface customerInterface=new Customer();
			customerInterface.setName("Ravi Ailani");
			customerInterface.setUsername("rvbugs0");
			customerInterface.setPassword("@Ravi_00017");
			customerInterface.setPasswordKey("6g5g98fd7fds545fds");
			customerInterface.setPermanentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCurrentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCityCode(778);
			customerInterface.setDateOfBirth(new java.util.Date());
			customerInterface.setGender("M");
			customerInterface.setOccupation("Student");
			customerInterface.setIsMarried(false);
			customerInterface.setIsStudent(true);
			customerInterface.setContactNumber("8518900017");
			customerInterface.setEmailId("rvbugs0@gmail.com");
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