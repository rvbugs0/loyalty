DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_code`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_code` (in v_code int)
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where code = v_code ; 
END$$

DELIMITER ;
