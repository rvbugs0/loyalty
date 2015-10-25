import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByNameTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
System.out.println(cityDAOInterface.existsByName(data[0]));
}
catch(Exception e)
{
System.out.println(e);
}
}
}
