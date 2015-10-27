import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByCodeTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();

System.out.println(vendorDAOInterface.exists(1));

}
catch(Exception e)
{
System.out.println(e);
}
}
}
