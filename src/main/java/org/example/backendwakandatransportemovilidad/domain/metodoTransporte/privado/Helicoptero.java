package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Helicoptero extends TransportePrivado {

    @Column(nullable = false)
    private Integer autonomiaVuelo;

    @Column(nullable = false)
    private Integer capacidad;
}
