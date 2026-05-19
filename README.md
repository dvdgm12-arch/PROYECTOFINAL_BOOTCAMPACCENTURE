• DESCRIPCIÓN DEL PROYECTO:
	Os presentamos GRAND RESORT BARATIÉ.
	El proyecto es una aplicación designada a la gestión de un complejo hotelero; especialmente diseñada para los empleados del recinto. Se pone a disposición 	las herramientas básicas de tratamiento, recepción de huéspedes, habitaciones, reservas e incidencias bajo un sistema de conexión por usuarios y por 	perfil 	concreto.
	La app se ha diseñado bajo el marco operativo de SPRING y más en concreto HIBERNATE, soportado por una estructura general de proyecto MAVEN.




• REQUISITOS PREVIOS:
	- VERSIÓN DE JAVA: JDK 11.0.26
	- VERSIÓN DE ECLIPSE IDE: Version 2022-03 (4.23.0) Build id: 20220310-1457
	- PROYECT BUILD PATH: JRE SYSTEM LIBRARY [JSE-11]
	- VERSIÓN DEMYSQL WORKBENCH: 8.0.42
	- ARQUITECTURA APP: MAVEN PROJECT org.apache.maven.archetypes-quickstart 1.5
	- SERVIDOR TOMCAT: v9.0 Server
	- VERSIÓN DE SONARQUBE: SonarQube 8.9.10 LTA
	
	


• INSTALACIÓN Y DESPLIEGUE:
	- PASO 1: git clone en la carpeta destino que elijas - recomendamos que escojas el workspace general en el que trabajes con ECLIPSE.
	- PASO 2: Crear la BBDD en MYSQL WORKBENCH utilizando el SCRIPT de ejecución de la BBDD que se adjunta en el repositorio. Posteriormente, utilizar el SCRIPT 	de QUERYS que también se adjunta para insertar el contenido dentro de la BBDD. Dentro de ECLIPSE no es necesario realizar nada, puesto el repositorio se 	descarga completo con los archivos de ejecución separados. Igualmente adjuntamos todos los archivos y enumerados en su orden de ejecución por si se desea 	ejecutar manualmente.
	- PASO 3: Dentro de ECLIPSE selecciona en las ventanas superiores File -> Open Projects from File System y selecciona la carpeta donde se te ha clonado el 	repositorio.
	- PASO 4: Asociar tu servidor Tomcat al proyecto para poder desplegar la aplicación.
	- PASO 5: ¡Disfruta de tu propia app de gestión hotelera! Hemos incluido un archivo .SQL adicional - el 5, para que puedas insertar nuevos campos de prueba 	a tu BBDD y exprimas todo el potencial en tu nuevo proyecto. ¡Desde el Grand Resort Baratié esperamos que lo pases bien investigando las funcionalidades a 	disposición integradas!




• TECNOLOGÍAS UTILIZADAS: listar las tecnologías y librerías principales (Spring MVC, Hibernate, MySQL, JSTL, Log4j, BCrypt… las que hayáis usado).
	El proyecto de Eclipse funciona principalmente bajo el amparo de SPRING HIBERNATE+JSTL+FORM MVC TAGS siguiendo la arquitectura de MAVEN. A continuación 	detallamos todas las librerías y tecnologías necesarias para el correcto funcionamiento de la aplicación:
	* Librería Web y MVC para controladores y JSP
	* Librería Spring ORM + Hibernate
	* Librería Driver MYSQL
	* Librería JSTL y API de Servlets
	* Librería JSP API
	* Librería BCRYPT
	* Librería LOG4J
	* Tecnología Maven Compiler Plugin
	* Tecnología Maven WAR Plugin




• ESTRUCTURA DEL PROYECTO:
	- POM.XML: Raíz del proyecto /root - necesario para importación de librerías y plugins
	- VISTAS JSP: src/main/webapp/WEB-INF/views sustiyendo a los archivos .JAR
	- HIBERNATE.CFG.XML: src/main/resources. Este archivo es el sustituto del driver jdbc. Actúa de nexo con el db.properties y como puente intermedio de 	HibernateConfig.java, uniendo dichas configuraciones y dependencias. También es el encargado de mapear las entidades .java desarrolladas.
	Dentro de src/main/resources también coexisten los archivos db.properties y log4j.properties para el correcto enlace con BBDD y con su librería 	correspondiente, respectivamente.
	- CARPETA SQL: Raíz del proyecto / root - incluye los script de ejecución ordenados por orden de ejecución
	El proyecto sigue una arquitectura limpia en capas, organizada bajo el paquete raíz `com.hotel`
	- SRC/MAIN/JAVA: Aquí tenemos definidos sus paquetes y estructuras determinadas por capas para su correcta separación y definición:
		- src/main/java/com.hotel.config: AppConfig.java como sustituto a ApplicationContext.xml - escaneo de componentes, controladores e interceptores, CRUD y 		vistas .JSP
		- src/main/java/com.hotel.config: GlobalSecurityConfig - paquete destino funcionalidad extra interceptor
		- src/main/java/com.hotel.config: AppInitializer.java como sustituto de Web.xml - funcionamiento de BBDD y WEB con Servlets
		- src/main/java/com.hotel.config: HibernateConfig.java - incorporación de librerías de HIBERNATE y funcionamiento de SessionFactory y Transactional
		- src/main/java/com.hotel.controladores: Paquete destino de los diversos controladores
		- src/main/java/com.hotel.entidades: Paquete destino de las diversas entidades
		- src/main/java/com.hotel.excepciones: Paquete destino de las distintas excepciones personalizadas y del subpaquete .handler donde actúa el controlador 		universal de las excepciones personalizadas
		- src/main/java/com.hotel.interceptores: Paquete destino funcionalidad extra interceptor
		-src/main/java/com.hotel.repositorios: Paquete destino a herramientas CRUD correspondientes a DAO (acceso a BBDD) con sus interfaces y el subpaquete 		.impl que aloja y define la lógica necesario
		src/main/java/com.hotel.servicios: Paquete destino a herramientas CRUD correspondientes a servicios (modificación de BBDD) con sus interfaces y el 		subpaquete .impl que prepara y conecta los controladores
		- src/main/java/com.hotel.util: Paquete destino a las funcionalides extra de BCRYP y generación de Hashs para la BBDD
		



• REPARTO DE TAREAS: 
	- CONJUNTO: Estructura de proyecto y orden de paquetes, archivos de configuración iniciales, creación base de datos y página de reservas.
	- SEPARADO:
		- Lidia Sandá López: Implementación y ejecución SCRIPTS usuarios y huéspedes y los archivos.java necesarios - entidades, controladores, CRUD; y las 		vistas.JSPs
		- David García Moreno: Implementación y ejecución SCRIPTS habitaciones e incidencias y los archivos.java necesarios - entidades, controladores, CRUD; y 		las vistas.JSPs




• CONFLICTOS DE MERGE: qué conflictos encontrasteis al integrar las ramas y cómo los resolvisteis.
	Siguiendo las instrucciones y pautas requeridas, cada incorporación se ha visto ejecutada mediante sus respectivos PULL REQUEST. En la FASE 1, en la 	integración de las ramas individuales de cada uno, hemos tenido que resolver los conflictos archivo por archivo - y utilizando las herramientas incorporadas 	tanto en github.com, en eclipse y en una ocasión con visual studio code respetando las adiciones del compañero y fusionando métodos en varios archivos 	cuando ha sido necesario.
	En la fase final de implementación de reservas mantuvimos los métodos de cada uno resolviendo los conflictos también archivo por archivo y finalizando el 	pull request con las adiciones de cada uno trabajadas en los mismos archivos compartidos en común.




• FUNCIONALIDES EXTRA:
	Gracias a la limpia arquitectura y la fuerte estructura empleada en el código, hemos podido incorporar las 5 funcionalidas extra sin mayor modificación al 	proyecto. En git detallamos punto por punto las modificaciones realizadas en cada -commit de cada extra llevado a cabo.
	- EXTRA INTERCEPTOR: Creación de archivo.java AutenticacionInterceptor y correspondiente mapeo en AppConfig.java para añadir las nuevas funcionalidades.
	- EXTRA LOG4J: Importación de librería, creación de log4j.properties para configurar tanto consola como su archivo de .logs. Como ya eliminamos todos los 	system.out.print del proyecto a la hora de comprobar el correcto funcionamiento de cada fase, no hemos tenido que modificar prácticamente nada de código; 	siendo el único logger el incluido en el método de generación de hash de la siguiente funcionalidad.
	- EXTRA BCRYPT: Importación de librería, archivos .java GeneradorTemporal y Encriptador con sus métodos estáticos para añadir en DAO y CRUD - repositorio y 	servicio de Usuario.
	- EXTRA BÚSQUEDA: Modificación de las vistas.JSP de listado - usuarios, reservas, habitaciones e incidencias. Modificación de controladores y de DAO y CRUD 	con las nuevas funcionalidades y métodos requeridos.
	- EXTRA SONAR: Descarga del programa. Runneo de TEST de SonarQube. Depuraciones de código en etiquetas JTSL en las vistas .jsp, método de serializable en 	entidad.java. El total de brechas de seguridad fue de 4 - se revisó el código y se aprobó. El total de bugs de accesibilidad con etiqueta minor fue de 76, 	las cuales son las mencionadas de etiquetas JTSL en las vistas.jsp




• CREDENCIALES DE PRUEBA:
	Para el correcto funcionamiento de la app el usuario de MYSQL WORKBENCH ha de ser 'root' y su contraseña '123abc' - detallado en db.properties y en 	hibernate.cfg.xml
	Para el testeo de roles: 
		- El usuario de supervisor es 'admin_ana' y su contraseña '1234abcd'
		- El usuario de recepcionista es 'recep_juan' y su contraseña 'juan2026'		