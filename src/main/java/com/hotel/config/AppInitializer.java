// SUSTITUTO DE DE WEB.XML PARA AVISAR DE ERRORES AL MOMENTO

package com.hotel.config;

import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// TODO: Auto-generated Javadoc
/**
* The Class AppConfig.
*
* @author Lidia Sandá López & David García Moreno
* @version 1.0 VERSIÓN GOLD - 19/05/2026
*/

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Gets the root config classes.
     *
     * @return the root config classes
     */
    @Override
 // CONFIGURACION DE BBDD
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class }; 
    }

    /**
     * Gets the servlet config classes.
     *
     * @return the servlet config classes
     */
    @Override
 // CONFIGURACION DE LA WEB
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class }; 
    }

    /**
     * Gets the servlet mappings.
     *
     * @return the servlet mappings
     */
    @Override
    // GESTION DEL SERVIDOR POR SPRING
    protected String[] getServletMappings() {
        return new String[] { "/" }; 
    }
    
    /**
     * Customize registration.
     *
     * @param registration the registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //GESTION DE LA VISTA error.jsp
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}
