INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES 
('jordan', 'harrison'),
('Tristan', 'Favard'),
('Austin', 'Robinson'),
('Terrell', 'Griffson'),
('Domminic ', 'Bush'),
('jordan', 'Peterson');

INSERT INTO `ims`.`items` (`name`, `value`) VALUES 
('Starfish', 1080.99),
('GoogleStonk', '89515.14'),
('Yogert', '50'),
('Drawer', '126.30'),
('Patches ', '20.99'),
('Virus', '1234567.89');

INSERT INTO `ims`.`orders` (`customer_id`) VALUES 
(5),
(4),
(3),
(1),
(2),
(6);

INSERT INTO `ims`.`orders_items` (`order_id`,`item_id`,`qty`) VALUES 
(5, 1,10),
(4,2,5),
(3,3,4),
(1,4,7),
(2,6,41),
(6,5,101);
