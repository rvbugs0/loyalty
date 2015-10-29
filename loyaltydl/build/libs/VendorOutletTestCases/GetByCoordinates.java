import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetByCoordinatesTestCase
{
public static void main(String data[])
{
try
{

VendorOutletInterface vendorOutletInterface;
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletInterface=vendorOutletDAOInterface.getByCoordinates("30.0000","40.0000",null);
System.out.println(vendorOutletInterface.getVendorCode());
System.out.println(vendorOutletInterface.getAddress());
System.out.println(vendorOutletInterface.getLatitude());
System.out.println(vendorOutletInterface.getLongitude());
System.out.println(vendorOutletInterface.getCityCode());
System.out.println(vendorOutletInterface.getContactNumber());

}
catch(Exception e)
{
System.out.println(e);
}
}
}
