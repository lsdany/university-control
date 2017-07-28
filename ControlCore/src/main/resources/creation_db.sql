/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  luisdany
 * Created: Jul 27, 2017
 */



-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema UNIVERSITY
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema UNIVERSITY
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `UNIVERSITY` ;
USE `UNIVERSITY` ;

-- -----------------------------------------------------
-- Table `UNIVERSITY`.`CLASS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`CLASS` (
  `IDCLASS` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `SECTION` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`IDCLASS`, `SECTION`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNIVERSITY`.`STUDENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`STUDENT` (
  `IDSTUDENT` INT NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  `CODE` VARCHAR(25) NOT NULL,
  `EMAIL` VARCHAR(100) NULL,
  `IDCLASS` INT NOT NULL,
  `SECTION` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`IDSTUDENT`),
  INDEX `fk_STUDENT_1_idx` (`IDCLASS` ASC),
  CONSTRAINT `fk_STUDENT_1`
    FOREIGN KEY (`IDCLASS`)
    REFERENCES `UNIVERSITY`.`CLASS` (`IDCLASS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `UNIVERSITY`.`NOTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`NOTE` (
  `IDNOTE` INT NOT NULL,
  `PARTIAL1` DOUBLE NULL,
  `PARTIAL2` DOUBLE NULL,
  `IDSTUDENT` INT NOT NULL,
  PRIMARY KEY (`IDNOTE`),
  INDEX `fk_NOTE_1_idx` (`IDSTUDENT` ASC),
  CONSTRAINT `fk_NOTE_1`
    FOREIGN KEY (`IDSTUDENT`)
    REFERENCES `UNIVERSITY`.`STUDENT` (`IDSTUDENT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UNIVERSITY`.`ACTIVITY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`ACTIVITY` (
  `IDACTIVITY` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `DESCRIPTION` VARCHAR(150) NULL,
  `VALUE` DOUBLE NULL,
  `IDNOTE` INT NOT NULL,
  PRIMARY KEY (`IDACTIVITY`),
  INDEX `fk_ACTIVITY_1_idx` (`IDNOTE` ASC),
  CONSTRAINT `fk_ACTIVITY_1`
    FOREIGN KEY (`IDNOTE`)
    REFERENCES `UNIVERSITY`.`NOTE` (`IDNOTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
