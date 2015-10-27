import com.thinking.machines.loyalty.dao.*;
import com.thinking.machines.loyalty.interfaces.*;
import java.util.*;
class GetAllVendorsTestCase
{
public static void main(String data[])
{
try
{
VendorDAOInterface vendorDAOInterface=new VendorDAO();
int x=0;
ArrayList<VendorInterface> vendors=vendorDAOInterface.getAll();
int s=vendors.size();
while(x<s)
{
VendorInterface c=vendors.get(x);	
System.out.print(c.getCode()+"\t");
System.out.print(c.getName()+"\t");
System.out.print(c.getPassword()+"\t");
System.out.print(c.getPasswordKey()+"\t");
System.out.print(c.getCityCode()+"\t");
System.out.print(c.getAddress()+"\t");
System.out.print(c.getEmailId()+"\t");
System.out.print(c.getContactNumber()+"\t");
System.out.println("");

x++;
}

}
catch(Exception e)
{
System.out.println(e);
}
}
}
