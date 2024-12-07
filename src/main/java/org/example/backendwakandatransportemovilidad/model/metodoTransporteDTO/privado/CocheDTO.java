package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CocheDTO extends TransportePrivadoDTO {

    @NotNull
    private String tipoCombustible;

    @NotNull
    private Integer numeroAsientos;
}
