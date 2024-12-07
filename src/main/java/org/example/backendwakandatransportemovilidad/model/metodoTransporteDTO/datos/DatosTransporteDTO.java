package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.datos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatosTransporteDTO {

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @NotNull
    private String condiciones;

    @NotNull
    private String tipo;

    @NotNull
    private Double costo;

    private String detallesExtra;

    private Long transporteId;
}

