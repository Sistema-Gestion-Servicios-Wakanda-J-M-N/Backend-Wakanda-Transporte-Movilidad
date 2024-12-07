package org.example.backendwakandatransportemovilidad.repos;

import jakarta.transaction.Transactional;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.TransportePublico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportePublicoRepository extends JpaRepository<TransportePublico, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE TransportePublico t SET t.nombre = :#{#transporte.nombre}, " +
            "t.descripcion = :#{#transporte.descripcion}, " +
            "t.condiciones = :#{#transporte.condiciones}, " +
            "t.costo = :#{#transporte.costo}, " +
            "t.horario = :#{#transporte.horario}, " +
            "t.precio = :#{#transporte.precio}, " +
            "t.accesibleDiscapacidad = :#{#transporte.accesibleDiscapacidad} " +
            "WHERE t.id = :id")
    void updateTransporteById(Long id, TransportePublico transporte);
}
