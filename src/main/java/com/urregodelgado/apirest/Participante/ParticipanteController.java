package com.urregodelgado.apirest.Participante;

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
@RequestMapping("/participante")
@RequiredArgsConstructor
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    // Obtener todos los participantes
    @GetMapping
    public List<Participante> obtenerTodosLosParticipantes() {
        return participanteService.obtenerTodosLosParticipantes();
    }

    // Obtener un participante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Participante> obtenerParticipantePorId(@PathVariable int id) {
        Optional<Participante> participante = participanteService.obtenerParticipantePorId(id);
        return participante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo participante
    @PostMapping
    public ResponseEntity<Participante> crearParticipante(@RequestBody Participante participante) {
        Participante nuevoParticipante = participanteService.crearParticipante(participante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoParticipante);
    }

    // Actualizar un participante
    @PutMapping("/{id}")
    public ResponseEntity<Participante> actualizarParticipante(@PathVariable int id, @RequestBody Participante participante) {
        Participante participanteActualizado = participanteService.actualizarParticipante(id, participante);
        return participanteActualizado != null ? ResponseEntity.ok(participanteActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un participante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParticipante(@PathVariable int id) {
        participanteService.eliminarParticipante(id);
        return ResponseEntity.noContent().build();
    }
}
