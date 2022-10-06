
package com.sistemas.exmenes.impl;

import com.sistemas.exmenes.entidades.Examen;
import com.sistemas.exmenes.repositorios.ExamenRepository;
import com.sistemas.exmenes.servicios.ExamenService;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl implements ExamenService {
    
    @Autowired
    private ExamenRepository examenRepository;
    

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepository.save(examen);
        
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
        
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return examenRepository.findById(examenId).get();
        
    }

    @Override
    public void eliminarExamen(Long examenId) {
        
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        examenRepository.delete(examen);
        
    }
    
}
