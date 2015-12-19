import java.util.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetAllByNameTestCase
{
	public static void main(String data[])
	{
		try
		{
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			CustomerInterface customerInterface;
			ArrayList<CustomerInterface> customers=customerDAOInterface.getAllByName("Ravi Ailani");
			int x=0;
			int s=customers.size();
			while(x<s)
			{
			customerInterface=customers.get(x);
			System.out.println("Customer : "+customerInterface.getCode());
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

				x++;
			}

		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}