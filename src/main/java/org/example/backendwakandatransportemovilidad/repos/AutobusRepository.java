package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobusRepository extends JpaRepository<Autobus, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Autobus a SET a.nombre = :#{#autobus.nombre}, " +
            "a.descripcion = :#{#autobus.descripcion}, " +
            "a.condiciones = :#{#autobus.condiciones}, " +
            "a.costo = :#{#autobus.costo}, " +
            "a.horario = :#{#autobus.horario}, " +
            "a.precio = :#{#autobus.precio}, " +
            "a.accesibleDiscapacidad = :#{#autobus.accesibleDiscapacidad}, " +
            "a.numeroParadas = :#{#autobus.numeroParadas}, " +
            "a.capacidad = :#{#autobus.capacidad} " +
            "WHERE a.id = :id")
    void updateTransporteById(Long id, Autobus autobus);
}
