DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_contact_number` (in v_contact_number char(20))
BEGIN
select code from vendor_view where contact_number = v_contact_number;
END$$

DELIMITER ;
