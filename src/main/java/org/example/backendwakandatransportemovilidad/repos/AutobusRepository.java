package org.example.backendwakandatransportemovilidad.repos;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobusRepository extends JpaRepository<Autobus, Long> {

}
