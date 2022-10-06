
package com.sistemas.exmenes.repositorios;

import com.sistemas.exmenes.entidades.Examen;
import com.sistemas.exmenes.entidades.Pregunta;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{
    
    Set<Pregunta> findByExamen(Examen examen);
    
}
