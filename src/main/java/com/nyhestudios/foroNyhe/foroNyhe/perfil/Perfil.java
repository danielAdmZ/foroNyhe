package com.nyhestudios.foroNyhe.foroNyhe.perfil;

import com.nyhestudios.foroNyhe.foroNyhe.usuario.DatosRegistarUsuario;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Perfil")
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;

    public Perfil(Usuario usuario) {

        this.nombre = usuario.getNombre();
    }

    public Perfil(DatosRegistarUsuario datosRegistarUsuario) {

        this.nombre = datosRegistarUsuario.nombre();
    }

}
