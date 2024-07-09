package com.nyhestudios.foroNyhe.foroNyhe.usuario;


import com.nyhestudios.foroNyhe.foroNyhe.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    @OneToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
