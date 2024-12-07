package org.example.backendwakandatransportemovilidad.service;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;
import org.example.backendwakandatransportemovilidad.repos.TransporteRepository;
import org.example.backendwakandatransportemovilidad.repos.DatosTransporteRepository;
import org.example.backendwakandatransportemovilidad.service.factory.TransporteFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosTransporteService {

    @Autowired
    private TransporteRepository transporteRepository;

    @Autowired
    private DatosTransporteRepository datosTransporteRepository;

    @Autowired
    private TransporteFactory transporteFactory;

    // Obtener todos los DatosTransporte
    public List<DatosTransporte> getAll() {
        return datosTransporteRepository.findAll();
    }

    // Obtener un DatosTransporte específico por ID
    public DatosTransporte getById(Long id) {
        return datosTransporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DatosTransporte no encontrado con ID: " + id));
    }

    // Crear DatosTransporte desde una entidad Transporte existente
    @Transactional
    public DatosTransporte create(Long transporteId) {
        Transporte transporte = transporteRepository.findById(transporteId)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado con ID: " + transporteId));

        DatosTransporte datosTransporte = transporteFactory.obtenerTransporte(transporte);
        return datosTransporteRepository.save(datosTransporte);
    }

    // Crear DatosTransporte para todos los Transportes existentes
    @Transactional
    public List<DatosTransporte> createAll() {
        List<Transporte> transportes = transporteRepository.findAll();

        List<DatosTransporte> datosTransporteList = transportes.stream()
                .map(transporteFactory::obtenerTransporte)
                .collect(Collectors.toList());

        return datosTransporteRepository.saveAll(datosTransporteList);
    }

    // Actualizar DatosTransporte a partir de un Transporte
    @Transactional
    public void update(Transporte transporte) {
        // Buscar el DatosTransporte correspondiente al transporte
        DatosTransporte existingData = datosTransporteRepository.findById(transporte.getId())
                .orElseThrow(() -> new RuntimeException("DatosTransporte no encontrado con ID: " + transporte.getId()));

        // Generar nuevos datos utilizando el factory
        DatosTransporte updatedData = transporteFactory.obtenerTransporte(transporte);

        // Actualizar los atributos del DatosTransporte existente
        existingData.setNombre(updatedData.getNombre());
        existingData.setDescripcion(updatedData.getDescripcion());
        existingData.setCondiciones(updatedData.getCondiciones());
        existingData.setTipo(updatedData.getTipo());
        existingData.setCosto(updatedData.getCosto());
        existingData.setDetallesExtra(updatedData.getDetallesExtra());

        // Guardar los cambios en el repositorio
        datosTransporteRepository.save(existingData);
    }

    // Eliminar un DatosTransporte por ID
    @Transactional
    public void delete(Long id) {
        DatosTransporte datosTransporte = datosTransporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DatosTransporte no encontrado con ID: " + id));

        datosTransporteRepository.delete(datosTransporte);
    }
}
