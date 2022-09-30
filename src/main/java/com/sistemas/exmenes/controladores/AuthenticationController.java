
package com.sistemas.exmenes.controladores;

import com.sistemas.exmenes.configuraciones.JwtUtils;
import com.sistemas.exmenes.entidades.JwtRequest;
import com.sistemas.exmenes.entidades.JwtResponse;
import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.excepciones.UsuarioNotFoundException;
import com.sistemas.exmenes.impl.UserDetailsServiceImpl;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Permite el intercambio de recursos entre el Backend y FrontEnd
@CrossOrigin("*")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    //Inyeccion de dependencias
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping("/generate-token") //Generacion del token
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsuarioNotFoundException exception) { //No se a encontrado un usuario
            exception.printStackTrace();
            throw new Exception("Usuarios no encontrado");
        }
        
        //
         UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void autenticar(String username, String password) throws Exception{
        
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); //Verifica la autenticacion del token
        }catch(DisabledException disabledException){
            throw new Exception("USUARIO DESHABILITADO" + disabledException.getMessage());
            
        }catch(BadCredentialsException badCredentialsException){
            throw new Exception("Crendenciales invalidas" + badCredentialsException.getMessage());
            
        }
        
    }
    
    //Muestra los datos del actual usuario con el que esta logueado
    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
        
    }
    
}
