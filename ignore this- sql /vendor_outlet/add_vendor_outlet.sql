DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`add_vendor_outlet` (in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20),out v_out_code int)
BEGIN
insert into vendor_outlet (vendor_code ,address,latitude,longitude,city_code ,contact_number) values (v_vendor_code , v_address,v_latitude,v_longitude,v_city_code ,v_contact_number);
set v_out_code = last_insert_id();
END$$

DELIMITER ;
