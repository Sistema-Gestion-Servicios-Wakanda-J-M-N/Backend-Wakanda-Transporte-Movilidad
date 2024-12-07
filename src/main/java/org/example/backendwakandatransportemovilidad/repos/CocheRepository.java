package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Coche c SET c.nombre = :#{#coche.nombre}, " +
            "c.descripcion = :#{#coche.descripcion}, " +
            "c.condiciones = :#{#coche.condiciones}, " +
            "c.costo = :#{#coche.costo}, " +
            "c.tipoCombustible = :#{#coche.tipoCombustible}, " +
            "c.numeroAsientos = :#{#coche.numeroAsientos} " +
            "WHERE c.id = :id")
    void updateTransporteById(Long id, Coche coche);
}
