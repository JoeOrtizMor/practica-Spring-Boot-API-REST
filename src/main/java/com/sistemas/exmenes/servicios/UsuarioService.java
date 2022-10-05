
package com.sistemas.exmenes.servicios;

import com.sistemas.exmenes.entidades.Usuario;
import com.sistemas.exmenes.entidades.UsuarioRol;
import java.util.Set;


public interface UsuarioService {
    
    //Guarda usuarios y pasa por un conjunto de roles
    //Set: Pasa un conjunto de roles que asignamos
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles)throws Exception;
    
    
    public Usuario obtenerUsuario(String username);
    
    public void eliminarusuario(Long usuarioId);
    
    public Usuario obtenerEmial(String email);
    
  
   
  
    
}
