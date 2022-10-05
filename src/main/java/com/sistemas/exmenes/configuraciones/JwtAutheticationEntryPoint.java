
package com.sistemas.exmenes.configuraciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;



//Implementamos la clase AuthenticationEntryPoint
@Component
public class JwtAutheticationEntryPoint implements AuthenticationEntryPoint{

    //Maneja los errores
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario no autorizado");//Indica que el usuario no esta autenticado
    }
    
}
