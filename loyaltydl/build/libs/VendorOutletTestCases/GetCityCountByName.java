import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCityCountByName
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();

System.out.println(cityDAOInterface.getCountByName(data[0]));
}
catch(Exception e)
{
System.out.println(e);
}
}
}
