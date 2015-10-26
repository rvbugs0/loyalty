import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddCustomerTestCase
{
	public static void main(String data[])
	{
		try
		{

			CustomerInterface customerInterface=new Customer();
			customerInterface.setName("Ram Gopal");
			customerInterface.setUsername("rgpv0");
			customerInterface.setPassword("@rgv005");
			customerInterface.setPasswordKey("6g5g98fd7fds545fds");
			customerInterface.setPermanentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCurrentAddress("40 adarsh vikram nagar ,sethinagar");
			customerInterface.setCityCode(779);
			customerInterface.setDateOfBirth(new java.util.Date());
			customerInterface.setGender("M");
			customerInterface.setOccupation("Movie Director");
			customerInterface.setIsMarried(true);
			customerInterface.setIsStudent(false);
			customerInterface.setContactNumber("8658900017");
			customerInterface.setEmailId("rgpv0@gmail.com");
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