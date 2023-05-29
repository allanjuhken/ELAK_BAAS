--  DELIMITER //

-- CREATE TRIGGER `ready_before_insert` BEFORE INSERT ON `jumper`
-- FOR EACH ROW
-- BEGIN
--   SET NEW.vvh = DATE_ADD(NEW.vvh, INTERVAL 3 MONTH);
--  END//


-- CREATE TRIGGER `ready_before_update` BEFORE UPDATE ON `jumper`
-- FOR EACH ROW
-- BEGIN
--   SET NEW.vvh = DATE_ADD(NEW.vvh, INTERVAL 3 MONTH);
-- END//

-- DELIMITER ;


-- DELIMITER //

-- CREATE TRIGGER `ready_before_insert_1` BEFORE INSERT ON `jumper`
-- FOR EACH ROW
-- BEGIN
--   SET NEW.health_declaration = DATE_ADD(NEW.health_declaration, INTERVAL 6 MONTH);
-- END//

-- CREATE TRIGGER `ready_before_update_1` BEFORE UPDATE ON `jumper`
-- FOR EACH ROW
-- BEGIN
--   SET NEW.health_declaration = DATE_ADD(NEW.health_declaration, INTERVAL 6 MONTH);
-- END//

-- DELIMITER ;

CREATE TABLE `aircraft` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plane_id` varchar(10) NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aircraft_idx` (`plane_id`),
  KEY `index3` (`capacity`)
) ;

CREATE TABLE `jumper` (
  `personal_code` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_nr` varchar(45) NOT NULL,
  `licence` varchar(10) NOT NULL,
  `account_balance` int NOT NULL,
  `vvh` date NOT NULL,
  `health_declaration` date NOT NULL,
  `total_jumps` int NOT NULL,
  PRIMARY KEY (`personal_code`),
  KEY `total_jumpsx` (`total_jumps`)
) ;

CREATE TABLE `jumper_jumps` (
  `jumper_id` varchar(10) NOT NULL,
  `jump_nr` int NOT NULL,
  `jump_date` date NOT NULL,
  `aircraft` varchar(10) NOT NULL,
  KEY `jumper_id_idx` (`jumper_id`),
  KEY `jump_date_idx` (`jump_date`),
  KEY `jump_nrx` (`jump_nr`),
  KEY `plane_idx` (`aircraft`),
  CONSTRAINT `aircrft` FOREIGN KEY (`aircraft`) REFERENCES `manifest` (`aircraft_id`),
  CONSTRAINT `jump_date` FOREIGN KEY (`jump_date`) REFERENCES `manifest` (`load_date`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `jumper_id` FOREIGN KEY (`jumper_id`) REFERENCES `manifest` (`jumper_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `manifest` (
  `load_nr` int NOT NULL,
  `load_date` date NOT NULL,
  `jumper_id` varchar(10) NOT NULL,
  `aircraft_id` varchar(10) NOT NULL,
  `load_master` varchar(10) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `load_datex` (`load_date`),
  KEY `load_nrx` (`load_nr`),
  KEY `jumperid_idx` (`jumper_id`),
  KEY `plane_idx` (`aircraft_id`),
  CONSTRAINT `jumperid` FOREIGN KEY (`jumper_id`) REFERENCES `jumper` (`personal_code`),
  CONSTRAINT `plane` FOREIGN KEY (`aircraft_id`) REFERENCES `aircraft` (`plane_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;


























