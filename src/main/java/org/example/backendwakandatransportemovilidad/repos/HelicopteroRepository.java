package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Helicoptero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HelicopteroRepository extends JpaRepository<Helicoptero, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Helicoptero h SET h.nombre = :#{#helicoptero.nombre}, " +
            "h.descripcion = :#{#helicoptero.descripcion}, " +
            "h.condiciones = :#{#helicoptero.condiciones}, " +
            "h.costo = :#{#helicoptero.costo}, " +
            "h.autonomiaVuelo = :#{#helicoptero.autonomiaVuelo}, " +
            "h.capacidad = :#{#helicoptero.capacidad}, " +
            "h.propietario = :#{#helicoptero.propietario}, " +
            "h.costoMantenimiento = :#{#helicoptero.costoMantenimiento}, " +
            "h.requiereLicencia = :#{#helicoptero.requiereLicencia} " +
            "WHERE h.id = :id")
    void updateTransporteById(Long id, Helicoptero helicoptero);
}
