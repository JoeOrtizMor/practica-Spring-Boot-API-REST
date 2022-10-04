package com.sistemas.exmenes;


import com.sistemas.exmenes.entidades.Rol;
import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.entidades.UsuarioRol;
import com.sistemas.exmenes.excepciones.UsuarioFoundException;
import com.sistemas.exmenes.servicios.UsuarioService;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//CommandLine: Permite ejecutar lo que esta en el metodo "run"
public class SistemaExamenesBackendApplication implements CommandLineRunner{
    
    //Inyectamos el servicio
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
       
        
        //Registro del Usuario admin
        /*try{
             Usuario usuario = new Usuario();
        
        usuario.setNombre("Joe");
        usuario.setApellido("Ortiz");
        usuario.setUsername("JoeMorales");
        usuario.setPassword(bCryptPasswordEncoder.encode("belen"));
        usuario.setEmail("ezio@gmail.com");
        usuario.setTelefono("2871516235");
        usuario.setPerfil("foto.png");
        
        Rol rol = new Rol();
        rol.setRolId(1L);
        rol.setNombre("ADMIN");
        
        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);
        
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
        System.out.println(usuarioGuardado.getUsername());
            
        }catch(UsuarioFoundException exception){
            exception.printStackTrace();
            
        }*/
    }
    
    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
                    
			
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
			}
		};
	}*/

}
