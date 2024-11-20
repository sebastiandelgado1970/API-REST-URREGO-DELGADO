package com.urregodelgado.apirest.Universidad_Equipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/universidad_equipo")
@RequiredArgsConstructor
public class Universidad_EquiposController {
    @Autowired
    private Universidad_EquiposRepository universidadEquipoRepository;

    // Obtener todos los registros Universidad-Equipo
    public List<Universidad_Equipos> obtenerTodosLosRegistros() {
        return universidadEquipoRepository.findAll();
    }

    // Obtener un registro por su ID
    
    

    // Crear un nuevo registro
    public Universidad_Equipos crearRegistro(Universidad_Equipos universidadEquipo) {
        return universidadEquipoRepository.save(universidadEquipo);
    }

    // Eliminar un registro
    
    }

