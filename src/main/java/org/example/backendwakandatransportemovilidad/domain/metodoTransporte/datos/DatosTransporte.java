package org.example.backendwakandatransportemovilidad.domain.metodoTransporte.datos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.domain.metodoTransporte.Transporte;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "datos_transporte")
@Entity
public class DatosTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String condiciones;
    @Column
    private String tipo;
    @Column
    private Double costo;
    @Column
    private String detallesExtra;

    @ManyToOne
    @JoinColumn(name = "transporte_id", nullable = false)
    private Transporte transporte;

    public DatosTransporte(String nombre, String descripcion, String condiciones, String tipo, Double costo, String detallesExtra) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condiciones = condiciones;
        this.tipo = tipo;
        this.costo = costo;
        this.detallesExtra = detallesExtra;
    }
}
