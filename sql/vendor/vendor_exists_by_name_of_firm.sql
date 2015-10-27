DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_exists_by_name_of_firm`$$
CREATE PROCEDURE `loyalty`.`vendor_exists_by_name_of_firm` (in v_name char(50))
BEGIN
select code from vendor_view where name_of_firm = v_name;
END$$

DELIMITER ;
