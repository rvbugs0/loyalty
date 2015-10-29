import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByCodeTestCase
{
public static void main(String data[])
{
try
{
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
boolean a=vendorOutletDAOInterface.exists(2,null);
System.out.println(a);
}
catch(Exception e)
{
System.out.println(e);
}
}
}

