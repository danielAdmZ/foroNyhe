package com.nyhestudios.foroNyhe.foroNyhe.usuario;


import com.nyhestudios.foroNyhe.foroNyhe.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Usuario implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
