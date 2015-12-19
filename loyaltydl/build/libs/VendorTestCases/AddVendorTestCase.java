import com.thinking.machines.loyalty.dao.*;
import java.util.*;
import com.thinking.machines.loyalty.interfaces.*;
class AddVendorTestCase
{
public static void main(String data[])
{
try
{

System.out.println("Enter name,username,passwordkey, password,city,address,email,contact ");
VendorInterface vendorInterface=new Vendor();
VendorDAOInterface vendorDAOInterface=new VendorDAO();
vendorInterface.setName(data[0]);
vendorInterface.setUsername(data[1]);
vendorInterface.setPasswordKey(data[2]);
vendorInterface.setPassword(data[3]);
vendorInterface.setCityCode(Integer.parseInt(data[4]));
vendorInterface.setAddress(data[5]);
vendorInterface.setEmailId(data[6]);
vendorInterface.setContactNumber(data[7]);
vendorDAOInterface.add(vendorInterface);
System.out.println("added");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
