# Grand Resort Baratié 🏨

¡Te damos la bienvenida al repositorio de **Grand Resort Baratié**, una solución integral para la gestión y administración interna de complejos hoteleros!

---

## 📝 Descripción del Proyecto

Os presentamos GRAND RESORT BARATIÉ.
El proyecto es una aplicación designada a la gestión de un complejo hotelero; especialmente diseñada para los empleados del recinto. Se pone a disposición las herramientas básicas de tratamiento, recepción de huéspedes, habitaciones, reservas e incidencias bajo un sistema de conexión por usuarios y por perfil concreto.

La app se ha diseñado bajo el marco operativo de **SPRING** y más en concreto **HIBERNATE**, soportado por una estructura general de proyecto **MAVEN**.

---

## ⚙️ Requisitos Previos

Para garantizar el correcto despliegue y funcionamiento de la aplicación en tu entorno local, asegúrate de contar con las siguientes especificaciones técnicas:

*   **Versión de Java:** JDK 11.0.26
*   **Versión de Eclipse IDE:** Version 2022-03 (4.23.0) Build id: 20220310-1457
*   **Project Build Path:** JRE SYSTEM LIBRARY [JSE-11]
*   **Versión de MySQL Workbench:** 8.0.42
*   **Arquitectura App:** MAVEN PROJECT `org.apache.maven.archetypes-quickstart 1.5`
*   **Servidor Tomcat:** v9.0 Server
*   **Versión de SonarQube:** SonarQube 8.9.10 LTA

---

## 🛠️ Instalación y Despliegue

> 📌 **Nota importante:** El orden de los siguientes pasos es crítico para que la base de datos esté lista antes de desplegar el proyecto en el servidor Tomcat.

1. **Clonar el repositorio (Paso 1):**  
   Realiza un `git clone` en la carpeta destino que elijas - recomendamos que escojas el workspace general en el que trabajes con ECLIPSE.

2. **Configurar MySQL Workbench (Paso 2):**  
   Crear la BBDD en MYSQL WORKBENCH utilizando el SCRIPT de ejecución de la BBDD que se adjunta en el repositorio. Posteriormente, utilizar el SCRIPT de QUERYS que también se adjunta para insertar el contenido dentro de la BBDD. Dentro de ECLIPSE no es necesario realizar nada, puesto el repositorio se descarga completo con los archivos de ejecución separados. Igualmente adjuntamos todos los archivos y enumerados en su orden de ejecución por si se desea ejecutar manualmente.

3. **Importar el proyecto en Eclipse (Paso 3):**  
   Dentro de ECLIPSE selecciona en las ventanas superiores `File -> Open Projects from File System` y selecciona la carpeta donde se te ha clonado el repositorio.

4. **Asociar el servidor web (Paso 4):**  
   Asociar tu servidor Tomcat al proyecto para poder desplegar la aplicación.

5. **¡Listo para usar! (Paso 5):**  
   ¡Disfruta de tu propia app de gestión hotelera! Hemos incluido un archivo .SQL adicional - el 5, para que puedas insertar nuevos campos de prueba a tu BBDD y exprimas todo el potencial en tu nuevo proyecto. ¡Desde el Grand Resort Baratié esperamos que lo pases bien investigando las funcionalidades a disposición integradas!

---

## 🚀 Tecnologías Utilizadas

El proyecto de Eclipse funciona principalmente bajo el amparo de **SPRING HIBERNATE + JSTL + FORM MVC TAGS** siguiendo la arquitectura de **MAVEN**. A continuación detallamos todas las librerías y tecnologías necesarias para el correcto funcionamiento de la aplicación:

*   Librería Web y MVC para controladores y JSP
*   Librería Spring ORM + Hibernate
*   Librería Driver MYSQL
*   Librería JSTL y API de Servlets
*   Librería JSP API
*   Librería BCRYPT
*   Librería LOG4J
*   Tecnología Maven Compiler Plugin
*   Tecnología Maven WAR Plugin

---

## 📁 Estructura del Proyecto

El proyecto sigue una arquitectura limpia en capas, organizada bajo el paquete raíz `com.hotel`. A continuación se detalla la distribución de los componentes principales:

*   **`POM.XML`:** Raíz del proyecto `/root` - necesario para importación de librerías y plugins.
*   **Vistas JSP:** `src/main/webapp/WEB-INF/views` sustituyendo a los archivos .JAR.
*   **`HIBERNATE.CFG.XML`:** Ubicado en `src/main/resources`. Este archivo es el sustituto del driver jdbc. Actúa de nexo con el `db.properties` y como puente intermedio de `HibernateConfig.java`, uniendo dichas configuraciones y dependencias. También es el encargado de mapear las entidades .java desarrolladas.
*   **Archivos de propiedades:** Dentro de `src/main/resources` también coexisten los archivos `db.properties` y `log4j.properties` para el correcto enlace con BBDD y con su librería correspondiente, respectivamente.
*   **Carpeta SQL:** Raíz del proyecto `/root` - incluye los script de ejecución ordenados por orden de ejecución.

### Desglose de código fuente (`src/main/java`)

Aquí tenemos definidos sus paquetes y estructuras determinadas por capas para su correcta separación y definición:

*   `com.hotel.config`:
    *   `AppConfig.java`: Sustituto a `ApplicationContext.xml` - escaneo de componentes, controladores e interceptores, CRUD y vistas .JSP.
    *   `GlobalSecurityConfig`: Paquete destino funcionalidad extra interceptor.
    *   `AppInitializer.java`: Sustituto de `Web.xml` - funcionamiento de BBDD y WEB con Servlets.
    *   `HibernateConfig.java`: Incorporación de librerías de HIBERNATE y funcionamiento de `SessionFactory` y `Transactional`.
*   `com.hotel.controladores`: Paquete destino de los diversos controladores.
*   `com.hotel.entidades`: Paquete destino de las diversas entidades.
*   `com.hotel.excepciones`: Paquete destino de las distintas excepciones personalizadas y del subpaquete `.handler` donde actúa el controlador universal de las excepciones personalizadas.
*   `com.hotel.interceptores`: Paquete destino funcionalidad extra interceptor.
*   `com.hotel.repositorios`: Paquete destino a herramientas CRUD correspondientes a DAO (acceso a BBDD) con sus interfaces y el subpaquete `.impl` que aloja y define la lógica necesaria.
*   `com.hotel.servicios`: Paquete destino a herramientas CRUD correspondientes a servicios (modificación de BBDD) con sus interfaces y el subpaquete `.impl` que prepara y conecta los controladores.
*   `com.hotel.util`: Paquete destino a las funcionalidades extra de BCRYPT y generación de Hashs para la BBDD.

---

## 👥 Reparto de Tareas

*   **CONJUNTO:** Estructura de proyecto y orden de paquetes, archivos de configuración iniciales, creación base de datos y página de reservas.
*   **SEPARADO:**
    *   **Lidia Sandá López:** Implementación y ejecución SCRIPTS usuarios y huéspedes y los archivos .java necesarios - entidades, controladores, CRUD; y las vistas .JSPs.
    *   **David García Moreno:** Implementación y ejecución SCRIPTS habitaciones e incidencias y los archivos .java necesarios - entidades, controladores, CRUD; y las vistas .JSPs.

---

## 🔀 Conflictos de Merge

Siguiendo las instrucciones y pautas requeridas, cada incorporación se ha visto ejecutada mediante sus respectivos **PULL REQUEST**. 

En la **FASE 1**, en la integración de las ramas individuales de cada uno, hemos tenido que resolver los conflictos archivo por archivo - y utilizando las herramientas incorporadas tanto en github.com, en eclipse y en una ocasión con visual studio code respetando las adiciones del compañero y fusionando métodos en varios archivos cuando ha sido necesario.

En la **fase final de implementación de reservas** mantuvimos los métodos de cada uno resolviendo los conflictos también archivo por archivo y finalizando el pull request con las adiciones de cada uno trabajadas en los mismos archivos compartidos en común.

---

## ✨ Funcionalidades Extra

Gracias a la limpia arquitectura y la fuerte estructura empleada en el código, hemos podido incorporar las 5 funcionalidades extra sin mayor modificación al proyecto. En git detallamos punto por punto las modificaciones realizadas en cada -commit de cada extra llevado a cabo.

*   **EXTRA INTERCEPTOR:** Creación de archivo .java `AutenticacionInterceptor` y correspondiente mapeo en `AppConfig.java` para añadir las nuevas funcionalidades.
*   **EXTRA LOG4J:** Importación de librería, creación de `log4j.properties` para configurar tanto consola como su archivo de `.logs`. Como ya eliminamos todos los `system.out.print` del proyecto a la hora de comprobar el correcto funcionamiento de cada fase, no hemos tenido que modificar prácticamente nada de código; siendo el único logger el incluido en el método de generación de hash de la siguiente funcionalidad.
*   **EXTRA BCRYPT:** Importación de librería, archivos .java `GeneradorTemporal` y `Encriptador` con sus métodos estáticos para añadir en DAO y CRUD - repositorio y servicio de Usuario.
*   **EXTRA BÚSQUEDA:** Modificación de las vistas .JSP de listado - usuarios, reservas, habitaciones e incidencias. Modificación de controladores y de DAO y CRUD con las nuevas funcionalidades y métodos requeridos.
*   **EXTRA SONAR:** Descarga del programa. Runneo de TEST de SonarQube. Depuraciones de código en etiquetas JTSL en las vistas .jsp, método de serializable en entidad.java. El total de brechas de seguridad fue de 4 - se revisó el código y se aprobó. El total de bugs de accesibilidad con etiqueta *minor* fue de 76, las cuales son las mencionadas de etiquetas JTSL en las vistas .jsp.

---

## 🔑 Credenciales de Prueba

> ⚠️ **Importante:** Para el correcto funcionamiento de la app el usuario de MYSQL WORKBENCH ha de ser **'root'** y su contraseña **'123abc'** - detallado en `db.properties` y en `hibernate.cfg.xml`.

Para el testeo de roles dentro de la plataforma, utiliza los siguientes accesos:

| Perfil / Rol | Usuario | Contraseña |
| :--- | :--- | :--- |
| **Supervisor** | `admin_ana` | `1234abcd` |
| **Recepcionista** | `recep_juan` | `juan2026` |

---	
