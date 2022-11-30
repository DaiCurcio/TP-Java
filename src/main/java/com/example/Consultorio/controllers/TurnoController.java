package com.example.Consultorio.controllers;

import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.repositories.TurnoRepository;
import com.example.Consultorio.services.CrearArchivo;
import com.example.Consultorio.services.Interfaces.ITurnoService;
import com.example.Consultorio.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@RestController
@RequestMapping("/Turno") //url
public class TurnoController {
    @Autowired
    ITurnoService turnoService; //controller llama al servicio

    @Autowired
    public TurnoRepository turnosrepo; //servicio llama al repo

     //metodo de crear archivo
    public CrearArchivo ca;

    public TurnoController(CrearArchivo ca)
    {
        this.ca = ca;
    }
    @GetMapping() //READ
    public ArrayList<TurnoModel> LeerListaDeTurnos() throws IOException {
        ca.main();
        return turnoService.LeerListaDeTurnos();
    }
    @PostMapping() //CREATE
    public TurnoModel createTurno(@RequestBody TurnoModel turnoModel)
    {
        return this.turnoService.createTurno(turnoModel);
    }
    @PutMapping() //UPDATE
    public TurnoModel updateTurno(@RequestBody TurnoModel turnoModel)
    {
        return this.turnoService.updateTurno(turnoModel);
    }

    @DeleteMapping() //DELETE
    public TurnoModel deleteTurno(@RequestParam Integer id_turno)
    {
        return this.turnoService.deleteTurno(id_turno);
    }
}
