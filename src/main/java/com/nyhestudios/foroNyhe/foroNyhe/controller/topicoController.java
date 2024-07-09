package com.nyhestudios.foroNyhe.foroNyhe.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class topicoController {


    @GetMapping
    public ResponseEntity listarTopicos(){
        return ResponseEntity.ok("Prueba de topicos");
    }
}
