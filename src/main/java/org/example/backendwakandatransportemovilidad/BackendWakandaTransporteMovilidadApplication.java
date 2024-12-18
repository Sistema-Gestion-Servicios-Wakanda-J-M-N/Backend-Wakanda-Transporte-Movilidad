package org.example.backendwakandatransportemovilidad;

import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.CocheDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.HelicopteroDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado.MotoDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.AutobusDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.MetroDTO;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico.TrenDTO;
import org.example.backendwakandatransportemovilidad.service.TransporteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class BackendWakandaTransporteMovilidadApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BackendWakandaTransporteMovilidadApplication.class, args);

        TransporteService transporteService = context.getBean(TransporteService.class);

        try {
            // 1. Crear instancias de transporte
            System.out.println("\n--- Creación de Transportes ---");

            MetroDTO metroDTO = new MetroDTO();
            metroDTO.setNombre("Metro Central");
            metroDTO.setDescripcion("Línea principal de la ciudad");
            metroDTO.setCondiciones("Operativo de 6 AM a 11 PM");
            metroDTO.setCosto(2.5);
            metroDTO.setNumeroLineas(5);
            metroDTO.setCapacidadMaxima(300);
            metroDTO.setAccesibleDiscapacidad(true);
            metroDTO.setHorario("6 AM - 11 PM");
            metroDTO.setPrecio(2.5);
            Long metroId = transporteService.create(metroDTO);
            System.out.println("Metro creado con ID: " + metroId);

            AutobusDTO autobusDTO = new AutobusDTO();
            autobusDTO.setNombre("Autobús Urbano");
            autobusDTO.setDescripcion("Transporte urbano con múltiples paradas");
            autobusDTO.setCondiciones("Disponible durante el día");
            autobusDTO.setCosto(1.5);
            autobusDTO.setNumeroParadas(20);
            autobusDTO.setCapacidad(50);
            autobusDTO.setAccesibleDiscapacidad(true);
            autobusDTO.setHorario("6 AM - 10 PM");
            autobusDTO.setPrecio(1.5);
            Long autobusId = transporteService.create(autobusDTO);
            System.out.println("Autobús creado con ID: " + autobusId);

            TrenDTO trenDTO = new TrenDTO();
            trenDTO.setNombre("Tren de Alta Velocidad");
            trenDTO.setDescripcion("Transporte rápido entre ciudades");
            trenDTO.setCondiciones("Operativo todo el día");
            trenDTO.setCosto(50.0);
            trenDTO.setVelocidadMaxima(300);
            trenDTO.setCapacidad(400);
            trenDTO.setAccesibleDiscapacidad(true);
            trenDTO.setHorario("24/7");
            trenDTO.setPrecio(50.0);
            Long trenId = transporteService.create(trenDTO);
            System.out.println("Tren creado con ID: " + trenId);

            CocheDTO cocheDTO = new CocheDTO();
            cocheDTO.setNombre("Coche Familiar");
            cocheDTO.setDescripcion("Vehículo privado para uso personal");
            cocheDTO.setCondiciones("Mantenimiento requerido cada 6 meses");
            cocheDTO.setCosto(20000.0);
            cocheDTO.setTipoCombustible("Gasolina");
            cocheDTO.setNumeroAsientos(5);
            cocheDTO.setPropietario("Ana Gómez");
            cocheDTO.setCostoMantenimiento(1000.0);
            cocheDTO.setRequiereLicencia(true);
            Long cocheId = transporteService.create(cocheDTO);
            System.out.println("Coche creado con ID: " + cocheId);

            MotoDTO motoDTO = new MotoDTO();
            motoDTO.setNombre("Moto Deportiva");
            motoDTO.setDescripcion("Vehículo rápido de dos ruedas");
            motoDTO.setCondiciones("Requiere casco obligatorio");
            motoDTO.setCosto(10000.0);
            motoDTO.setCilindrada(600);
            motoDTO.setEsElectrica(false);
            motoDTO.setRequiereLicencia(true);
            motoDTO.setCostoMantenimiento(500.0);
            motoDTO.setPropietario("Juan Pérez");
            Long motoId = transporteService.create(motoDTO);
            System.out.println("Moto creada con ID: " + motoId);

            HelicopteroDTO helicopteroDTO = new HelicopteroDTO();
            helicopteroDTO.setNombre("Helicóptero Privado");
            helicopteroDTO.setDescripcion("Vehículo aéreo para transporte exclusivo");
            helicopteroDTO.setCondiciones("Requiere licencia especial de vuelo");
            helicopteroDTO.setCosto(500000.0);
            helicopteroDTO.setAutonomiaVuelo(600);
            helicopteroDTO.setCapacidad(6);
            helicopteroDTO.setRequiereLicencia(true);
            helicopteroDTO.setCostoMantenimiento(10000.0);
            helicopteroDTO.setPropietario("Carlos Rodríguez");
            Long helicopteroId = transporteService.create(helicopteroDTO);
            System.out.println("Helicóptero creado con ID: " + helicopteroId);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
