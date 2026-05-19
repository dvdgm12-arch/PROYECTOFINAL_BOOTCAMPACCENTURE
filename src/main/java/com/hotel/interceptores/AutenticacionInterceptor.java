package com.hotel.interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public class AutenticacionInterceptor implements HandlerInterceptor {

    /**
     * Pre handle.
     *
     * @param request the request
     * @param response the response
     * @param handler the handler
     * @return true, if successful
     * @throws Exception the exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        HttpSession sesion = request.getSession();
        
        if (sesion.getAttribute("usuarioSesion") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false; 
        }
        
        return true; 
    }
}
