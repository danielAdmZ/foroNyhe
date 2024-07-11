package com.nyhestudios.foroNyhe.foroNyhe.topico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoTopicos (
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        @JsonIgnore
        Usuario autor
) {


    public DatosListadoTopicos(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getAutor());
    }
}
