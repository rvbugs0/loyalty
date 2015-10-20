import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCityCountTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();

System.out.println(cityDAOInterface.getCount());
}
catch(Exception e)
{
System.out.println(e);
}
}
}
