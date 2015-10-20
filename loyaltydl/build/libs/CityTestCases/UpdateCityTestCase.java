import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class UpdateCityTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
CityInterface cityInterface=new City();
cityInterface.setCode(1);
cityInterface.setName("Kolhapur");
cityInterface.setState("Maharashtra");
cityInterface.setCountry("India");
cityDAOInterface.update(cityInterface);
System.out.println("Updated");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
