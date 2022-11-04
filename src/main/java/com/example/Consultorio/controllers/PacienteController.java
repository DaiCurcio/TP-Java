package com.example.Consultorio.controllers;

import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.PacienteRepository;
import com.example.Consultorio.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @Autowired
    PacienteRepository pacienteRepository;

    // cuando llega una peticion get, lo ejecuta y trae el paciente
    @GetMapping() //para leer
    public ArrayList<PacienteModel> obtenerTodosLosPacientes(){
        return pacienteService.obtenerTodosLosPacientes();
    }
    // llamar y guardar el paciente
    @PostMapping() //para crear
    public PacienteModel guardarPaciente(@RequestBody PacienteModel paciente){
        return pacienteRepository.save(paciente);    }

    @PutMapping("{id_paciente}")
    public ResponseEntity<PacienteModel> updatePaciente(@PathVariable int id_paciente, @RequestBody PacienteModel paciente) {
        PacienteModel updatePaciente = pacienteRepository.findAllById(id_paciente);
        updatePaciente.setNombre(paciente.getNombre());
        updatePaciente.setApellido(paciente.getApellido());
        updatePaciente.setFechaTurno(paciente.getFechaTurno());
        pacienteRepository.save(updatePaciente);
        return ResponseEntity.ok(updatePaciente);
    }
}
