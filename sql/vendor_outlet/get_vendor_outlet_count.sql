DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_outlet_count`$$
CREATE PROCEDURE `loyalty`.`get_vendor_outlet_count` (out v_count int)
BEGIN
DECLARE v_outlet_count int;
select count(*) into v_outlet_count from vendor_outlet_view ;
set  v_count = v_outlet_count ;
END$$

DELIMITER ;
