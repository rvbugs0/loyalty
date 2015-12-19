import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCountTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();
System.out.println(vendorDAOInterface.getCount());
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}
