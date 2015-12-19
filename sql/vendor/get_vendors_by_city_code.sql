DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendors_by_city_code`$$
CREATE PROCEDURE `loyalty`.`get_vendors_by_city_code` (in v_city_code int)
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view where city_code = v_city_code ;
END$$

DELIMITER ;
