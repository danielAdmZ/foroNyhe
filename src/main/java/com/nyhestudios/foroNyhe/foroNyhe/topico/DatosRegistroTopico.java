package com.nyhestudios.foroNyhe.foroNyhe.topico;

import com.nyhestudios.foroNyhe.foroNyhe.perfil.Perfil;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
) {
}
