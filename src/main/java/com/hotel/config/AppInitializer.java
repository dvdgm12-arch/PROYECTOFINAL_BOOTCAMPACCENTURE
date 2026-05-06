// SUSTITUTO DE DE WEB.XML PARA AVISAR DE ERRORES AL MOMENTO

package com.hotel.config;

import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
 // CONFIGURACION DE BBDD
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class }; 
    }

    @Override
 // CONFIGURACION DE LA WEB
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class }; 
    }

    @Override
    // GESTION DEL SERVIDOR POR SPRING
    protected String[] getServletMappings() {
        return new String[] { "/" }; 
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //GESTION DE LA VISTA error.jsp
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}
