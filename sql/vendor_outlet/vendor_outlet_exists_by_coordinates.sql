DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`vendor_outlet_exists_by_coordinates`$$
CREATE PROCEDURE `loyalty`.`vendor_outlet_exists_by_coordinates` (in v_latitude char(30),in v_longitude char(30))
BEGIN
select code from vendor_outlet_view where latitude = v_latitude and longitude = v_longitude ;
END$$

DELIMITER ;
