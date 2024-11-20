package com.urregodelgado.apirest.Equipo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    // Obtener todos los equipos
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    // Obtener un equipo por su ID
    public Optional<Equipo> obtenerEquipoPorId(int id) {
        return equipoRepository.findById(id);
    }

    // Crear un nuevo equipo
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Actualizar un equipo
    public Equipo actualizarEquipo(int id, Equipo equipo) {
        if (equipoRepository.existsById(id)) {
            equipo.setIdEquipo(id);
            return equipoRepository.save(equipo);
        }
        return null;
    }

    // Eliminar un equipo
    public void eliminarEquipo(int id) {
        equipoRepository.deleteById(id);
    }
    

    public List<Equipo> getEquiposNoClasificados(String universidadNombre, Integer anoActual) {
        return equipoRepository.findEquiposNoClasificados(universidadNombre, anoActual);
    }
}

