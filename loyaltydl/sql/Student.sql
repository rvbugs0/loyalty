DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_student_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`remove_student_by_customer_code` (in v_customer_code int)
BEGIN
delete from student where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_students_by_stream` $$
CREATE PROCEDURE `loyalty`.`get_all_students_by_stream` (in v_stream char(50))
BEGIN
select * from student_view where stream=v_stream;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_count_by_stream` $$
CREATE PROCEDURE `loyalty`.`get_student_count_by_stream` (in v_stream char(50),out v_count int)
BEGIN
declare student_count int;
select count(*) into student_count from student where stream=v_stream;
set v_count =student_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_all_students` $$
CREATE PROCEDURE `loyalty`.`get_all_students` ()
BEGIN
select * from student_view;
END $$

DELIMITER ;



﻿DROP VIEW IF EXISTS `loyalty`.`student_view`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_view` AS select `student`.`customer_code` AS `customer_code`,trim(`customer`.`name`) AS `name`,trim(`customer`.`username`) AS `username`,trim(`customer`.`password`) AS `password`,trim(`customer`.`password_key`) AS `password_key`,trim(`customer`.`permanent_address`) AS `permanent_address`,trim(`customer`.`current_address`) AS `current_address`,`customer`.`city_code` AS `city_code`,`customer`.`date_of_birth` AS `date_of_birth`,trim(`customer`.`gender`) AS `gender`,trim(`customer`.`occupation`) AS `occupation`,trim(`customer`.`contact_number`) AS `contact_number`,trim(`customer`.`mail_id`) AS `mail_id`,trim(`student`.`stream`) AS `stream`,trim(`student`.`course_details`) AS `course_details` from (`student` join `customer` on((`student`.`customer_code` = `customer`.`code`)));
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`update_student` $$
CREATE PROCEDURE `loyalty`.`update_student` (in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
update student set stream=v_stream,course_details=v_course_details where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`get_student_by_customer_code` (in v_customer_code int)
BEGIN
select * from student_view where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`get_student_count` $$
CREATE PROCEDURE `loyalty`.`get_student_count` (out v_student_count int)
BEGIN
declare student_count Int;
select count(*) into student_count from student;
set v_student_count=student_count;

END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`student_exists_by_customer_code` $$
CREATE PROCEDURE `loyalty`.`student_exists_by_customer_code` (in v_customer_code int)
BEGIN
select * from student where customer_code=v_customer_code;
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`add_student` $$
CREATE PROCEDURE `loyalty`.`add_student` (in v_customer_code int,in v_stream char(50),in v_course_details char(100))
BEGIN
insert into student (customer_code,stream,course_details) values (v_customer_code,v_stream,v_course_details);
END $$

DELIMITER ;
﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `loyalty`.`remove_all_students` $$
CREATE PROCEDURE `loyalty`.`remove_all_students` ()
BEGIN
truncate student;
END $$

DELIMITER ;
