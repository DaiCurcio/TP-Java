package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.repositories.TurnoRepository;
import com.example.Consultorio.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/Turno")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @Autowired
    public TurnoRepository turnosrepo;

    @GetMapping() //READ
    public ArrayList<TurnoModel> LeerListaDeTurnos(){
        return turnoService.LeerListaDeTurnos();
    }

    @PostMapping() //CREATE
    public TurnoModel createTurno(@RequestBody TurnoModel turnoModel){
        return this.turnoService.createTurno(turnoModel);
    }
    @PutMapping("/{id_turno}") //UPDATE
    public TurnoModel updateTurno(@PathVariable Integer id_turno, @RequestBody TurnoModel turnoModel){
        turnoService.updateTurno(turnoModel).setId_turno(turnoModel.getId_turno());
        turnoService.updateTurno(turnoModel).setDate(turnoModel.getDate());
        turnoService.updateTurno(turnoModel).setTime(turnoModel.getTime());
        turnoService.updateTurno(turnoModel).setDentistaModel(new DentistaModel());
        turnoService.updateTurno(turnoModel).setPacienteModel(new PacienteModel());
        return this.turnoService.updateTurno(turnoModel);
    }

    @DeleteMapping("/{id_turno}") //DELETE
    public TurnoModel deleteTurno(@PathVariable Integer id_turno) {
        TurnoModel turnoModel = turnosrepo.findById(id_turno).orElseThrow();
        turnosrepo.delete(turnoModel);
        return this.turnoService.deleteTurno(turnoModel);
    }

}
