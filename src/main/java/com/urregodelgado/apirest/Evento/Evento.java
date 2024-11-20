package com.urregodelgado.apirest.Evento;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Evento {
    @Id
    @GeneratedValue
    private Integer IdEvento;
    @Basic
    private String nombreEvt;
    private String fechaInicio;
    private String fechaFin;
    private String lugar;
    private String modalidad;
    private String estado;
    private String ganador;

   
}