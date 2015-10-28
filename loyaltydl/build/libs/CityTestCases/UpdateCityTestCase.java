import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class UpdateCityTestCase
{
	public static void main(String data[])
	{
		try
		{
			CityInterface cityInterface=new City();
			cityInterface.setCode(777);
			cityInterface.setName("Ujjain");
			cityInterface.setState("Madhya Pradesh");
			cityInterface.setCountry("India");
			new CityDAO().update(cityInterface,null);
			System.out.println("updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}