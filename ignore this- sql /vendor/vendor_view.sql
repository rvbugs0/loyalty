create view vendor_view as 
select vendor.code as code  , trim(name_of_firm) as name_of_firm , trim(username) as username , trim(password) as password, trim(password_key) as password_key, city_code ,trim(address) as address, trim(contact_number) as contact_number,trim(mail_id) as mail_id, trim(city.name)  as city_name , trim(state) as state_name , trim(country) as country_name  from vendor inner join city on vendor.city_code = city.code;