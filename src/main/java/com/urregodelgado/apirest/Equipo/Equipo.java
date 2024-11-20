package com.urregodelgado.apirest.Equipo;

import jakarta.persistence.*;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.urregodelgado.apirest.Categoria.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;

    @ManyToOne
    @JoinColumn(name = "IdCategoria", nullable = false)
    private Categoria categoria;

    private Boolean clasificado;
    private Integer anoClasificacion;
    private Integer noIntegrantes;
    private String pais;
    private Double puntosTotales;

   

}
