package com.nyhestudios.foroNyhe.foroNyhe.usuario;


import com.nyhestudios.foroNyhe.foroNyhe.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String email;
    private String contrasena;
    @OneToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public Usuario(DatosRegistarUsuario datosRegistarUsuario) {
        this.nombre = datosRegistarUsuario.nombre();
        this.email = datosRegistarUsuario.email();
        this.contrasena = datosRegistarUsuario.contrasena();
        this.perfil = null;

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}
