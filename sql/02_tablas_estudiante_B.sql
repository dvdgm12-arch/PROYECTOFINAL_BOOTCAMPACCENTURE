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

-- 3. HUESPEDES (Mínimo 5)
INSERT INTO `huespedes` (`nombre`, `apellidos`, `dni_pasaporte`, `email`, `telefono`) VALUES
('Carlos', 'Ruiz Zafón', '12345678A', 'carlos@email.com', '600111222'),
('Laura', 'Sánchez Poo', '87654321B', 'laura@email.com', '600333444'),
('Marta', 'Gómez Fer', '11223344C', 'marta@email.com', '600555666'),
('Roberto', 'Leal Cano', '44332211D', 'roberto@email.com', '600777888'),
('Elena', 'Jucar Vázquez', '55667788E', 'elena@email.com', '600999000');

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

-- 1. USUARIOS (Cifrados con BCrypt)
INSERT INTO `usuarios` (`username`, `password`, `nombre_completo`, `perfil`, `ultimo_login`) VALUES 
('admin_ana', '$2a$10$hv7W7NN3i6ZqcJi0ouFCjuhgOi.OPA0HuuPo3O7tiuo1OXOAOKuF2', 'Ana García López', 'supervisor', NOW()),
('recep_juan', '$2a$10$lON3VpQcN7ISwQBBx.RHke0zjlAaHBvhZMwKFPpZkNO6x2M00wVJG', 'Juan Pérez Martínez', 'recepcionista', NOW());


-- RESTAURACIÓN DE CONFIGURACIONES ORIGINALES
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;