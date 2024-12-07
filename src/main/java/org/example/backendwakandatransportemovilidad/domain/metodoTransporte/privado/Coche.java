package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Coche extends TransportePrivado {

    @Column(nullable = false)
    private String tipoCombustible;

    @Column(nullable = false)
    private Integer numeroAsientos;
}
