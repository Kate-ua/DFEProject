DROP TABLE IF EXISTS `animals`;

CREATE TABLE `animals` (
	`id` BIGINT AUTO_INCREMENT,
	`type` VARCHAR(255) NOT NULL,
	`age` INT UNIQUE NOT NULL,
	`habitat` VARCHAR(255) NOT NULL,
	`num_of_legs` INT NOT NULL,
	PRIMARY KEY(`id`)
);	
	