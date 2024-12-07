package org.example.backendwakandatransportemovilidad.repos;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosTransporteRepository extends JpaRepository<DatosTransporte, Long> {

}
