package org.example.backendwakandatransportemovilidad.repos;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.TransportePrivado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportePrivadoRepository extends JpaRepository<TransportePrivado, Long> {

}
