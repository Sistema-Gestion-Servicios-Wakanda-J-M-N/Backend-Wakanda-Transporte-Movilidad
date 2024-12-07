package org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.privado;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.backendwakandatransportemovilidad.model.metodoTransporteDTO.TransporteDTO;

@Getter
@Setter
public class TransportePrivadoDTO extends TransporteDTO {

    @NotNull
    private String propietario;

    @NotNull
    private Double costoMantenimiento;

    @NotNull
    private Boolean requiereLicencia;
}

