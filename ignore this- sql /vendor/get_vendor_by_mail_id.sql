DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`get_vendor_by_mail_id` (in v_mail_id char(100))
BEGIN
select code, username , city_code ,password,password_key,address , mail_id ,name_of_firm ,contact_number from vendor_view where mail_id = v_mail_id ; 
END$$

DELIMITER ;
