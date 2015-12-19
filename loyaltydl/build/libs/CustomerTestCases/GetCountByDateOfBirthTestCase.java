import java.util.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCountByDateOfBirthTestCase
{
	public static void main(String data[])
	{
		try
		{
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			System.out.println(customerDAOInterface.getCountByDateOfBirth(new java.util.Date()));
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}