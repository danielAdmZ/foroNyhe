package com.nyhestudios.foroNyhe.foroNyhe.controller;


import com.nyhestudios.foroNyhe.foroNyhe.topico.*;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.Usuario;
import com.nyhestudios.foroNyhe.foroNyhe.usuario.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class topicoController {

    @Autowired
    public TopicoRepository topicoRepository;

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listarTopicos(@PageableDefault(size = 2) Pageable pageable){

        return ResponseEntity.ok(topicoRepository.findByStatusTrue(pageable).map(DatosListadoTopicos::new));
    }

    @PostMapping
    @Transactional
    public  ResponseEntity registarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        //Guardar el autor aqui

            Topico topico = new Topico(datosRegistroTopico);
            topicoRepository.saveAndFlush(topico);
            AgregarUsuario(topico);

       //
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detallesTopico(@PathVariable Long id){
       Optional<DatosListadoTopicos> datosListadoTopicos =  topicoRepository.findById(id).map(DatosListadoTopicos::new);
       if (datosListadoTopicos.isPresent()){
          // System.out.println(datosListadoTopicos.get().autor());
           return ResponseEntity.ok(datosListadoTopicos.get());
       }else {
           return ResponseEntity.notFound().build();
       }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()){
           Topico finalTopico = topico.get();
           finalTopico.ActualizarTopico(datosActualizarTopico);
           topicoRepository.save(finalTopico);
           return ResponseEntity.accepted().build();
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            Topico finalTopico = topico.get();
            topicoRepository.delete(finalTopico);
            return ResponseEntity.accepted().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    private void AgregarUsuario(Topico topico){
        var prueba = httpServletRequest.getHeader("USER");
        Optional<Usuario> usuario = usuarioRepository.findById(Long.valueOf(prueba));

        try {
            topico.setAutor(usuario.get());
            topicoRepository.save(topico);
        }catch (Exception e){
            System.out.println("El usuario no se a encontrado");
            topicoRepository.delete(topico);
        }
    }
}
