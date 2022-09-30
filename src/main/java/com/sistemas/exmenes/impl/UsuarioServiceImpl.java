
package com.sistemas.exmenes.impl;

import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.entidades.UsuarioRol;
import com.sistemas.exmenes.repositorios.RolRepository;
import com.sistemas.exmenes.repositorios.UsuarioRepository;
import com.sistemas.exmenes.servicios.UsuarioService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
       if(usuarioLocal != null ){
           System.out.println("El usuario ya existe");
           throw new Exception("El usuario ya esta presente");
       } 
       else{
           for(UsuarioRol usuarioRol:usuarioRoles){
               rolRepository.save(usuarioRol.getRol());
               
           }
           usuario.getUsuarioRoles().addAll(usuarioRoles);
           usuarioLocal = usuarioRepository.save(usuario);
       }
       return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username); 
    }

    @Override
    public void eliminarusuario(Long usuarioId) {
      usuarioRepository.deleteById(usuarioId);
    }

   
    
}
