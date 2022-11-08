package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.DentistaRepository;
import com.example.Consultorio.repositories.PacienteRepository;
import com.example.Consultorio.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @Autowired
    PacienteRepository pacienteRepository;
    @GetMapping() //READ
    public ArrayList<PacienteModel> LeerListaDePacientes(){
        return pacienteService.LeerListaDePacientes();
    }

    @PostMapping() //CREATE
    public PacienteModel createPaciente(@RequestBody PacienteModel paciente){
        return this.pacienteService.createPaciente(paciente);
    }
    @PutMapping("{id_paciente}") //UPDATE
    public PacienteModel updatePaciente(@PathVariable int id_paciente, @RequestBody PacienteModel paciente){
        pacienteService.updatePaciente(paciente).setId_paciente(paciente.getId_paciente());
        pacienteService.updatePaciente(paciente).setFechaTurno(paciente.getFechaTurno());
        pacienteService.updatePaciente(paciente).setApellido(paciente.getApellido());
        pacienteService.updatePaciente(paciente).setNombre(paciente.getNombre());
        pacienteService.updatePaciente(paciente).setTurno(paciente.getTurno());
        return this.pacienteService.updatePaciente(paciente);
    }

    @DeleteMapping("{id_paciente}") //DELETE
    public PacienteModel deletePaciente(@PathVariable int id_paciente){
        PacienteModel pacienteModel = pacienteRepository.findById(id_paciente).orElseThrow();
        pacienteRepository.delete(pacienteModel);
        return this.pacienteService.deletePaciente(pacienteModel);
    }


}
