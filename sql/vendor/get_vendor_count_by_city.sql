DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count_by_city`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count_by_city` (in v_city_code int,out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view where city_code = v_city_code ; 
set v_vendor_count = vendor_count;
END$$

DELIMITER ;
