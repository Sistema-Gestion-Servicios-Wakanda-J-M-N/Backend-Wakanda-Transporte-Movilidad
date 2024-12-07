package org.example.backendwakandatransportemovilidad.controller;

import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.TransporteDTO;
import org.example.backendwakandatransportemovilidad.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transportes")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    // Obtener todos los transportes
    @GetMapping
    public List<TransporteDTO> obtenerTodosLosTransportes() {
        return transporteService.getAll();
    }

    // Obtener un transporte por ID
    @GetMapping("/{id}")
    public TransporteDTO obtenerTransportePorId(@PathVariable Long id) {
        return transporteService.getById(id);
    }

    // Crear un transporte
    @PostMapping
    public Long crearTransporte(@RequestBody TransporteDTO transporteDTO) {
        return transporteService.create(transporteDTO);
    }

    // Actualizar un transporte existente
    @PutMapping("/{id}")
    public void actualizarTransporte(@PathVariable Long id, @RequestBody TransporteDTO transporteDTO) {
        transporteService.update(id, transporteDTO);
    }

    // Eliminar un transporte por ID
    @DeleteMapping("/{id}")
    public void eliminarTransporte(@PathVariable Long id) {
        transporteService.delete(id);
    }
}
