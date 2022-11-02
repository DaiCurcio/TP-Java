package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.services.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//indica donde se activan los metodos
@RequestMapping("/Dentista")
public class DentistaController {
    @Autowired
    DentistaService dentistaService;

    // cuando llega una peticion get, lo ejecuta y trae el dentista
    @GetMapping()
    public ArrayList<DentistaModel> obtenerTodosLosDentistas(){
        return dentistaService.obtenerTodosLosDentistas();
    }

    // llamar y guardar el dentista
    @PostMapping()
    public DentistaModel guardarDentista(@RequestBody DentistaModel dentista){
        return this.dentistaService.guardarDentista(dentista);
    }
}
