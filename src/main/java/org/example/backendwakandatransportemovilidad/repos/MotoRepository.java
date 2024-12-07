package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Moto m SET m.nombre = :#{#moto.nombre}, " +
            "m.descripcion = :#{#moto.descripcion}, " +
            "m.condiciones = :#{#moto.condiciones}, " +
            "m.costo = :#{#moto.costo}, " +
            "m.esElectrica = :#{#moto.esElectrica}, " +
            "m.cilindrada = :#{#moto.cilindrada} " +
            "WHERE m.id = :id")
    void updateTransporteById(Long id, Moto moto);
}

