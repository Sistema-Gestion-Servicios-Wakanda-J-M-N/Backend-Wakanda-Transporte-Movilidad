package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutobusDTO extends TransportePublicoDTO {

    @NotNull
    private Integer numeroParadas;

    @NotNull
    private Integer capacidad;
}

