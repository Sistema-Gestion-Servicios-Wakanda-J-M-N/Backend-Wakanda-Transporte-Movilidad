package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.publico;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.TransporteDTO;

@Getter
@Setter
public class TransportePublicoDTO extends TransporteDTO {

    @NotNull
    private String horario;

    @NotNull
    private Double precio;

    @NotNull
    private Boolean accesibleDiscapacidad;
}
