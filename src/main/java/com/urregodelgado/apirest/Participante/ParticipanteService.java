package com.urregodelgado.apirest.Participante;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    // Obtener todos los participantes
    public List<Participante> obtenerTodosLosParticipantes() {
        return participanteRepository.findAll();
    }

    // Obtener un participante por su ID
    public Optional<Participante> obtenerParticipantePorId(int id) {
        return participanteRepository.findById(id);
    }

    // Crear un nuevo participante
    public Participante crearParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    // Actualizar un participante
    public Participante actualizarParticipante(int id, Participante participante) {
        if (participanteRepository.existsById(id)) {
            participante.setIdParticipante(id);
            return participanteRepository.save(participante);
        }
        return null;
    }

    // Eliminar un participante
    public void eliminarParticipante(int id) {
        participanteRepository.deleteById(id);
    }
}