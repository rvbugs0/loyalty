import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByCodeTestCase
{
	public static void main(String data[])
	{
		try
		{
			System.out.println(new CityDAO().exists(777,null));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}