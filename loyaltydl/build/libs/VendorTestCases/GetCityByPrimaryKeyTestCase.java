import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCityByPrimaryKeyTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
CityInterface cityInterface=cityDAOInterface.getByPrimaryKey(Integer.parseInt(data[0]));
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
