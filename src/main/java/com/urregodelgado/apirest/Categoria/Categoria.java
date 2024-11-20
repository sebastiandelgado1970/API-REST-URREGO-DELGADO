package com.urregodelgado.apirest.Categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.urregodelgado.apirest.Evento.Evento;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @ManyToOne
    @JoinColumn(name = "IdEvento", referencedColumnName = "IdEvento", insertable = false, updatable = false)
    private Evento evento; // Asume que existe una clase `Evento` mapeada.

    private String nombreCat;
    private String nivelDificultad;
    private String descripcion;

    

}
