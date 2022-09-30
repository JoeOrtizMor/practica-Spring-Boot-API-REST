
package com.sistemas.exmenes.controladores;


import com.sistemas.exmenes.entidades.Rol;
import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.entidades.UsuarioRol;

import com.sistemas.exmenes.servicios.UsuarioService;
import java.util.HashSet;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*") //Permite cualquier peticion (POST, GET, PUT, DELETE)
public class UsuarioController {
    
    @Autowired //Se inyecta el servicio
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
   
    //Registro de nuevo usuario
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario)throws Exception{//Manda el objeto con sus datos
        usuario.setPerfil("default.png");
        
        //Encripta la contraseña del usuario
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        
        Set<UsuarioRol>usuarioRoles = new HashSet<>();//Asigan los roles
        
        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL"); //Para los usuarios se asigna el rol "NORMAL" por defecto
        
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        
        usuarioRoles.add(usuarioRol); //Se agregan la cantidad de usuarios que se desee
        return usuarioService.guardarUsuario(usuario, usuarioRoles);
    }
    
    
    
    
    
    @GetMapping("/{username}")
    public Usuario obtnerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
        
    }
    
    @DeleteMapping("/{usuarioId}")
    public void elminarUsuario(@PathVariable("usuarioId") Long usuarioId){
       usuarioService.eliminarusuario(usuarioId);
        
    }
    
    
}
