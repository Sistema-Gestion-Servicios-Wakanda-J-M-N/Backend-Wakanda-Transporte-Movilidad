package org.example.backendwakandatransportemovilidad.repos;

import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

}
