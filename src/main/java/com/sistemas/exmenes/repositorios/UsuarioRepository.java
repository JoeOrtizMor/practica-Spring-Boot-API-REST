
package com.sistemas.exmenes.repositorios;

import com.sistemas.exmenes.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername (String username);
 
    
}
