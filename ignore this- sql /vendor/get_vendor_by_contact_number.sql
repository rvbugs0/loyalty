DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_contact_number` (in v_contact_number char(20))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , contact_number,name_of_firm from vendor_view  where contact_number = v_contact_number;
END$$

DELIMITER ;
