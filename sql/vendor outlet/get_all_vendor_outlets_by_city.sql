DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_vendor_outlets_by_city`$$
CREATE PROCEDURE `loyalty`.`get_all_vendor_outlets_by_city` (in v_city_code int)
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code from vendor_outlet_view where city_code = v_city_code ;	
END$$

DELIMITER ;
