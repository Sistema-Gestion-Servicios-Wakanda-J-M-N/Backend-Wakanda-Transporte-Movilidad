package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotoDTO extends TransportePrivadoDTO {

    @NotNull
    private Boolean esElectrica;

    @NotNull
    private Integer cilindrada;
}
