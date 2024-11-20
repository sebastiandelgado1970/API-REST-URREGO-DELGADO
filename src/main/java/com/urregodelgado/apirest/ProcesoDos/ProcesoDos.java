package com.urregodelgado.apirest.ProcesoDos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universidades")
public class ProcesoDos {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Endpoint para obtener el top 10 de universidades por país
    @GetMapping("/top-universidades")
    public List<Map<String, Object>> obtenerTopUniversidades() {
        String query = "CALL TopUniversidadesPais()";
        return jdbcTemplate.queryForList(query);
    }
}