/* 
ORDEN DE EJECUCIÓN RECOMENDADO:
1. 01_setup.sql
2. 02_tablas_estudiante_B.sql (usuarios y huespedes)
3. 03_tablas_estudiante_A.sql (habitaciones e incidencias)
4. 04_tabla_reservas.sql (Integración)
5. 05_datos_prueba.sql
*/

 

-- CONFIGURACIONES DE SEGURIDAD PARA EVITAR ERRORES DURANTE LA CREACION:
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------
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

-- 2. HABITACIONES (Mínimo 8 de distintos tipos)
INSERT INTO `habitaciones` (`numero_habitacion`, `tipo`, `precio_noche`, `estado`, `planta`) VALUES 
(101, 'individual', 45.00, 'disponible', 1),
(102, 'individual', 45.00, 'disponible', 1),
(201, 'doble', 75.50, 'disponible', 2),
(202, 'doble', 75.50, 'ocupada', 2),
(203, 'doble', 75.50, 'limpieza', 2),
(301, 'suite', 120.00, 'disponible', 3),
(302, 'suite', 120.00, 'ocupada', 3),
(303, 'suite', 150.00, 'disponible', 3);



-- RESTAURACIÓN DE CONFIGURACIONES ORIGINALES
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;