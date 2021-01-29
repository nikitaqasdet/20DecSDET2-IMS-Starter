USE `ims`;

CREATE TABLE IF NOT EXISTS customers (
    `cust_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`cust_id`)
);

CREATE TABLE IF NOT EXISTS items (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS orders (
    `ord_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_cust_id` INT NOT NULL,
    PRIMARY KEY (`ord_id`),
    FOREIGN KEY (`fk_cust_id`) REFERENCES customers(`cust_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orderline (
	`fk_ord_id` INT(11) NOT NULL,
    `fk_item_id` INT(11) NOT NULL,
    FOREIGN KEY (`fk_ord_id`) REFERENCES `orders`(`ord_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`fk_item_id`) REFERENCES `items`(`item_id`) ON UPDATE CASCADE ON DELETE CASCADE
);