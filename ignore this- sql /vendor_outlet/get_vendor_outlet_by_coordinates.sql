DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_by_coordinates`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_by_coordinates` (in v_latitude char(30),in v_longitude char(30))
BEGIN
select code , latitude , longitude ,address,contact_number,city_code ,vendor_code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END$$

DELIMITER ;
