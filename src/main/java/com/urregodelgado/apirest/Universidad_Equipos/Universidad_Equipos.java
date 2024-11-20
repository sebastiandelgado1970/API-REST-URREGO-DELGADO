package com.urregodelgado.apirest.Universidad_Equipos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.urregodelgado.apirest.Universidad.Universidad;
import com.urregodelgado.apirest.Equipo.Equipo;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@IdClass(Universidad_Equipos.class)

@Table(name = "Universidad_Equipos")
public class Universidad_Equipos implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdUniversidad")
    private Universidad universidad;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdEquipo")
    private Equipo equipo;

}

