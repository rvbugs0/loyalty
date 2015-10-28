import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddCityTestCase
{
	public static void main(String data[])
	{
		try
		{
			CityInterface cityInterface=new City();
			cityInterface.setName("Ujjain");
			cityInterface.setState("Maharashtra");
			cityInterface.setCountry("India");
			new CityDAO().add(cityInterface);
			System.out.println("Added");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}