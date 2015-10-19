import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class RemoveAllCitiesTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
cityDAOInterface.removeAll();
System.out.println("deleted all");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
