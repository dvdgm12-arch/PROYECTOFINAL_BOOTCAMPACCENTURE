// SUSTITUTO DE DE APPLICATIONCONTEXT.XML PARA AVISAR DE ERRORES AL MOMENTO

package com.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hotel.interceptores.AutenticacionInterceptor;

@Configuration
@EnableWebMvc
//ESCANEO DE CONTROLADORES, CRUD (SERVICIOS Y REPOSITORIOS) Y EXCEPCIONES
@ComponentScan(basePackages = "com.hotel") 
public class AppConfig implements WebMvcConfigurer {

    // CONFIGURACION DE UBICACION DE JSPs
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // IMPEDIR BLOQUEO DE BOOTSTRAP
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    

    // REGISTRO DEL INTERCEPTOR DE SEGURIDAD
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new AutenticacionInterceptor())
                 .addPathPatterns("/**")
                 
                 .excludePathPatterns("/")
                 .excludePathPatterns("/login/**")               
                 .excludePathPatterns("/resources/**");           
     }
}
