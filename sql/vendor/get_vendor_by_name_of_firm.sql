DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_name_of_firm`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_name_of_firm` (in v_name char(50))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id , name_of_firm ,contact_number from vendor_view where name_of_firm = v_name ; 
END$$

DELIMITER ;
