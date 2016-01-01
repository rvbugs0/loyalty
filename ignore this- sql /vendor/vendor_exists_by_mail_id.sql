DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_mail_id`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_mail_id` (in v_mail_id char(100))
BEGIN
select code from vendor_view where mail_id = v_mail_id;
END$$

DELIMITER ;
