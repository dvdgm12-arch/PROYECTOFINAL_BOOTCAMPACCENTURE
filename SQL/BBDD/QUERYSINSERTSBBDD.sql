USE `hoteldb`;

-- 1. USUARIOS (Mínimo 2: Recepcionista y Supervisor)
-- Nota: Las contraseñas se guardan en texto plano por ahora para facilitar las pruebas
INSERT INTO `usuarios` (`username`, `password`, `nombre_completo`, `perfil`, `ultimo_login`) VALUES 
('admin_ana', '$2a$10$ww/ozP1dtw0urUWZmRApz.BOUwXg3OV8ZGbmWC5ceBX1KsCS9N7Lu', 'Ana García López', 'supervisor', NOW()),
('recep_juan', '$2a$10$sDAfLD6kpAHdmwz4UNmk/uc..jFhp/t56E57YMHb733tEeavRPR3u', 'Juan Pérez Martínez', 'recepcionista', NOW());

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

-- 3. HUESPEDES (Mínimo 5)
INSERT INTO `huespedes` (`nombre`, `apellidos`, `dni_pasaporte`, `email`, `telefono`) VALUES 
('Carlos', 'Ruiz Zafón', '12345678A', 'carlos@email.com', '600111222'),
('Laura', 'Sánchez Poo', '87654321B', 'laura@email.com', '600333444'),
('Marta', 'Gómez Fer', '11223344C', 'marta@email.com', '600555666'),
('Roberto', 'Leal Cano', '44332211D', 'roberto@email.com', '600777888'),
('Elena', 'Júcar Vázquez', '55667788E', 'elena@email.com', '600999000');

-- 4. RESERVAS (Mínimo 5)
-- Relacionamos IDs de huéspedes y habitaciones existentes
INSERT INTO `reservas` (`id_huesped`, `id_habitacion`, `fecha_entrada`, `fecha_salida`, `num_personas`, `metodo_pago`, `total_reserva`) VALUES 
(1, 1, '2026-05-10', '2026-05-12', 1, 'tarjeta', 90.00),
(2, 3, '2026-05-15', '2026-05-20', 2, 'efectivo', 377.50),
(3, 6, '2026-06-01', '2026-06-05', 2, 'transferencia', 480.00),
(4, 2, '2026-05-05', '2026-05-07', 1, 'tarjeta', 90.00),
(5, 7, '2026-05-20', '2026-05-22', 2, 'tarjeta', 240.00);

-- 5. INCIDENCIAS (Mínimo 5 de distintos estados y prioridades)
INSERT INTO `incidencias` (`id_habitacion`, `descripcion`, `estado`, `prioridad`, `fecha_apertura`, `coste_reparacion`) VALUES 
(1, 'Grifo del baño gotea ligeramente', 'abierta', 'baja', NOW(), 0.00),
(3, 'Bombilla fundida en la entrada', 'cerrada', 'baja', '2026-04-28 10:00:00', 5.50),
(2, 'Aire acondicionado hace ruido excesivo', 'en curso', 'media', NOW(), 0.00),
(6, 'Televisión no sintoniza canales', 'abierta', 'baja', NOW(), 0.00),
(5, 'Cristal de ventana agrietado', 'en curso', 'alta', NOW(), 150.00);