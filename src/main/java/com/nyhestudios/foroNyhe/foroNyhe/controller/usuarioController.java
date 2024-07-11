package com.nyhestudios.foroNyhe.foroNyhe.controller;

import com.nyhestudios.foroNyhe.foroNyhe.perfil.Perfil;
import com.nyhestudios.foroNyhe.foroNyhe.perfil.PerfilRepository;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.DatosRegistarUsuario;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    @PostMapping
    @Transactional
    public ResponseEntity registarUsuario(@RequestBody DatosRegistarUsuario datosRegistarUsuario){
        Usuario usuario = new Usuario(datosRegistarUsuario);
        usuarioRepository.saveAndFlush(usuario);
        AgregarPerfil(usuario);
        return ResponseEntity.ok().build();
    }

    private void AgregarPerfil(Usuario usuario){
        Perfil perfil   = new Perfil(usuario);
        usuario.setPerfil(perfil);
        perfilRepository.save(perfil);
        usuarioRepository.save(usuario);

    }

}
