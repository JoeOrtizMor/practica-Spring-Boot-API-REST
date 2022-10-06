
package com.sistemas.exmenes.repositorios;

import com.sistemas.exmenes.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen, Long>{
    
}
