package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.publico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;

@Entity
@Table(name = "transportes_publicos")
@Getter
@Setter
public abstract class TransportePublico extends Transporte {

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Boolean accesibleDiscapacidad;
}
