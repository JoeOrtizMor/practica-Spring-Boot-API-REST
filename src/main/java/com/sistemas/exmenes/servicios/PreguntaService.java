
package com.sistemas.exmenes.servicios;

import com.sistemas.exmenes.entidades.Examen;
import com.sistemas.exmenes.entidades.Pregunta;
import java.util.Set;

public interface PreguntaService {
    
    Pregunta agregarPregunta(Pregunta pregunta);
    
    Pregunta actualizarPregunta(Pregunta pregunta);
    
    
    Set<Pregunta> obtenerPreguntas();
    
    Pregunta obtenerPregunta(Long preguntaId);
    
    Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);
    
    void eliminarPregunta(Long preguntaId);
}
