import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
class UpdateVendorTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();
VendorInterface vendorInterface=new Vendor();
vendorInterface.setCode(Integer.parseInt(data[8]));
vendorInterface.setName(data[0]);
vendorInterface.setUsername(data[1]);
vendorInterface.setPasswordKey(data[2]);
vendorInterface.setPassword(data[3]);
vendorInterface.setCityCode(Integer.parseInt(data[4]));
vendorInterface.setAddress(data[5]);
vendorInterface.setEmailId(data[6]);
vendorInterface.setContactNumber(data[7]);
vendorDAOInterface.update(vendorInterface);
System.out.println("Updated");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
