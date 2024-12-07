package org.example.backendwakandatransportemovilidad.service;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Metro;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Autobus;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.TransportePublico;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Tren;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Coche;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Moto;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Helicoptero;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.TransporteDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.CocheDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.HelicopteroDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.MotoDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.AutobusDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.MetroDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.TrenDTO;
import org.example.backendwakandatransportemovilidad.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.datos.DatosTransporteDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransporteService {

    @Autowired
    private TransporteRepository transporteRepository;

    @Autowired
    private TransportePublicoRepository transportePublicoRepository;

    @Autowired
    private TransportePrivadoRepository transportePrivadoRepository;

    @Autowired
    private MetroRepository metroRepository;

    @Autowired
    private AutobusRepository autobusRepository;

    @Autowired
    private TrenRepository trenRepository;

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private HelicopteroRepository helicopteroRepository;

    @Autowired
    private DatosTransporteService datosTransporteService;

    // Obtener todos los transportes
    public List<TransporteDTO> getAll() {
        return transporteRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Obtener un transporte por ID
    public TransporteDTO getById(Long id) {
        Transporte transporte = transporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado con ID: " + id));
        return mapToDTO(transporte);
    }

    // Crear un transporte
    @Transactional
    public Long create(TransporteDTO dto) {
        Transporte transporte = mapToEntity(dto);

        // Guardar transporte en el repositorio
        saveInSpecificRepository(transporte);
        transporte = transporteRepository.save(transporte);

        return transporte.getId();
    }

    @Transactional
    public void update(Long id, TransporteDTO dto) {
        // Obtener el transporte existente
        Transporte existingTransporte = transporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado con ID: " + id));

        // Actualizar atributos comunes
        existingTransporte.setNombre(dto.getNombre());
        existingTransporte.setDescripcion(dto.getDescripcion());
        existingTransporte.setCondiciones(dto.getCondiciones());
        existingTransporte.setCosto(dto.getCosto());

        // Verificar si la lista de DatosTransporteDTO existe y no está vacía
        if (dto.getDatosTransporte() != null && dto.getDatosTransporte() instanceof List) {
            List<DatosTransporteDTO> datosDTOList = (List<DatosTransporteDTO>) dto.getDatosTransporte();

            existingTransporte.getDatosTransporte().clear();

            for (DatosTransporteDTO datosDTO : datosDTOList) {
                DatosTransporte datos = new DatosTransporte();

                // Configurar atributos si los getters existen
                datos.setNombre(datosDTO.getNombre() != null ? datosDTO.getNombre() : "");
                datos.setDescripcion(datosDTO.getDescripcion() != null ? datosDTO.getDescripcion() : "");
                datos.setCondiciones(datosDTO.getCondiciones() != null ? datosDTO.getCondiciones() : "");
                datos.setTipo(datosDTO.getTipo() != null ? datosDTO.getTipo() : "");
                datos.setCosto(datosDTO.getCosto() != null ? datosDTO.getCosto() : 0.0);
                datos.setDetallesExtra(datosDTO.getDetallesExtra() != null ? datosDTO.getDetallesExtra() : "");

                datos.setTransporte(existingTransporte);
                existingTransporte.getDatosTransporte().add(datos);
            }
        }

        // Actualizar repositorios específicos
        updateInSpecificRepository(existingTransporte);

        // Guardar cambios
        transporteRepository.save(existingTransporte);
    }

    // Eliminar un transporte
    @Transactional
    public void delete(Long id) {
        Transporte transporte = transporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado con ID: " + id));

        // Eliminar transporte de los repositorios
        deleteFromSpecificRepository(transporte);
        transporteRepository.delete(transporte);
    }

    private Transporte mapToEntity(TransporteDTO dto) {

        if (dto instanceof MetroDTO) {
            Metro metro = new Metro();

            metro.setNombre(dto.getNombre());
            metro.setDescripcion(dto.getDescripcion());
            metro.setCondiciones(dto.getCondiciones());
            metro.setCosto(dto.getCosto());
            metro.setAccesibleDiscapacidad(((MetroDTO) dto).getAccesibleDiscapacidad());
            metro.setPrecio(((MetroDTO) dto).getPrecio());
            metro.setHorario(((MetroDTO) dto).getHorario());

            metro.setNumeroLineas(((MetroDTO) dto).getNumeroLineas());
            metro.setCapacidadMaxima(((MetroDTO) dto).getCapacidadMaxima());
            return metro;
        } else if (dto instanceof AutobusDTO) {
            Autobus autobus = new Autobus();

            autobus.setNombre(dto.getNombre());
            autobus.setDescripcion(dto.getDescripcion());
            autobus.setCondiciones(dto.getCondiciones());
            autobus.setCosto(dto.getCosto());
            autobus.setAccesibleDiscapacidad(((AutobusDTO) dto).getAccesibleDiscapacidad());
            autobus.setPrecio(((AutobusDTO) dto).getPrecio());
            autobus.setHorario(((AutobusDTO) dto).getHorario());

            autobus.setNumeroParadas(((AutobusDTO) dto).getNumeroParadas());
            autobus.setCapacidad(((AutobusDTO) dto).getCapacidad());
            return autobus;
        } else if (dto instanceof TrenDTO) {
            Tren tren = new Tren();

            tren.setNombre(dto.getNombre());
            tren.setDescripcion(dto.getDescripcion());
            tren.setCondiciones(dto.getCondiciones());
            tren.setCosto(dto.getCosto());
            tren.setAccesibleDiscapacidad(((TrenDTO) dto).getAccesibleDiscapacidad());
            tren.setPrecio(((TrenDTO) dto).getPrecio());
            tren.setHorario(((TrenDTO) dto).getHorario());

            tren.setVelocidadMaxima(((TrenDTO) dto).getVelocidadMaxima());
            tren.setCapacidad(((TrenDTO) dto).getCapacidad());
            return tren;
        } else if (dto instanceof CocheDTO) {
            Coche coche = new Coche();

            coche.setNombre(dto.getNombre());
            coche.setDescripcion(dto.getDescripcion());
            coche.setCondiciones(dto.getCondiciones());
            coche.setCosto(dto.getCosto());
            coche.setPropietario(((CocheDTO) dto).getPropietario());
            coche.setCostoMantenimiento(((CocheDTO) dto).getCostoMantenimiento());
            coche.setRequiereLicencia(((CocheDTO) dto).getRequiereLicencia());

            coche.setTipoCombustible(((CocheDTO) dto).getTipoCombustible());
            coche.setNumeroAsientos(((CocheDTO) dto).getNumeroAsientos());
            return coche;
        } else if (dto instanceof MotoDTO) {
            Moto moto = new Moto();

            moto.setNombre(dto.getNombre());
            moto.setDescripcion(dto.getDescripcion());
            moto.setCondiciones(dto.getCondiciones());
            moto.setCosto(dto.getCosto());
            moto.setPropietario(((MotoDTO) dto).getPropietario());
            moto.setCostoMantenimiento(((MotoDTO) dto).getCostoMantenimiento());
            moto.setRequiereLicencia(((MotoDTO) dto).getRequiereLicencia());

            moto.setCilindrada(((MotoDTO) dto).getCilindrada());
            moto.setEsElectrica(((MotoDTO) dto).getEsElectrica());
            return moto;
        } else if (dto instanceof HelicopteroDTO) {
            Helicoptero helicoptero = new Helicoptero();

            helicoptero.setNombre(dto.getNombre());
            helicoptero.setDescripcion(dto.getDescripcion());
            helicoptero.setCondiciones(dto.getCondiciones());
            helicoptero.setCosto(dto.getCosto());
            helicoptero.setPropietario(((HelicopteroDTO) dto).getPropietario());
            helicoptero.setCostoMantenimiento(((HelicopteroDTO) dto).getCostoMantenimiento());
            helicoptero.setRequiereLicencia(((HelicopteroDTO) dto).getRequiereLicencia());

            helicoptero.setAutonomiaVuelo(((HelicopteroDTO) dto).getAutonomiaVuelo());
            helicoptero.setCapacidad(((HelicopteroDTO) dto).getCapacidad());
            return helicoptero;
        }
        throw new IllegalArgumentException("Tipo de DTO no reconocido: " + dto.getClass().getSimpleName());
    }


    // Mapear Entidad a DTO
    private TransporteDTO mapToDTO(Transporte transporte) {

        TransporteDTO dto = new TransporteDTO();
        dto.setNombre(transporte.getNombre());
        dto.setDescripcion(transporte.getDescripcion());
        dto.setCondiciones(transporte.getCondiciones());
        dto.setCosto(transporte.getCosto());

        if (transporte instanceof Metro) {
            MetroDTO metroDTO = new MetroDTO();

            metroDTO.setNombre(transporte.getNombre());
            metroDTO.setDescripcion(transporte.getDescripcion());
            metroDTO.setCondiciones(transporte.getCondiciones());
            metroDTO.setCosto(transporte.getCosto());
            metroDTO.setAccesibleDiscapacidad(((Metro) transporte).getAccesibleDiscapacidad());
            metroDTO.setPrecio(((Metro) transporte).getPrecio());
            metroDTO.setHorario(((Metro) transporte).getHorario());

            metroDTO.setNumeroLineas(((Metro) transporte).getNumeroLineas());
            metroDTO.setCapacidadMaxima(((Metro) transporte).getCapacidadMaxima());
            return metroDTO;
        } else if (transporte instanceof Autobus) {
            AutobusDTO autobusDTO = new AutobusDTO();

            autobusDTO.setNombre(transporte.getNombre());
            autobusDTO.setDescripcion(transporte.getDescripcion());
            autobusDTO.setCondiciones(transporte.getCondiciones());
            autobusDTO.setCosto(transporte.getCosto());
            autobusDTO.setAccesibleDiscapacidad(((Autobus) transporte).getAccesibleDiscapacidad());
            autobusDTO.setPrecio(((Autobus) transporte).getPrecio());
            autobusDTO.setHorario(((Autobus) transporte).getHorario());

            autobusDTO.setNumeroParadas(((Autobus) transporte).getNumeroParadas());
            autobusDTO.setCapacidad(((Autobus) transporte).getCapacidad());
            return autobusDTO;
        } else if (transporte instanceof Tren) {
            TrenDTO trenDTO = new TrenDTO();

            trenDTO.setNombre(transporte.getNombre());
            trenDTO.setDescripcion(transporte.getDescripcion());
            trenDTO.setCondiciones(transporte.getCondiciones());
            trenDTO.setCosto(transporte.getCosto());
            trenDTO.setAccesibleDiscapacidad(((Tren) transporte).getAccesibleDiscapacidad());
            trenDTO.setPrecio(((Tren) transporte).getPrecio());
            trenDTO.setHorario(((Tren) transporte).getHorario());

            trenDTO.setVelocidadMaxima(((Tren) transporte).getVelocidadMaxima());
            trenDTO.setCapacidad(((Tren) transporte).getCapacidad());
            return trenDTO;
        } else if (transporte instanceof Coche) {
            CocheDTO cocheDTO = new CocheDTO();

            cocheDTO.setNombre(transporte.getNombre());
            cocheDTO.setDescripcion(transporte.getDescripcion());
            cocheDTO.setCondiciones(transporte.getCondiciones());
            cocheDTO.setCosto(transporte.getCosto());
            cocheDTO.setPropietario(((Coche) transporte).getPropietario());
            cocheDTO.setCostoMantenimiento(((Coche) transporte).getCostoMantenimiento());
            cocheDTO.setRequiereLicencia(((Coche) transporte).getRequiereLicencia());

            cocheDTO.setTipoCombustible(((Coche) transporte).getTipoCombustible());
            cocheDTO.setNumeroAsientos(((Coche) transporte).getNumeroAsientos());
            return cocheDTO;
        } else if (transporte instanceof Moto) {
            MotoDTO motoDTO = new MotoDTO();

            motoDTO.setNombre(transporte.getNombre());
            motoDTO.setDescripcion(transporte.getDescripcion());
            motoDTO.setCondiciones(transporte.getCondiciones());
            motoDTO.setCosto(transporte.getCosto());
            motoDTO.setPropietario(((Moto) transporte).getPropietario());
            motoDTO.setCostoMantenimiento(((Moto) transporte).getCostoMantenimiento());
            motoDTO.setRequiereLicencia(((Moto) transporte).getRequiereLicencia());

            motoDTO.setCilindrada(((Moto) transporte).getCilindrada());
            motoDTO.setEsElectrica(((Moto) transporte).getEsElectrica());
            return motoDTO;
        } else if (transporte instanceof Helicoptero) {
            HelicopteroDTO helicopteroDTO = new HelicopteroDTO();

            helicopteroDTO.setNombre(transporte.getNombre());
            helicopteroDTO.setDescripcion(transporte.getDescripcion());
            helicopteroDTO.setCondiciones(transporte.getCondiciones());
            helicopteroDTO.setCosto(transporte.getCosto());
            helicopteroDTO.setPropietario(((Helicoptero) transporte).getPropietario());
            helicopteroDTO.setCostoMantenimiento(((Helicoptero) transporte).getCostoMantenimiento());
            helicopteroDTO.setRequiereLicencia(((Helicoptero) transporte).getRequiereLicencia());

            helicopteroDTO.setAutonomiaVuelo(((Helicoptero) transporte).getAutonomiaVuelo());
            helicopteroDTO.setCapacidad(((Helicoptero) transporte).getCapacidad());
            return helicopteroDTO;
        }
        return dto;
    }

    // Guardar en el repositorio específico
    private void saveInSpecificRepository(Transporte transporte) {
        transporteRepository.save(transporte);

        if (transporte instanceof Metro) {
            metroRepository.save((Metro) transporte);
            transportePublicoRepository.save((Metro) transporte);
        } else if (transporte instanceof Autobus) {
            autobusRepository.save((Autobus) transporte);
            transportePublicoRepository.save((Autobus) transporte);
        } else if (transporte instanceof Tren) {
            trenRepository.save((Tren) transporte);
            transportePublicoRepository.save((Tren) transporte);
        } else if (transporte instanceof Coche) {
            cocheRepository.save((Coche) transporte);
            transportePrivadoRepository.save((Coche) transporte);
        } else if (transporte instanceof Moto) {
            motoRepository.save((Moto) transporte);
            transportePrivadoRepository.save((Moto) transporte);
        } else if (transporte instanceof Helicoptero) {
            helicopteroRepository.save((Helicoptero) transporte);
            transportePrivadoRepository.save((Helicoptero) transporte);
        }
    }

    // Guardar en el repositorio específico
    private void updateInSpecificRepository(Transporte transporte) {
        transporteRepository.save(transporte);

        if (transporte instanceof Metro) {
            metroRepository.updateTransporteById(transporte.getId(), (Metro) transporte);
            transportePublicoRepository.updateTransporteById(transporte.getId(), (Metro) transporte);
        } else if (transporte instanceof Autobus) {
            autobusRepository.updateTransporteById(transporte.getId(), (Autobus) transporte);
            transportePublicoRepository.updateTransporteById(transporte.getId(), (Autobus) transporte);
        } else if (transporte instanceof Tren) {
            trenRepository.updateTransporteById(transporte.getId(), (Tren) transporte);
            transportePublicoRepository.updateTransporteById(transporte.getId(), (Tren) transporte);
        } else if (transporte instanceof Coche) {
            cocheRepository.updateTransporteById(transporte.getId(), (Coche) transporte);
            transportePrivadoRepository.updateTransporteById(transporte.getId(),(Coche) transporte);
        } else if (transporte instanceof Moto) {
            motoRepository.updateTransporteById(transporte.getId(), (Moto) transporte);
            transportePrivadoRepository.updateTransporteById(transporte.getId(), (Moto) transporte);
        } else if (transporte instanceof Helicoptero) {
            helicopteroRepository.updateTransporteById(transporte.getId(), (Helicoptero) transporte);
            transportePrivadoRepository.updateTransporteById(transporte.getId(), (Helicoptero) transporte);
        }
    }

    // Eliminar de los repositorios específicos
    private void deleteFromSpecificRepository(Transporte transporte) {
        transporteRepository.delete(transporte);

        if (transporte instanceof Metro) {
            metroRepository.delete((Metro) transporte);
            transportePublicoRepository.delete((Metro) transporte);
        } else if (transporte instanceof Autobus) {
            autobusRepository.delete((Autobus) transporte);
            transportePublicoRepository.delete((Autobus) transporte);
        } else if (transporte instanceof Tren) {
            trenRepository.delete((Tren) transporte);
            transportePublicoRepository.delete((Tren) transporte);
        } else if (transporte instanceof Coche) {
            cocheRepository.delete((Coche) transporte);
            transportePrivadoRepository.delete((Coche) transporte);
        } else if (transporte instanceof Moto) {
            motoRepository.delete((Moto) transporte);
            transportePrivadoRepository.delete((Moto) transporte);
        } else if (transporte instanceof Helicoptero) {
            helicopteroRepository.delete((Helicoptero) transporte);
            transportePrivadoRepository.delete((Helicoptero) transporte);
        }
    }
}
