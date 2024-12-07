package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetroDTO extends TransportePublicoDTO {

    @NotNull
    private Integer numeroLineas;

    @NotNull
    private Integer capacidadMaxima;
}
