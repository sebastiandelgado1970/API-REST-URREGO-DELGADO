package com.urregodelgado.apirest.Universidad_Equipos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class Universidad_EquiposService {

    @Autowired
    private Universidad_EquiposRepository universidadEquipoRepository;

    // Obtener todos los registros Universidad-Equipo
    public List<Universidad_Equipos> obtenerTodosLosRegistros() {
        return universidadEquipoRepository.findAll();
    }

    // Crear un nuevo registro
    public Universidad_Equipos crearRegistro(Universidad_Equipos universidadEquipo) {
        return universidadEquipoRepository.save(universidadEquipo);
    }

    // Eliminar un registro y obtener un registro no son posibles al tener id combinado
    
    
}