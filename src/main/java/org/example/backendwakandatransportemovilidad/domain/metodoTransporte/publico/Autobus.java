package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Autobus extends TransportePublico {

    @Column(nullable = false)
    private Integer numeroParadas;

    @Column(nullable = false)
    private Integer capacidad;
}
