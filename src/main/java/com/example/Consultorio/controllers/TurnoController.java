package com.example.Consultorio.controllers;

import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class TurnoController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<TurnoModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public TurnoModel guardarUsuario(@RequestBody TurnoModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

}
