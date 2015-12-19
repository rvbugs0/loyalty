DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_count_by_city`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_count_by_city` (in v_city_code int ,out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view where city_code = v_city_code;
set  v_count = v_outlet_count ;
END$$

DELIMITER ;
