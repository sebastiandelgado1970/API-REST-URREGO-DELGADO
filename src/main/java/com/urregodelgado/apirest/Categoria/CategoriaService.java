package com.urregodelgado.apirest.Categoria;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<Categoria> obtenerCategoriaPorId(int id) {
        return categoriaRepository.findById(id);
    }

    // Crear una nueva categoría
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría
    public Categoria actualizarCategoria(int id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setIdCategoria(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    // Eliminar una categoría
    public void eliminarCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
}

