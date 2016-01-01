DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_username`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_username` (in v_username char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view where username = v_username ; 
END$$

DELIMITER ;
