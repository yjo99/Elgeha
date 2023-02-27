-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema marketplacedb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema marketplacedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema marketplacedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `marketplacedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `marketplacedb` ;

-- -----------------------------------------------------
-- Table `marketplacedb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`address` (
  `addressId` INT NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `buildNo` INT NULL DEFAULT NULL,
  `floorNo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`addressId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`category` (
  `categoryId` INT NOT NULL,
  `categoryName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`product` (
  `productId` INT NOT NULL,
  `productName` VARCHAR(255) NOT NULL,
  `productDescription` VARCHAR(510) NULL DEFAULT NULL,
  `productAmount` INT NOT NULL,
  `categoryId` INT NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `fk_Product_Category1_idx` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Category1`
    FOREIGN KEY (`categoryId`)
    REFERENCES `marketplacedb`.`category` (`categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`image` (
  `imageId` INT NOT NULL,
  `imageUrl` VARCHAR(510) NULL DEFAULT NULL,
  `imageDesc` VARCHAR(45) NULL DEFAULT NULL,
  `Product_idProduct` INT NOT NULL,
  PRIMARY KEY (`imageId`),
  INDEX `fk_Image_Product1_idx` (`Product_idProduct` ASC) VISIBLE,
  CONSTRAINT `fk_Image_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `marketplacedb`.`product` (`productId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`user` (
  `userId` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(11) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `creditCard` VARCHAR(255) NULL DEFAULT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_User_Address1_idx` (`addressId` ASC) VISIBLE,
  CONSTRAINT `fk_User_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `marketplacedb`.`address` (`addressId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`userorderproduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`userorderproduct` (
  `userId` INT NOT NULL,
  `productId` INT NOT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `productCount` INT NULL DEFAULT NULL,
  `orderDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `productId`),
  INDEX `fk_User_has_Product_Product1_idx` (`productId` ASC) VISIBLE,
  INDEX `fk_User_has_Product_User_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Product_Product1`
    FOREIGN KEY (`productId`)
    REFERENCES `marketplacedb`.`product` (`productId`),
  CONSTRAINT `fk_User_has_Product_User`
    FOREIGN KEY (`userId`)
    REFERENCES `marketplacedb`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `marketplacedb`.`userreviewproduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marketplacedb`.`userreviewproduct` (
  `userId` INT NOT NULL,
  `productId` INT NOT NULL,
  `noStars` INT NULL DEFAULT NULL,
  `comment` VARCHAR(510) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `productId`),
  INDEX `fk_User_has_Product_Product2_idx` (`productId` ASC) VISIBLE,
  INDEX `fk_User_has_Product_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Product_Product2`
    FOREIGN KEY (`productId`)
    REFERENCES `marketplacedb`.`product` (`productId`),
  CONSTRAINT `fk_User_has_Product_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `marketplacedb`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
