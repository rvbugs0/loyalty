import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
class GetAllCityTestCase
{
public static void main(String data[])
{
try
{
CityDAOInterface cityDAOInterface=new CityDAO();
int x=0;
ArrayList<CityInterface> cities=cityDAOInterface.getAll();
int s=cities.size();
while(x<s)
{
CityInterface c=cities.get(x);	
System.out.print(c.getCode()+"\t");
System.out.print(c.getName()+"\t");
System.out.print(c.getState()+"\t");
System.out.print(c.getCountry()+"\t");
System.out.println("");
x++;
}

}
catch(Exception e)
{
System.out.println(e);
}
}
}
