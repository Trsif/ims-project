drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    `value` double default 0,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` int not null,
    `order_date` datetime not null default CURRENT_TIMESTAMP,
    FOREIGN KEY(`customer_id`) REFERENCES `customers`(`id`),
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `orders_items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` int not null,
    `item_id`int not null,
    `qty` int not null DEFAULT 1,
    FOREIGN KEY(`order_id`) REFERENCES `orders`(`id`),
	FOREIGN KEY(`item_id`) REFERENCES `items`(`id`),
    PRIMARY KEY (`id`)
);
