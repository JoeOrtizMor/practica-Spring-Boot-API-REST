
package com.sistemas.exmenes.controladores;

import com.sistemas.exmenes.entidades.Examen;
import com.sistemas.exmenes.entidades.Pregunta;
import com.sistemas.exmenes.servicios.ExamenService;
import com.sistemas.exmenes.servicios.PreguntaService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {
    
    @Autowired
    private PreguntaService preguntaService;
    
    @Autowired
    private ExamenService examenService;
    
    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
        
    }
    
    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
        
    }
    
    //Sublist: Permite extraer un subconjunto de elementos de una lista indicando el rango de elemento a extraer
    
    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId")Long examenId){
        Examen examen = examenService.obtenerExamen(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas();
        
        //Obtenemos preguntas de un examen en particular
        List examenes = new ArrayList(preguntas);
        if(examenes.size() > Integer.parseInt(examen.getNumeroDePregutas())){
            examenes = examenes.subList(0,Integer.parseInt(examen.getNumeroDePregutas() + 1));//Obtenemos el numero de preguntas
        }
        
        Collections.shuffle(examenes);//Barajea los elementos 
        return ResponseEntity.ok(examenes);//Retornamos 
    }
    
    
    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }
    
    //Eliminamos pregunta
    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId")Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
        
    }
    
    
}
