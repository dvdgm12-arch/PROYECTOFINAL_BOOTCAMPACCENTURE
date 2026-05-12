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

- 4. RESERVAS (Mínimo 5)
-- Relacionamos IDs de huéspedes y habitaciones existentes
INSERT INTO `reservas` (`id_huesped`, `id_habitacion`, `fecha_entrada`, `fecha_salida`, `num_personas`, `metodo_pago`, `total_reserva`) VALUES 
(1, 1, '2026-05-10', '2026-05-12', 1, 'tarjeta', 90.00),
(2, 3, '2026-05-15', '2026-05-20', 2, 'efectivo', 377.50),
(3, 6, '2026-06-01', '2026-06-05', 2, 'transferencia', 480.00),
(4, 2, '2026-05-05', '2026-05-07', 1, 'tarjeta', 90.00),
(5, 7, '2026-05-20', '2026-05-22', 2, 'tarjeta', 240.00);



-- RESTAURACIÓN DE CONFIGURACIONES ORIGINALES
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;