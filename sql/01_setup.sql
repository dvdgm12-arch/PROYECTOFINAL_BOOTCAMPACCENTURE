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
CREATE SCHEMA IF NOT EXISTS `hoteldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `hoteldb` ;



-- RESTAURACIÓN DE CONFIGURACIONES ORIGINALES
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;