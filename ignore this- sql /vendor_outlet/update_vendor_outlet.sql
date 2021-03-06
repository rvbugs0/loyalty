DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_vendor_outlet`$$
CREATE PROCEDURE `loyalty`.`update_vendor_outlet` (in v_code int,in v_vendor_code int,in v_address Varchar(500),in v_latitude char(30),in v_longitude char(30),in v_city_code int,in v_contact_number char(20))
BEGIN
update vendor_outlet set latitude=v_latitude , longitude=v_longitude ,address = v_address ,contact_number= v_contact_number ,vendor_code = v_vendor_code where code =v_code;
END$$

DELIMITER ;

