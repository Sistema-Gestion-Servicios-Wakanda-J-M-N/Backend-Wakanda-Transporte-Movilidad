package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Tren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenRepository extends JpaRepository<Tren, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Tren t SET t.nombre = :#{#tren.nombre}, " +
            "t.descripcion = :#{#tren.descripcion}, " +
            "t.condiciones = :#{#tren.condiciones}, " +
            "t.costo = :#{#tren.costo}, " +
            "t.horario = :#{#tren.horario}, " +
            "t.precio = :#{#tren.precio}, " +
            "t.accesibleDiscapacidad = :#{#tren.accesibleDiscapacidad}, " +
            "t.velocidadMaxima = :#{#tren.velocidadMaxima}, " +
            "t.capacidad = :#{#tren.capacidad} " +
            "WHERE t.id = :id")
    void updateTransporteById(Long id, Tren tren);
}
