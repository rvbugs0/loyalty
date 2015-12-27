package com.thinking.machines.loyalty.application;
import java.util.*;
import com.thinking.machines.loyalty.bl.*;
import com.thinking.machines.loyalty.application.exceptions.*;
import com.thinking.machines.loyalty.bl.exceptions.*;
import com.thinking.machines.loyalty.bl.interfaces.*;
public class LoyaltyApplication
{

/*City*/


public void addCity(CityBLInterface cityInterface) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
cityManager.add(cityInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void updateCity(CityBLInterface cityInterface) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
cityManager.update(cityInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public CityBLInterface getByCityCode(int code) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getByCityCode(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public ArrayList<CityBLInterface> getAllCities() throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getAllCities();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

/*
public ArrayList<CityBLInterface> getByState(String state) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getByState(state);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public ArrayList<CityBLInterface> getByCountry(String country) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getByCountry(country);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public int getCountByCountry(String country) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getCountByCountry(country);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
*/
public long getCount() throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getCount();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

/*
public int getCountByState(String state) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
return cityManager.getCountByState(state);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
*/
public void removeCity(int code) throws ApplicationException
{
try
{
CityManager cityManager=new CityManager();
cityManager.remove(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


/*Customer */

public void addCustomer(CustomerBLInterface customerInterface) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
customerManager.add(customerInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void updateCustomer(CustomerBLInterface customerInterface) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
customerManager.update(customerInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public CustomerBLInterface getCustomerByUsername(String username) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getByUsername(username);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public CustomerBLInterface getCustomerByEmailId(String emailId) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getByEmailId(emailId);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public CustomerBLInterface getCustomerByContactNumber(String contactNumber) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getByContactNumber(contactNumber);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public CustomerBLInterface getCustomerByCode(int code) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getByCode(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomers() throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAll();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomersByName(String name) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAllByName( name);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomersByOccupation(String occupation) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAllByOccupation(occupation);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomersByCityCode(int cityCode) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAllByCityCode(cityCode);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomersByDateOfBirth(java.util.Date dateOfBirth) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAllByDateOfBirth(dateOfBirth);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<CustomerBLInterface> getAllCustomersByCustomerType(com.thinking.machines.loyalty.interfaces.CustomerDAOInterface.CustomerType customerType) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getAllByCustomerType(customerType);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public int getCustomerCountByName(String name) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getCountByName(name);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
public long getCustomerCountByOccupation(String occupation) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getCountByOccupation(occupation);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public long getCustomerCountByCityCode(int cityCode) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getCountByCityCode(cityCode);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
public long getCustomerCount() throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getCount();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
public long getCustomerCountByDateOfBirth(java.util.Date dateOfBirth) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
return customerManager.getCountByDateOfBirth(dateOfBirth);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
public void removeAllCustomers() throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
customerManager.removeAll();

}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
public void removeCustomer(int code) throws ApplicationException
{
try
{
CustomerManager customerManager=new CustomerManager();
customerManager.remove(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


/*Vendor outlet*/

public void addVendorOutlet(VendorOutletBLInterface vendorOutletInterface) throws ApplicationException
{
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutletManager.add(vendorOutletInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->addVendorOutlet"+blException.getMessage());
}
}

public void updateVendorOutlet(VendorOutletBLInterface vendorOutletInterface) throws ApplicationException
{
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutletManager.update(vendorOutletInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->updateVendorOutlet"+blException.getMessage());
}
}

public void removeVendorOutlet(int code) throws ApplicationException
{
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutletManager.remove(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->removeVendorOutlet"+blException.getMessage());
}
}

public VendorOutletBLInterface getVendorOutletByCode(int code) throws ApplicationException
{
VendorOutletBLInterface vendorOutletInterface;
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutletInterface=vendorOutletManager.getByCode(code);
return vendorOutletInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorOutletByCode"+blException.getMessage());
}
}

public ArrayList<VendorOutletBLInterface> getAllVendorOutlets() throws ApplicationException
{
ArrayList<VendorOutletBLInterface> vendorOutlets=new ArrayList<VendorOutletBLInterface>();
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutlets=vendorOutletManager.getAll();
return vendorOutlets;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAllVendorOutlets()"+blException.getMessage());
}
}


public ArrayList<VendorOutletBLInterface> getAllVendorOutletsByVendorCode(int code) throws ApplicationException
{
ArrayList<VendorOutletBLInterface> vendorOutlets=new ArrayList<VendorOutletBLInterface>();
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutlets=vendorOutletManager.getAllByVendorCode(code);
return vendorOutlets;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAllVendorOutletsByVendorCode()"+blException.getMessage());
}
}


public ArrayList<VendorOutletBLInterface> getAllVendorOutletsByCityCode(int code) throws ApplicationException
{
ArrayList<VendorOutletBLInterface> vendorOutlets=new ArrayList<VendorOutletBLInterface>();
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutlets=vendorOutletManager.getAllByCityCode(code);
return vendorOutlets;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAllVendorOutletsByCityCode()"+blException.getMessage());
}
}

public void removeAllVendorOutlets() throws ApplicationException
{
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
vendorOutletManager.removeAll();
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->removeAllVendorOutlets"+blException.getMessage());
}
}

public boolean vendorOutletExists(int code) throws ApplicationException
{
boolean exists=false;
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
exists=vendorOutletManager.exists(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorOutletExists"+blException.getMessage());
}
return exists;
}


public long getVendorOutletCount() throws ApplicationException
{
long count=0;
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
count=vendorOutletManager.getCount();
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getCountVendorOutlet"+blException.getMessage());
}
return count;
}

public long getVendorOutletCountByCityCode(int code) throws ApplicationException
{
long count=0;
try{
VendorOutletManager vendorOutletManager=new VendorOutletManager();
count=vendorOutletManager.getCountByCity(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getCountByCityVendorOutlet"+blException.getMessage());
}
return count;
}


//vendor
public void addVendor(VendorBLInterface vendorInterface) throws ApplicationException
{
try{
VendorManager vendorManager=new VendorManager();
vendorManager.add(vendorInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->addVendor"+blException.getMessage());
}
}

public void updateVendor(VendorBLInterface vendorInterface) throws ApplicationException
{
try{
VendorManager vendorManager=new VendorManager();
vendorManager.update(vendorInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->updateVendor"+blException.getMessage());
}
}

public void removeVendor(int code) throws ApplicationException
{
try{
VendorManager vendorManager=new VendorManager();
vendorManager.remove(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->removeVendor"+blException.getMessage());
}
}

public VendorBLInterface getVendorByCode(int code) throws ApplicationException
{
VendorBLInterface vendorInterface;
try{
VendorManager vendorManager=new VendorManager();
vendorInterface=vendorManager.getByCode(code);
return vendorInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorByCode"+blException.getMessage());
}
}

public VendorBLInterface getVendorByUsername(String username) throws ApplicationException
{
VendorBLInterface vendorInterface;
try{
VendorManager vendorManager=new VendorManager();
vendorInterface=vendorManager.getByUsername(username);
return vendorInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorByUsername"+blException.getMessage());
}
}


public VendorBLInterface getVendorByName(String name) throws ApplicationException
{
VendorBLInterface vendorInterface;
try{
VendorManager vendorManager=new VendorManager();
vendorInterface=vendorManager.getByName(name);
return vendorInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorByName"+blException.getMessage());
}
}

public VendorBLInterface getVendorByContactNumber(String contactNumber) throws ApplicationException
{
VendorBLInterface vendorInterface;
try{
VendorManager vendorManager=new VendorManager();
vendorInterface=vendorManager.getByContactNumber(contactNumber);
return vendorInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorByContactNumber"+blException.getMessage());
}
}


public VendorBLInterface getVendorByEmailId(String emailId) throws ApplicationException
{
VendorBLInterface vendorInterface;
try{
VendorManager vendorManager=new VendorManager();
vendorInterface=vendorManager.getByEmailId(emailId);
return vendorInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getVendorByEmailId"+blException.getMessage());
}
}


public ArrayList<VendorBLInterface> getAllVendors() throws ApplicationException
{
ArrayList<VendorBLInterface> vendors=new ArrayList<VendorBLInterface>();
try{
VendorManager vendorManager=new VendorManager();
vendors=vendorManager.getAll();
return vendors;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAllVendors()"+blException.getMessage());
}
}


public ArrayList<VendorBLInterface> getAllVendorsByCityCode(int cityCode) throws ApplicationException
{
ArrayList<VendorBLInterface> vendors=new ArrayList<VendorBLInterface>();
try{
VendorManager vendorManager=new VendorManager();
vendors=vendorManager.getAllByCityCode(cityCode);
return vendors;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAllVendorsByCityCode()"+blException.getMessage());
}
}

public void removeAllVendors() throws ApplicationException
{
try{
VendorManager vendorManager=new VendorManager();
vendorManager.removeAll();
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->removeAllVendors"+blException.getMessage());
}
}

public boolean vendorExists(int code) throws ApplicationException
{
boolean exists=false;
try{
VendorManager vendorManager=new VendorManager();
exists=vendorManager.exists(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorExists"+blException.getMessage());
}
return exists;
}


public boolean vendorExistsByUsername(String username) throws ApplicationException
{
boolean exists=false;
try{
VendorManager vendorManager=new VendorManager();
exists=vendorManager.existsByUsername(username);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorExistsByUsername"+blException.getMessage());
}
return exists;
}


public boolean vendorExistsByName(String name) throws ApplicationException
{
boolean exists=false;
try{
VendorManager vendorManager=new VendorManager();
exists=vendorManager.existsByName(name);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorExistsByName"+blException.getMessage());
}
return exists;
}


public boolean vendorExistsByEmailId(String emailId) throws ApplicationException
{
boolean exists=false;
try{
VendorManager vendorManager=new VendorManager();
exists=vendorManager.existsByEmailId(emailId);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorExistsByEmailId"+blException.getMessage());
}
return exists;
}


public boolean vendorExistsByContactNumber(String contactNumber) throws ApplicationException
{
boolean exists=false;
try{
VendorManager vendorManager=new VendorManager();
exists=vendorManager.existsByContactNumber(contactNumber);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorExistsByContactNumber"+blException.getMessage());
}
return exists;
}


public long getCountVendor() throws ApplicationException
{
long count=0;
try{
VendorManager vendorManager=new VendorManager();
count=vendorManager.getCount();
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getCountVendor"+blException.getMessage());
}
return count;
}

public long getCountByCityVendor(int cityCode) throws ApplicationException
{
long count=0;
try{
VendorManager vendorManager=new VendorManager();
count=vendorManager.getCountByCity(cityCode);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getCountByCityVendor"+blException.getMessage());
}
return count;
}


//admin

//admin
public void addAdmin(AdminInterface adminInterface) throws ApplicationException
{
try{
AdminManager adminManager=new AdminManager();
adminManager.add(adminInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->addAdmin"+blException.getMessage());
}
}

public void updateAdmin(AdminInterface adminInterface) throws ApplicationException
{
try{
AdminManager adminManager=new AdminManager();
adminManager.update(adminInterface);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->updateAdmin"+blException.getMessage());
}
}

public void removeAdmin(int code) throws ApplicationException
{
try{
AdminManager adminManager=new AdminManager();
adminManager.remove(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->removeAdmin"+blException.getMessage());
}
}

public AdminInterface getAdminByCode(int code) throws ApplicationException
{
AdminInterface adminInterface;
try{
AdminManager adminManager=new AdminManager();
adminInterface=adminManager.getByCode(code);
return adminInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAdminByCode"+blException.getMessage());
}
}

public AdminInterface getAdminByUsername(String username) throws ApplicationException
{
AdminInterface adminInterface;
try{
AdminManager adminManager=new AdminManager();
adminInterface=adminManager.getByUsername(username);
return adminInterface;
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getAdminByUsername"+blException.getMessage());
}
}


public boolean adminExists(int code) throws ApplicationException
{
boolean exists=false;
try{
AdminManager adminManager=new AdminManager();
exists=adminManager.exists(code);
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->vendorOutletExists"+blException.getMessage());
}
return exists;
}

public long getCountAdmin() throws ApplicationException
{
long count=0;
try{
AdminManager adminManager=new AdminManager();
count=adminManager.getCount();
}
catch(BLException blException)
{
throw new ApplicationException("loyaltyApplication--->getCountAdmin"+blException.getMessage());
}
return count;
}

/*Operator*/

public void addOperator(OperatorBLInterface operatorInterface) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.add(operatorInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void updateOperator(OperatorBLInterface operatorInterface) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.update(operatorInterface);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public OperatorBLInterface getOperatorByCode(int code) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getByCode(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public OperatorBLInterface getOperatorByName(String name) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getByName(name);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public OperatorBLInterface getOperatorByUsername(String username) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getByUsername(username);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public ArrayList<OperatorBLInterface> getAllOperators() throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getAll();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}



public ArrayList<OperatorBLInterface> getAllOperatorsByVendorOutletCode(int vendorOutletCode) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getAllByVendorOutletCode(vendorOutletCode);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public long getOperatorCountByVendorOutletCode(int vendorOutletCode) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getCountByVendorOutletCode(vendorOutletCode);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public long getOperatorCount() throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getCount();
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public long getOperatorCountByName(String name) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getCountByName(name);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public long getOperatorCountByUsername(String username) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
return operatorManager.getCountByUsername(username);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void removeAllOperators() throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.removeAll();

}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void removeOperator(int code) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.remove(code);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public void removeOperatorsByVendorOutletCode(int vendorOutletCode) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.removeAllByVendorOutletCode(vendorOutletCode);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public void removeOperatorByUsername(String username) throws ApplicationException
{
try
{
OperatorManager operatorManager=new OperatorManager();
operatorManager.removeByUsername(username);
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}

public boolean operatorExists(int code) throws ApplicationException
{
try
{
boolean found;
OperatorManager operatorManager=new OperatorManager();
found=operatorManager.exists(code);

return found;
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}


public boolean operatorExistsByUsername(String username) throws ApplicationException
{
try
{
boolean found;
OperatorManager operatorManager=new OperatorManager();
found=operatorManager.existsByUsername(username);

return found;
}
catch(Exception exception)
{
throw new ApplicationException(exception.getMessage());
}
}
}
