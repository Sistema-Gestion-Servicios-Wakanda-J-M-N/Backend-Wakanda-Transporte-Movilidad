package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransporteDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @NotNull
    @Size(max = 500)
    private String descripcion;

    @NotNull
    @Size(max = 255)
    private String condiciones;

    @NotNull
    private Double costo;
}
