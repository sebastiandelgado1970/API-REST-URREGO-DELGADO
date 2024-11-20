package com.urregodelgado.apirest.Universidad;

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
@RequestMapping("/universidad")
@RequiredArgsConstructor
public class UniversidadController {
    @Autowired
    private UniversidadService universidadService;

    // Obtener todas las universidades
    @GetMapping
    public List<Universidad> obtenerTodasLasUniversidades() {
        return universidadService.obtenerTodasLasUniversidades();
    }

    // Obtener una universidad por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Universidad> obtenerUniversidadPorId(@PathVariable int id) {
        Optional<Universidad> universidad = universidadService.obtenerUniversidadPorId(id);
        return universidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva universidad
    @PostMapping
    public ResponseEntity<Universidad> crearUniversidad(@RequestBody Universidad universidad) {
        Universidad nuevaUniversidad = universidadService.crearUniversidad(universidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaUniversidad);
    }

    // Actualizar una universidad
    @PutMapping("/{id}")
    public ResponseEntity<Universidad> actualizarUniversidad(@PathVariable int id, @RequestBody Universidad universidad) {
        Universidad universidadActualizada = universidadService.actualizarUniversidad(id, universidad);
        return universidadActualizada != null ? ResponseEntity.ok(universidadActualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una universidad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUniversidad(@PathVariable int id) {
        universidadService.eliminarUniversidad(id);
        return ResponseEntity.noContent().build();
    }
}