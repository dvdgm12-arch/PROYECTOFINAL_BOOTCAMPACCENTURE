# ProyectoFinalEquipoB
	* FASE 0:
			- CREACION PROYECTO
			- CREACION Y CONFIGURACION POM.XML
			- CREACION Y CONFIGURACION DE DB.PROPERTIES 
			- CREACION Y CONFIGURACION DE .CFG.XML (ENTIDADES NOMBRES: USUARIO, INCIDENCIA, HUESPED, HABITACION, RESERVAS) - las clases.java se tendrán que llamar así.
			- CREACION Y CONFIGURACION DE SRC/MAIN/webapp/WEB-INF/views y página de inicio básica
			- CREACION DE CARPETA EN LA RAIZ SQL/ ficheros 01_setup.sql
			- CREACION DE ESTRUCTURA DE CARPETAS Y PAQUETES src/main/java/com.hotel.config, com.hotel.controller, com.hotel.crud (repositorios/.impl y servicios/.impl, com.hotel.entidades, 			com.hotel.excepciones y com.hotel.util
			
							!!! - CREACION DE EXCEPCIONES (en blanco y las tres más básicas) !!!
				
			-CREACION Y NOMENCLATURAS/VERBOS Y MÉTODOS/FUNCIONES:
			CAPAS: Controller -> Service -> Repository -> Entidades
			
				Verbos:
							!!! - listado ó lista... SELECT !!!
				- alta... INSERT
				- actualizar... UPDATE
				- eliminar... DELETE
				Idioma: Español (clases, variables y métodos)

				Nomenclatura:

				- Lectura/SELECT: obtener (Ej: obtenerHabitaciones, obtenerHuespedesByDni, obtenerTodas, obtenerTodos, obtenerHabitaciones)

				- Creación/INSERT: guardar (Ej: AltaReserva).

				- Edición/UPDATE: guardar (Ej: ActualizarIncidencia).

				- Borrado/DELETE: eliminar (Ej: EliminarUsuario).

				Convención de Vistas/URLs/CAPAS: 

				- LISTAGENERAL - > DETALLE -> FORMULARIO(MODIF, NUEVO, O BORRAR)
	
				- FORMULARIOGENERAL -> DETALLE -> FORMULARIO(MODIF, NUEVO O BORRAR)
			
			
			
			
			