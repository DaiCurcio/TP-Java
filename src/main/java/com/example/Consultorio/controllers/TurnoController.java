package com.example.Consultorio.controllers;

import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Turno")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    // cuando llega una peticion get, lo ejecuta y trae el turno
    @GetMapping() //es para leer
    public ArrayList<TurnoModel> obtenerTodosLosTurnos(){
        return turnoService.obtenerTodosLosTurnos();
    }
    // llamar y guardar el turno
    @PostMapping() // es para crear uno nuevo
    public TurnoModel guardarTurno(@RequestBody TurnoModel turno) {
        return this.turnoService.guardarTurno(turno);


    }

}
