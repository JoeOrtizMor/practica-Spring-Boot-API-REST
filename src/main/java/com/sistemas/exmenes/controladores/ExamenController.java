
package com.sistemas.exmenes.controladores;


import com.sistemas.exmenes.entidades.Examen;

import com.sistemas.exmenes.servicios.ExamenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {
    
    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Examen> guardarCategoria(@RequestBody Examen examen){
        
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }

   
    
}
