package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Moto extends TransportePrivado {

    @Column(nullable = false)
    private Boolean esElectrica;

    @Column(nullable = false)
    private Integer cilindrada;
}
