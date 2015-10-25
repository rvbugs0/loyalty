/*  add city */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_city`$$
CREATE PROCEDURE `loyalty`.`add_city` (in v_name char(30),in v_state char(30),in v_country char(30),out code int)
BEGIN
INSERT INTO city (name,state,country) values (v_name,v_state,v_country);
set code = last_insert_id();
END$$

DELIMITER ;

/* update city  */


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_city`$$
CREATE PROCEDURE `loyalty`.`update_city` (in v_code int,in v_name char(30),in v_state char(30),in v_country char(30))
BEGIN
UPDATE city set name = v_name , state = v_state , country = v_country where code = v_code;
END$$

DELIMITER ;

/*  remove city */


DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_city`$$
CREATE PROCEDURE `loyalty`.`remove_city` (in v_code int)
BEGIN
delete from city where code = v_code;
END$$


DELIMITER ;

/* city exists by name  */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`city_exists_by_name`$$
CREATE PROCEDURE `loyalty`.`city_exists_by_name` (in v_name char(30))
BEGIN
select * from city where name = v_name;
END$$

DELIMITER ;

/*  get all cities */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_cities`$$
CREATE PROCEDURE `loyalty`.`get_all_cities` ()
BEGIN
select * from city ;
END$$

DELIMITER ;



/* get city by code  */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_by_code`$$
CREATE PROCEDURE `loyalty`.`get_city_by_code` (in v_code int)
BEGIN
select * from city where code = v_code ;
END$$

DELIMITER ;

/* remove all cities  */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_cities`$$
CREATE PROCEDURE `loyalty`.`remove_all_cities` ()
BEGIN
truncate city;
END$$

DELIMITER ;


/* get city count  */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count`$$
CREATE PROCEDURE `loyalty`.`get_city_count` (out v_city_count int)
BEGIN
DECLARE city_count Int;
select count(*) into city_count from city; 
set v_city_count = city_count;
END$$

DELIMITER ;

/* get city count  by name */

DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_city_count_by_name`$$
CREATE PROCEDURE `loyalty`.`get_city_count_by_name` (in v_name char(30),out v_count int)
BEGIN
DECLARE city_count int;
select count(*) into city_count from city where name= v_name;
set v_count=city_count; 
END$$

DELIMITER ;



/* city exists by code  */
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`city_exists_by_code`$$
CREATE PROCEDURE `loyalty`.`city_exists_by_code` (in v_code int)
BEGIN
select * from city where code = v_code;
END$$

DELIMITER ;


/* get cities by name  */
DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_cities_by_name`$$
CREATE PROCEDURE `loyalty`.`get_cities_by_name` (in v_name char(30))
BEGIN
select * from city where name=v_name;
END$$

DELIMITER ;

