CREATE SCHEMA `bookstore` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `bookstore`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` NVARCHAR(30) NOT NULL,
  `image` VARCHAR(2000) NULL,
  `address` NVARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
   CHECK (LENGTH(`password`) >= 8),
  `isRole` INT NOT NULL,
  `active` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE `bookstore`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idCategory` INT NULL,
  `name` NVARCHAR(200) NOT NULL,
  `image` VARCHAR(2000) NULL,
  `Productcol` VARCHAR(45) NULL,
  `originalPrice` INT NOT NULL,
  `salePrice` INT NOT NULL,
  `discription` NVARCHAR(2000) NULL,
  `quantity` INT NOT NULL,
  `active` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `bookstore`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` NVARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `bookstore`.`cartitem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idProduct` INT NOT NULL,
  `quantity` INT NOT NULL,
  `price` INT NOT NULL,
    PRIMARY KEY(`id`)
  -- PRIMARY KEY (`idUser`, `idProduct`)
  );

CREATE TABLE `bookstore`.`delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` NVARCHAR(100) NOT NULL,
  `shipFee` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bookstore`.`paymethod` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` NVARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `bookstore`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idSeller` INT NOT NULL,
  `createTime` DATE NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `address` NVARCHAR(100) NOT NULL,
  `contactName` NVARCHAR(50) NOT NULL,
  `receiveDate` DATE NOT NULL,
  `idMethod` INT NOT NULL,
  `idDelivery` INT NOT NULL,
  `totalPay` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bookstore`.`orderitem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idOrder` INT NOT NULL,
  `idProduct` INT NOT NULL,
  `quantity` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY(`id`)
--   PRIMARY KEY (`idOrder`, `idProduct`)
  );

-- Thêm Khóa ngoại cho bảng Order
ALTER TABLE `bookstore`.`order` 
ADD INDEX `fk_OrderDelivery_idx` (`idDelivery` ASC) VISIBLE,
ADD INDEX `fk_OrderMethod_idx` (`idMethod` ASC) VISIBLE,
ADD INDEX `fk_OrderUser_idx` (`idUser` ASC) VISIBLE;
;
ALTER TABLE `bookstore`.`order` 
ADD CONSTRAINT `fk_OrderDelivery`
  FOREIGN KEY (`idDelivery`)
  REFERENCES `bookstore`.`delivery` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_OrderMethod`
  FOREIGN KEY (`idMethod`)
  REFERENCES `bookstore`.`paymethod` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_OrderUser`
  FOREIGN KEY (`idUser`)
  REFERENCES `bookstore`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
-- Thêm Khóa ngoại cho bảng OrderItem
ALTER TABLE `bookstore`.`orderitem` 
ADD INDEX `fk_OrderItem-Product_idx` (`idProduct` ASC) VISIBLE;
;
ALTER TABLE `bookstore`.`orderitem` 
ADD CONSTRAINT `fk_OrderItem-Order`
  FOREIGN KEY (`idOrder`)
  REFERENCES `bookstore`.`order` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_OrderItem-Product`
  FOREIGN KEY (`idProduct`)
  REFERENCES `bookstore`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Thêm Khóa ngoại cho bảng Product
ALTER TABLE `bookstore`.`product` 
ADD INDEX `idCategory_idx` (`idCategory` ASC) VISIBLE;
;
ALTER TABLE `bookstore`.`product` 
ADD CONSTRAINT `idCategory`
  FOREIGN KEY (`idCategory`)
  REFERENCES `bookstore`.`category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- Thêm Khóa ngoại cho bảng CartItem
ALTER TABLE `bookstore`.`cartitem` 
ADD INDEX `fk_CartItem-Product_idx` (`idProduct` ASC) VISIBLE;
;
ALTER TABLE `bookstore`.`cartitem` 
ADD CONSTRAINT `fk_CartItem-User`
  FOREIGN KEY (`idUser`)
  REFERENCES `bookstore`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_CartItem-Product`
  FOREIGN KEY (`idProduct`)
  REFERENCES `bookstore`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `bookstore`.`product` 
DROP COLUMN `Productcol`;

ALTER TABLE `bookstore`.`product` 
DROP FOREIGN KEY `idCategory`;
ALTER TABLE `bookstore`.`product` 
ADD CONSTRAINT `idCategory`
  FOREIGN KEY (`idCategory`)
  REFERENCES `bookstore`.`category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `bookstore`.`product` 
DROP FOREIGN KEY `idCategory`;
ALTER TABLE `bookstore`.`product` 
CHANGE COLUMN `idCategory` `idCategory` INT NOT NULL ;
ALTER TABLE `bookstore`.`product` 
ADD CONSTRAINT `idCategory`
  FOREIGN KEY (`idCategory`)
  REFERENCES `bookstore`.`category` (`id`);
  
ALTER TABLE `bookstore`.`product` 
CHANGE COLUMN `active` `active` BIT(1) NOT NULL DEFAULT b'1' ;

ALTER TABLE `bookstore`.`user` 
CHANGE COLUMN `active` `active` BIT(1) NOT NULL DEFAULT b'1' ;

ALTER TABLE bookstore.`order` 
CHANGE COLUMN idSeller
idSeller INT NULL ,
CHANGE COLUMN createTime
createTime DATE NULL ,
CHANGE COLUMN receiveDate
receiveDate DATE NULL ,
CHANGE COLUMN status
status INT NOT NULL DEFAULT 1 ;

