DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_code`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_code` (in v_code int)
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code from vendor_outlet_view where code = v_code ;
END$$

DELIMITER ;
