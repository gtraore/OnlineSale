create database if not exists onlinesale;

use onlinesale;

drop table if exists orderMapping;

drop table if exists cart;

drop table if exists product;

drop table if exists category;

drop table if exists manufacturer;

create table cart(
id int primary key auto_increment,
totalAmount decimal(8,2),
dateCreated datetime,
lastUpdate datetime
);

create table category(
id int primary key auto_increment,
name varchar(50)
);

create table manufacturer(
id int primary key auto_increment,
name varchar(50)
);

create table product(
id int primary key auto_increment,
name varchar(100),
category_id int not null,
manufacturer_id int not null,
price decimal(7,2),
imgurl varchar(100),
description	text,
foreign key (category_id) references category(id),
foreign key (manufacturer_id) references manufacturer(id)
);

create table orderMapping(
cart_id int not null,
product_id int not null,
quantity int not null,
foreign key (cart_id) references cart(id),
foreign key (product_id) references product(id)
);

INSERT INTO `onlinesale`.`category`(`name`)
VALUES ('Ordinateurs');
INSERT INTO `onlinesale`.`category`(`name`)
VALUES ('Tablettes');
INSERT INTO `onlinesale`.`category`(`name`)
VALUES ('Téléphones');

INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Acer');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Apple');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('BlackBerry');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Dell');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('HP');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Lenovo');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Motorola');
INSERT INTO `onlinesale`.`manufacturer`(`name`)
VALUES ('Samsung');

INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Lenovo - PC de table M58 remis à neuf', 1, 6, 'Intel Core 2 Duo E8400 3GHz, RAM 8Go, DD 1To, Windows 10 Familial Pro 64 bits', 209.00, 'img/Ord_Lenovo.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('HP - PC de table Pro SFF 6200 remis à neuf', 1, 5, 'Intel Core i5 2400, 3,1 GHz, RAM 16 Go, DD 2 To, Windows 7 Pro', 379.00, 'img/Ord_HP.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Dell - PC de table Optiplex 980 remis à neuf', 1, 4, 'Intel Core i5 650 , 3,2 GHz, RAM 8 Go, DD 1 To, Windows 7 Pro', 319.26, 'img/Ord_Dell.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('HP - Portatif 15-BA057CA', 1, 5, '15,6 po, écran tactile HD WLED, AMD A10-9600P, DD 1 To, 8 Go DDR4, Windows 10, argent, W7C01UA#ABL', 699.92, 'img/Por_HP.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Apple – Portatif Macbook Air (MMGF2LL/A)', 1, 2, '13,3 po, processeur bicœur Intel Core i5 de 1,6 GHz, RAM 8 Go, SSD 128 Go, anglais', 1124.00, 'img/Por_Apple.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Acer – Portable (STQ415-ES1-531-P9QU)', 1, 1, '15,6 po, Intel Pentium N3700 de 1,60 GHz, 8 Go de RAM, HDD de 1 To, Windows 10, bilingue', 499.92, 'img/Por_Acer.jpg');

INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Samsung - Galaxy Tab A SM-T350NZAAXAC', 2, 8, '8 po, 1,2 GHz quadricoeur Android Lollipop, RAM 1,5 Go, 16 Go, gris titane', 219.96, 'img/Tab_Samsung.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Acer - Tablette Iconia B1 (NT.LBKAA.001)', 2, 1, '7 po, quadricoeur, RAM 1 Go, capacité 16 Go, Android 5.0, anglais', 119.96, 'img/Tab_Acer.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Apple - iPad Air 2', 2, 2, '9,7 po, puce A8X, Wi-Fi, gris cosmique', 479.97, 'img/Tab_Apple.jpg');

INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Samsung - Galaxy Grand Prime', 3, 8, 'écran qHD 8 Go, 5 po, 1,2 GHz, quadricœur, caméra avant 5 MP, Android Lollipop 5.1, déverrouillé', 173.97, 'img/Tel_Samsung.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('Motorola - Téléphone intelligent 2e génération Moto E (00690NACRTL)', 3, 7, '8 Go, déverrouillé, noir', 179.65, 'img/Tel_Motorola.jpg');
INSERT INTO `onlinesale`.`product`(`name`, `category_id`, `manufacturer_id`, `description`, `price`, `imgurl`)
VALUES ('BlackBerry - Téléphone intelligent déverrouillé DTEK50', 3, 3, '5,2 po Secure Android, noir (PRD-62980-002)', 429.43, 'img/Tel_BlackBerry.jpg');
