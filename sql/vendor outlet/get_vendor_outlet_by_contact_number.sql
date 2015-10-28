DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_contact_number`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_contact_number` (in v_contact_number char(20))
BEGIN
select code , latitude , longitude ,address,contact_number ,vendor_code from vendor_outlet_view where contact_number = v_contact_number ;
END$$

DELIMITER ;
