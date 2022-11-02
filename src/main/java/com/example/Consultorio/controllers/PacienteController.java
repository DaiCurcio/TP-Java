package com.example.Consultorio.controllers;

import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    // cuando llega una peticion get, lo ejecuta y trae el paciente
    @GetMapping() //para leer
    public ArrayList<PacienteModel> obtenerTodosLosPacientes(){
        return pacienteService.obtenerTodosLosPacientes();
    }
    // llamar y guardar el paciente
    @PostMapping() //para crear
    public PacienteModel guardarPaciente(@RequestBody PacienteModel paciente){
        return this.pacienteService.guardarPaciente(paciente);
    }
}
