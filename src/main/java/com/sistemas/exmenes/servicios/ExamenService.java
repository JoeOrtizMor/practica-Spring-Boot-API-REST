//SERVICIOS
package com.sistemas.exmenes.servicios;

import com.sistemas.exmenes.entidades.Examen;
import java.util.Set;


public interface ExamenService {
    
    Examen agregarExamen(Examen examen);
    
    Examen actualizarExamen (Examen examen);
    
    Set<Examen> obtenerExamenenes();
    
    Examen obtenerExamen(Long examenId);
    
    void eliminarExamen(Long examenId);
    
}
