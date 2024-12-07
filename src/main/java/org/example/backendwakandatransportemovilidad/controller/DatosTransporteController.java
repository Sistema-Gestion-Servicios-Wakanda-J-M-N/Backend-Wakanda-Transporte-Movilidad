package org.example.backendwakandatransportemovilidad.controller;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;
import org.example.backendwakandatransportemovilidad.service.DatosTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos-transporte")
public class DatosTransporteController {

    @Autowired
    private DatosTransporteService datosTransporteService;

    // Obtener todos los DatosTransporte
    @GetMapping
    public List<DatosTransporte> obtenerTodosLosDatosTransporte() {
        return datosTransporteService.getAll();
    }

    // Obtener un DatosTransporte específico por ID
    @GetMapping("/{id}")
    public DatosTransporte obtenerDatosTransportePorId(@PathVariable Long id) {
        return datosTransporteService.getById(id);
    }

    // Crear DatosTransporte para todos los Transportes existentes
    @PostMapping("/crear-todos")
    public List<DatosTransporte> crearDatosTransporteParaTodos() {
        return datosTransporteService.createAll();
    }
}
