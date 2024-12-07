package org.example.backendwakandatransportemovilidad.repos;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Helicoptero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelicopteroRepository extends JpaRepository<Helicoptero, Long> {

}
