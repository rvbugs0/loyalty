import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCountTestCase
{
	public static void main(String data[])
	{
		try
		{
			System.out.println(new CityDAO().getCount(null));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}