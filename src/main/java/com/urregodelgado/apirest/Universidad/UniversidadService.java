package com.urregodelgado.apirest.Universidad;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class UniversidadService {
    @Autowired
    private UniversidadRepository universidadRepository;

    // Obtener todas las universidades
    public List<Universidad> obtenerTodasLasUniversidades() {
        return universidadRepository.findAll();
    }

    // Obtener una universidad por su ID
    public Optional<Universidad> obtenerUniversidadPorId(int id) {
        return universidadRepository.findById(id);
    }

    // Crear una nueva universidad
    public Universidad crearUniversidad(Universidad universidad) {
        return universidadRepository.save(universidad);
    }

    // Actualizar una universidad
    public Universidad actualizarUniversidad(int id, Universidad universidad) {
        if (universidadRepository.existsById(id)) {
            universidad.setIdUniversidad(id);
            return universidadRepository.save(universidad);
        }
        return null;
    }

    // Eliminar una universidad
    public void eliminarUniversidad(int id) {
        universidadRepository.deleteById(id);
    }
}