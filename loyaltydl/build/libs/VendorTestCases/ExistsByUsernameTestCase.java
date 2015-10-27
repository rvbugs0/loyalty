import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByUsernameTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();
System.out.println(vendorDAOInterface.existsByUsername(data[0]));

}
catch(Exception e)
{
System.out.println(e);
}
}
}
