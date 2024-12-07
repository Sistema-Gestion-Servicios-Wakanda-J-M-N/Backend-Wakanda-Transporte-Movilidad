package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrenDTO extends TransportePublicoDTO {

    @NotNull
    private Integer velocidadMaxima;

    @NotNull
    private Integer capacidad;
}

