import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class GetAllTestCase
{
public static void main(String data[])
{
try
{


VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
ArrayList<VendorOutletInterface> vendors=vendorOutletDAOInterface.getAll(null);
int x=0;
int s=vendors.size();
while(x<s)
{
	VendorOutletInterface vendor=vendors.get(x);
System.out.println(vendor.getVendorCode());
System.out.println(vendor.getAddress());
System.out.println(vendor.getLatitude());
System.out.println(vendor.getLongitude());
System.out.println(vendor.getCityCode());
System.out.println(vendor.getContactNumber());
	x++;
}


}
catch(Exception e)
{
System.out.println(e);
}
}
}
