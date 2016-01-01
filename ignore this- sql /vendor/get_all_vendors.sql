DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendors`$$
CREATE PROCEDURE `loyalty`.`get_all_vendors` ()
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  ;
END$$

DELIMITER ;
