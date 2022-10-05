 
package com.sistemas.exmenes.impl;


import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.entidades.UsuarioRol;
import com.sistemas.exmenes.excepciones.UsuarioFoundException;
import com.sistemas.exmenes.repositorios.RolRepository;
import com.sistemas.exmenes.repositorios.UsuarioRepository;
import com.sistemas.exmenes.servicios.UsuarioService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


//Indicamos que es un servicio
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    //Inyectamos dependencias
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    @Autowired
    private RolRepository rolRepository;
    

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        
        //Metodo IF en caso de que el usuario ya existe
       if(usuarioLocal != null ){
           System.out.println("El usuario ya existe");
           throw new UsuarioFoundException("El usuario ya esta presente");
       } 
       else{
           //Guarda los roles que estamos obteniedo en la BD
           for(UsuarioRol usuarioRol:usuarioRoles){
               rolRepository.save(usuarioRol.getRol());
               
           }
           //Agrega toda la lista de "UsuarioRoles"
           usuario.getUsuarioRoles().addAll(usuarioRoles);
           
           //Asignamos la usuario
           usuarioLocal = usuarioRepository.save(usuario);
       }
       return usuarioLocal;//Retornamos
    }

    //Implementamos los metodos de UsuarioService
    @Override
    public Usuario obtenerUsuario(String username) {
        //Busca por username
        return usuarioRepository.findByUsername(username); 
    }

    @Override
    public void eliminarusuario(Long usuarioId) {
        //Eliminamos por ID del usuario
      usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public Usuario obtenerEmial(String email) {
        return usuarioRepository.findByEmail(email);
    }

    
 

    

   
    
}
