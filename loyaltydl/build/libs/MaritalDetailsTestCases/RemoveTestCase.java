import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class RemoveTestCase
{
	public static void main(String gg[])
	{
		try
		{
				MaritalDetailsDAOInterface maritalDetailsDAOInterface=new MaritalDetailsDAO();
				maritalDetailsDAOInterface.remove(14);
				System.out.println("removed");			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}