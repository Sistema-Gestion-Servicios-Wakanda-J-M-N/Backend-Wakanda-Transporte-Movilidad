package org.example.backendwakandatransportemovilidad.service.factory;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Metro;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Autobus;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Tren;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Coche;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Moto;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Helicoptero;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;
import org.springframework.stereotype.Service;


@Service
public class TransporteFactory {

    public DatosTransporte obtenerTransporte(Transporte transporte) {
        if (transporte instanceof Metro) {
            Metro metro = (Metro) transporte;
            return new DatosTransporte(
                    metro.getNombre(),
                    metro.getDescripcion(),
                    metro.getCondiciones(),
                    "Metro",
                    metro.getCosto(),
                    "Número de Líneas: " + metro.getNumeroLineas() +
                            ", Capacidad Máxima: " + metro.getCapacidadMaxima() +
                            ", Horario: " + metro.getHorario() +
                            ", Precio: " + metro.getPrecio() +
                            ", Accesible: " + (metro.getAccesibleDiscapacidad() ? "Sí" : "No")
            );
        } else if (transporte instanceof Autobus) {
            Autobus autobus = (Autobus) transporte;
            return new DatosTransporte(
                    autobus.getNombre(),
                    autobus.getDescripcion(),
                    autobus.getCondiciones(),
                    "Autobus",
                    autobus.getCosto(),
                    "Número de Paradas: " + autobus.getNumeroParadas() +
                            ", Capacidad: " + autobus.getCapacidad() +
                            ", Horario: " + autobus.getHorario() +
                            ", Precio: " + autobus.getPrecio() +
                            ", Accesible: " + (autobus.getAccesibleDiscapacidad() ? "Sí" : "No")
            );
        } else if (transporte instanceof Tren) {
            Tren tren = (Tren) transporte;
            return new DatosTransporte(
                    tren.getNombre(),
                    tren.getDescripcion(),
                    tren.getCondiciones(),
                    "Tren",
                    tren.getCosto(),
                    "Velocidad Máxima: " + tren.getVelocidadMaxima() +
                            ", Capacidad: " + tren.getCapacidad() +
                            ", Horario: " + tren.getHorario() +
                            ", Precio: " + tren.getPrecio() +
                            ", Accesible: " + (tren.getAccesibleDiscapacidad() ? "Sí" : "No")
            );
        } else if (transporte instanceof Coche) {
            Coche coche = (Coche) transporte;
            return new DatosTransporte(
                    coche.getNombre(),
                    coche.getDescripcion(),
                    coche.getCondiciones(),
                    "Coche",
                    coche.getCosto(),
                    "Tipo de Combustible: " + coche.getTipoCombustible() +
                            ", Número de Asientos: " + coche.getNumeroAsientos() +
                            ", Propietario: " + coche.getPropietario() +
                            ", Costo Mantenimiento: " + coche.getCostoMantenimiento() +
                            ", Licencia Requerida: " + (coche.getRequiereLicencia() ? "Sí" : "No")
            );
        } else if (transporte instanceof Moto) {
            Moto moto = (Moto) transporte;
            return new DatosTransporte(
                    moto.getNombre(),
                    moto.getDescripcion(),
                    moto.getCondiciones(),
                    "Moto",
                    moto.getCosto(),
                    "¿Es Eléctrica?: " + (moto.getEsElectrica() ? "Sí" : "No") +
                            ", Cilindrada: " + moto.getCilindrada() +
                            ", Propietario: " + moto.getPropietario() +
                            ", Costo Mantenimiento: " + moto.getCostoMantenimiento() +
                            ", Licencia Requerida: " + (moto.getRequiereLicencia() ? "Sí" : "No")
            );
        } else if (transporte instanceof Helicoptero) {
            Helicoptero helicoptero = (Helicoptero) transporte;
            return new DatosTransporte(
                    helicoptero.getNombre(),
                    helicoptero.getDescripcion(),
                    helicoptero.getCondiciones(),
                    "Helicoptero",
                    helicoptero.getCosto(),
                    "Autonomía de Vuelo: " + helicoptero.getAutonomiaVuelo() +
                            ", Capacidad: " + helicoptero.getCapacidad() +
                            ", Propietario: " + helicoptero.getPropietario() +
                            ", Costo Mantenimiento: " + helicoptero.getCostoMantenimiento() +
                            ", Licencia Requerida: " + (helicoptero.getRequiereLicencia() ? "Sí" : "No")
            );
        } else {
            throw new IllegalArgumentException("Tipo de transporte desconocido");
        }
    }
}

