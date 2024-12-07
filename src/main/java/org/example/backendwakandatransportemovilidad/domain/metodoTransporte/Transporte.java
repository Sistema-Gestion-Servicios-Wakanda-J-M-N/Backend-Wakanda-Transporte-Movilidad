package org.example.backendwakandatransportemovilidad.domain.metodoTransporte;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos.DatosTransporte;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "transportes")
@Getter
@Setter
public abstract class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String condiciones;

    @Column(nullable = false)
    private Double costo;

    @OneToMany(mappedBy = "transporte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosTransporte> datosTransporte;
}
