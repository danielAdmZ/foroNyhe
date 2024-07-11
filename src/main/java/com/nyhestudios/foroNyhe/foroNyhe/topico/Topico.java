package com.nyhestudios.foroNyhe.foroNyhe.topico;


import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = true;
        this.autor = null;
    }

    public void ActualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.status = datosActualizarTopico.status();
    }
}
