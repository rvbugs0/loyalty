import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCustomerByCodeTestCase
{
	public static void main(String data[])
	{
		try
		{
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			CustomerInterface customerInterface=customerDAOInterface.getByCode(1);
			System.out.println(customerInterface.getName());
			System.out.println(customerInterface.getUsername());
			System.out.println(customerInterface.getPassword());
			System.out.println(customerInterface.getPasswordKey());
			System.out.println(customerInterface.getPermanentAddress());
			System.out.println(customerInterface.getCurrentAddress());
			System.out.println(customerInterface.getCityCode());
			System.out.println(customerInterface.getDateOfBirth());
			System.out.println(customerInterface.getGender());
			System.out.println(customerInterface.getOccupation());
			System.out.println(customerInterface.getIsMarried());
			System.out.println(customerInterface.getIsStudent());
			System.out.println(customerInterface.getContactNumber());
			System.out.println(customerInterface.getEmailId());

		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}