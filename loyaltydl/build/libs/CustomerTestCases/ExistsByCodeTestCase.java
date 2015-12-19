import java.util.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByCodeTestCase
{
	public static void main(String data[])
	{
		try
		{
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			System.out.println(customerDAOInterface.exists(40));
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}