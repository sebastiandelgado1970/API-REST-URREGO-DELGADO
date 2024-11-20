package com.urregodelgado.apirest.Equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    @Query(value = """
            SELECT e.*
            FROM Equipos e
            JOIN Universidades_Equipos ue ON e.IdEquipo = ue.IdEquipo
            JOIN Universidades u ON ue.IdUniversidad = u.IdUniversidad
            WHERE u.NombreU = :universidadNombre
              AND e.Clasificado = false
              AND e.AnoClasificacion > (:anoActual - 5)
            """, nativeQuery = true)
    List<Equipo> findEquiposNoClasificados(
            @Param("universidadNombre") String universidadNombre,
            @Param("anoActual") Integer anoActual);
}