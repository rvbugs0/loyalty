import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetAllTestCase
{
	public static void main(String data[])
	{
		try
		{
			ArrayList<CityInterface> cities=new CityDAO().getAll(null);
			int s= cities.size();
			int x=0;
			while(x<s)
			{
				CityInterface cityInterface=cities.get(x);
			System.out.println(cityInterface.getCode());
			System.out.println(cityInterface.getName());
			System.out.println(cityInterface.getState());
			System.out.println(cityInterface.getCountry());
				x++;
			}

			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}