package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelicopteroDTO extends TransportePrivadoDTO {

    @NotNull
    private Integer autonomiaVuelo;

    @NotNull
    private Integer capacidad;
}

