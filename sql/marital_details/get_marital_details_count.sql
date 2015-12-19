DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_marital_details_count` $$
CREATE PROCEDURE `loyalty`.`get_marital_details_count` (out v_marital_details_count int)
BEGIN
declare marital_details_count Int;
select count(*) into marital_details_count from marital_details;
set v_marital_details_count=marital_details_count;

END $$

DELIMITER ;