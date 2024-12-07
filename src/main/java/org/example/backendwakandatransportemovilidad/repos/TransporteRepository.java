package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Transporte t SET t.nombre = :#{#transporte.nombre}, " +
            "t.descripcion = :#{#transporte.descripcion}, " +
            "t.condiciones = :#{#transporte.condiciones}, " +
            "t.costo = :#{#transporte.costo} " +
            "WHERE t.id = :id")
    void updateTransporteById(Long id, Transporte transporte);

}
