import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetCountTestCase
{
public static void main(String data[])
{
try
{


VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
System.out.println(vendorOutletDAOInterface.getCount(null));

}
catch(Exception e)
{
System.out.println(e);
}
}
}
