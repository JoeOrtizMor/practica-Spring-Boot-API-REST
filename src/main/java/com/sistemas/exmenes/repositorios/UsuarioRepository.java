
package com.sistemas.exmenes.repositorios;

import com.sistemas.exmenes.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Metodos "find"
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    //Busca por Username
    public Usuario findByUsername (String username);
 
    
}
