import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetByCustomerCodeTestCase
{
	public static void main(String gg[])
	{
		try
		{
				MaritalDetailsDAOInterface maritalDetailsDAOInterface=new MaritalDetailsDAO();
				MaritalDetailsInterface maritalDetailsInterface=maritalDetailsDAOInterface.getByCustomerCode(15);
				System.out.println(maritalDetailsInterface.getCustomerCode());
				System.out.println(maritalDetailsInterface.getSpouseName());
				System.out.println(maritalDetailsInterface.getSpouseDateOfBirth());
				System.out.println(maritalDetailsInterface.getAnniversaryDate());
				System.out.println(maritalDetailsInterface.getSpouseOccupation());
				System.out.println(maritalDetailsInterface.getNumberOfGirlChild());
				System.out.println(maritalDetailsInterface.getNumberOfBoyChild());				
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}