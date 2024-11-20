package com.urregodelgado.apirest.Evento;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    // Obtener todos los eventos
    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    // Obtener un evento por su ID
    public Optional<Evento> obtenerEventoPorId(int id) {
        return eventoRepository.findById(id);
    }

    // Crear un nuevo evento
    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Actualizar un evento
    public Evento actualizarEvento(int id, Evento evento) {
        if (eventoRepository.existsById(id)) {
            evento.setIdEvento(id);
            return eventoRepository.save(evento);
        }
        return null;
    }

    // Eliminar un evento
    public void eliminarEvento(int id) {
        eventoRepository.deleteById(id);
    }
}



