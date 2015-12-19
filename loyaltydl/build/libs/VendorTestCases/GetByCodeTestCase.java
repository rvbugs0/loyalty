import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetByCodeTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();
VendorInterface c=vendorDAOInterface.getByCode(Integer.parseInt(data[0]));
System.out.print(c.getCode()+"\t");
System.out.print(c.getName()+"\t");
System.out.print(c.getPassword()+"\t");
System.out.print(c.getPasswordKey()+"\t");
System.out.print(c.getCityCode()+"\t");
System.out.print(c.getAddress()+"\t");
System.out.print(c.getEmailId()+"\t");
System.out.print(c.getContactNumber()+"\t");

}
catch(Exception e)
{
System.out.println(e);
}
}
}
