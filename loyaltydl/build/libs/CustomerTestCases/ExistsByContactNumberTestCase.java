import java.util.*;
import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByContactNumberTestCase
{
	public static void main(String data[])
	{
		try
		{
			CustomerDAOInterface customerDAOInterface=new CustomerDAO();
			System.out.println(customerDAOInterface.existsByContactNumber("78690531"));
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}
}