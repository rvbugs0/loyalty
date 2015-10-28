DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets` ()
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code from vendor_outlet_view  ;
END$$

DELIMITER ;
