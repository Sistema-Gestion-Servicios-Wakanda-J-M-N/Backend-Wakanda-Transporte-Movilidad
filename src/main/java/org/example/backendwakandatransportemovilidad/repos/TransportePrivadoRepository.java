package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.TransportePrivado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportePrivadoRepository extends JpaRepository<TransportePrivado, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE TransportePrivado t SET t.nombre = :#{#transporte.nombre}, " +
            "t.descripcion = :#{#transporte.descripcion}, " +
            "t.condiciones = :#{#transporte.condiciones}, " +
            "t.costo = :#{#transporte.costo}, " +
            "t.propietario = :#{#transporte.propietario}, " +
            "t.costoMantenimiento = :#{#transporte.costoMantenimiento}, " +
            "t.requiereLicencia = :#{#transporte.requiereLicencia} " +
            "WHERE t.id = :id")
    default void updateTransporteById(Long id, TransportePrivado transporte) {

    }
}
