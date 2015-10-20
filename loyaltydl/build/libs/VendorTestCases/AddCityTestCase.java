import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddCityTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
CityInterface cityInterface=new City();
cityInterface.setName(data[0]);
cityInterface.setState(data[1]);
cityInterface.setCountry(data[2]);
cityDAOInterface.add(cityInterface);
System.out.println("added");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
