package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.repositories.PacienteRepository;
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

    @GetMapping() //READ
    public ArrayList<TurnoModel> LeerListaDeTurnos(){
        return turnoService.LeerListaDeTurnos();
    }

    @PostMapping() //CREATE
    public TurnoModel createTurno(@RequestBody TurnoModel turnoModel){
        return this.turnoService.createTurno(turnoModel);
    }
    @PutMapping("{id_turno}") //UPDATE
    public TurnoModel updateTurno(@PathVariable int id_turno, @RequestBody TurnoModel turnoModel){
        updateTurno().setId(turnoModel.getId());
        updateTurno().setDate(turnoModel.getDate());
        updateTurno().setTime(turnoModel.getTime());
        updateTurno().setDentistaModel(new DentistaModel());
        updateTurno().setPacienteModel(new PacienteModel());
        return this.turnoService.updateTurno(turnoModel);
    }

    @DeleteMapping("{id_turno}") //DELETE
    public TurnoModel deleteTurno(@PathVariable int id_turno) {
        TurnoModel turnoModel = TurnoRepository.findById(id_turno);
        TurnoRepository.delete(turnoModel);
        return this.turnoService.deleteTurno(turnoModel);
    }

}
