package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Metro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroRepository extends JpaRepository<Metro, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Metro m SET m.nombre = :#{#metro.nombre}, " +
            "m.descripcion = :#{#metro.descripcion}, " +
            "m.condiciones = :#{#metro.condiciones}, " +
            "m.costo = :#{#metro.costo}, " +
            "m.horario = :#{#metro.horario}, " +
            "m.precio = :#{#metro.precio}, " +
            "m.accesibleDiscapacidad = :#{#metro.accesibleDiscapacidad}, " +
            "m.numeroLineas = :#{#metro.numeroLineas}, " +
            "m.capacidadMaxima = :#{#metro.capacidadMaxima} " +
            "WHERE m.id = :id")
    void updateTransporteById(Long id, Metro metro);
}

