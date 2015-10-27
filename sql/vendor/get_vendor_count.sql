DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_vendor_count`$$
CREATE PROCEDURE `loyalty`.`get_vendor_count` (out v_vendor_count int)
BEGIN
DECLARE vendor_count Int;
select count(*) into vendor_count from vendor_view; 
set v_vendor_count = vendor_count;
END$$

DELIMITER ;
