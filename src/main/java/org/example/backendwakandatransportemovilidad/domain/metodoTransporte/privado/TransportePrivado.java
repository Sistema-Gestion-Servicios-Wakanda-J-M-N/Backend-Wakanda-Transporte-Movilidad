package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.privado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;

@Entity
@Table(name = "transportes_privados")
@Getter
@Setter
public abstract class TransportePrivado extends Transporte {

    @Column(nullable = false)
    private String propietario;

    @Column(nullable = false)
    private Double costoMantenimiento;

    @Column(nullable = false)
    private Boolean requiereLicencia;
}
