import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddVendorOutletTestCase
{
public static void main(String data[])
{
try
{

System.out.println("Enter vendor_code ,address , latitude ,longitude , city code ,contact ");
VendorOutletInterface vendorOutletInterface=new VendorOutlet();
VendorOutletDAOInterface vendorOutletDAOInterface=new VendorOutletDAO();
vendorOutletInterface.setVendorCode(Integer.parseInt(data[0]));
vendorOutletInterface.setAddress(data[1]);
vendorOutletInterface.setLatitude(data[2]);
vendorOutletInterface.setLongitude(data[3]);
vendorOutletInterface.setCityCode(Integer.parseInt(data[4]));
vendorOutletInterface.setContactNumber(data[5]);
vendorOutletDAOInterface.add(vendorOutletInterface);
System.out.println("added");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
