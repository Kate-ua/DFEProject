DROP TABLE IF EXISTS `animals`;

CREATE TABLE `animals` (
	`id` BIGINT AUTO_INCREMENT,
	`type` VARCHAR(255) NOT NULL,
	`habitat` VARCHAR(255) NOY NUL,
	`age` INT UNIQUE NOT NULL,
	`numOfLegs` INT NOT NULL,
	PRIMARY KEY(`id`)
)	
	