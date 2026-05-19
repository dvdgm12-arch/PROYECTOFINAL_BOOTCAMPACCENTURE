-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hoteldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `hoteldb` ;

-- -----------------------------------------------------
-- Table `hoteldb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`usuarios` (
  `id_usuarios` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NULL,
  `password` VARCHAR(255) CHARACTER SET 'ascii' NULL,
  `nombre_completo` VARCHAR(45) NULL,
  `perfil` ENUM('recepcionista', 'supervisor') NULL,
  `ultimo_login` DATETIME NULL,
  PRIMARY KEY (`id_usuarios`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`habitaciones` (
  `id_habitacion` INT NOT NULL AUTO_INCREMENT,
  `numero_habitacion` INT NULL,
  `tipo` ENUM('individual', 'doble', 'suite') NULL,
  `precio_noche` DECIMAL(10,2) NULL,
  `estado` ENUM('disponible', 'ocupada', 'limpieza') NULL,
  `planta` INT NULL,
  PRIMARY KEY (`id_habitacion`),
  UNIQUE INDEX `numero_habitacion_UNIQUE` (`numero_habitacion` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`huespedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`huespedes` (
  `id_huesped` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NULL,
  `apellidos` VARCHAR(20) NULL,
  `dni_pasaporte` VARCHAR(10) NULL,
  `email` VARCHAR(60) NULL,
  `telefono` VARCHAR(20) NULL,
  PRIMARY KEY (`id_huesped`),
  UNIQUE INDEX `dni_pasaporte_UNIQUE` (`dni_pasaporte` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `id_huesped` INT NOT NULL,
  `id_habitacion` INT NOT NULL,
  `fecha_entrada` DATE NULL,
  `fecha_salida` DATE NULL,
  `num_personas` INT NULL,
  `metodo_pago` VARCHAR(45) NULL,
  `total_reserva` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id_reserva`),
  INDEX `fk_reservas_huespedes1_idx` (`id_huesped` ASC) VISIBLE,
  INDEX `fk_reservas_habitaciones1_idx` (`id_habitacion` ASC) VISIBLE,
  CONSTRAINT `fk_reservas_huespedes1`
    FOREIGN KEY (`id_huesped`)
    REFERENCES `hoteldb`.`huespedes` (`id_huesped`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_habitaciones1`
    FOREIGN KEY (`id_habitacion`)
    REFERENCES `hoteldb`.`habitaciones` (`id_habitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`incidencias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`incidencias` (
  `id_incidencia` INT NOT NULL AUTO_INCREMENT,
  `id_habitacion` INT NOT NULL,
  `descripcion` TEXT NULL,
  `estado` ENUM('abierta', 'en curso', 'cerrada') NULL,
  `prioridad` ENUM('baja', 'media', 'alta') NULL,
  `fecha_apertura` DATETIME NULL,
  `fecha_cierre` DATETIME NULL,
  `coste_reparacion` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id_incidencia`),
  INDEX `fk_incidencias_habitaciones_idx` (`id_habitacion` ASC) VISIBLE,
  CONSTRAINT `fk_incidencias_habitaciones`
    FOREIGN KEY (`id_habitacion`)
    REFERENCES `hoteldb`.`habitaciones` (`id_habitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
