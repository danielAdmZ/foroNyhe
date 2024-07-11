package com.nyhestudios.foroNyhe.foroNyhe.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
       @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        Boolean status
) {
}
