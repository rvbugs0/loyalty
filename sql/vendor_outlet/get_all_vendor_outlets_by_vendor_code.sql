DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets_by_vendor_code`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets_by_vendor_code` (in v_vendor_code int)
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where vendor_code = v_vendor_code ;	
END$$

DELIMITER ;
