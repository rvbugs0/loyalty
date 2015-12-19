import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetByCodeTestCase
{
	public static void main(String data[])
	{
		try
		{
			CityInterface cityInterface=new CityDAO().getByCode(777,null);
			System.out.println(cityInterface.getCode());
			System.out.println(cityInterface.getName());
			System.out.println(cityInterface.getState());
			System.out.println(cityInterface.getCountry());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}