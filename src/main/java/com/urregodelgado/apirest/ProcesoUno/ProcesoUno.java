package com.urregodelgado.apirest.ProcesoUno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universidades")
public class ProcesoUno {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Endpoint para consultar equipos no clasificados
    @GetMapping("/{nombreUniversidad}/equipos-no-clasificados")
    public List<Map<String, Object>> obtenerEquiposNoClasificados(
            @PathVariable String nombreUniversidad,
            @RequestParam int anoActual) {

        String query = "CALL ConsultarEquiposNoClasificados(?, ?)";
        return jdbcTemplate.queryForList(query, nombreUniversidad, anoActual);
    }
}