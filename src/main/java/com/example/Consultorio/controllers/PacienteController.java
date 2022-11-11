package com.example.Consultorio.controllers;
import com.example.Consultorio.models.PacienteModel;
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
    public PacienteModel createPaciente(@RequestBody PacienteModel pacienteModel){
        return this.pacienteService.createPaciente(pacienteModel);
    }
    @PutMapping("{id_paciente}") //UPDATE
    public PacienteModel updatePaciente(@PathVariable int id_paciente, @RequestBody PacienteModel pacienteModel){
        pacienteService.updatePaciente(pacienteModel).setId_paciente(pacienteModel.getId_paciente());
        pacienteService.updatePaciente(pacienteModel).setFechaTurno(pacienteModel.getFechaTurno());
        pacienteService.updatePaciente(pacienteModel).setApellido(pacienteModel.getApellido());
        pacienteService.updatePaciente(pacienteModel).setNombre(pacienteModel.getNombre());
        pacienteService.updatePaciente(pacienteModel).setTurno(pacienteModel.getTurno());
        return this.pacienteService.updatePaciente(pacienteModel);
    }

    @DeleteMapping("{id_paciente}") //DELETE
    public PacienteModel deletePaciente(@PathVariable int id_paciente){
        PacienteModel pacienteModel = pacienteRepository.findById(id_paciente).orElseThrow();
        pacienteRepository.delete(pacienteModel);
        return this.pacienteService.deletePaciente(pacienteModel);
    }


}
