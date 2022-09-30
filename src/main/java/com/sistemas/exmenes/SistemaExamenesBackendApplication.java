package com.sistemas.exmenes;


import com.sistemas.exmenes.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner{
    
    @Autowired
    private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
       /* Usuario usuario = new Usuario();
        
        usuario.setNombre("Joe");
        usuario.setApellido("Ortiz");
        usuario.setUsername("JoeOrt21");
        usuario.setPassword("password");
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
        System.out.println(usuarioGuardado.getUsername());*/
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
                    
			
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
			}
		};
	}

}
