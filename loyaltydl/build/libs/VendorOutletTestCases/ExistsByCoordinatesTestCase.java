import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class ExistsByCoordinatesTestCase
{
public static void main(String data[])
{
try
{
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
boolean a=vendorOutletDAOInterface.existsByCoordinates("30","40.0000",null);
System.out.println(a);
}
catch(Exception e)
{
System.out.println(e);
}
}
}

