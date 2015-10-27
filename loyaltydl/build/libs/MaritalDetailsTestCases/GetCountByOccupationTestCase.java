import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCountByOccupationTestCase
{
	public static void main(String data[])
	{
		try
		{
			System.out.println(new MaritalDetailsDAO().getCountBySpouseOccupation("film director"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}