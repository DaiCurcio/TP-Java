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
        updatePaciente().setId_paciente(paciente.getId_paciente());
        updatePaciente().setFechaTurno(paciente.getFechaTurno());
        updatePaciente().setApellido(paciente.getApellido());
        updatePaciente().setNombre(paciente.getNombre());
        updatePaciente().setTurno(paciente.getTurno());
        return this.pacienteService.updatePaciente(paciente);
    }
    //cree esto para que me ande el update
    private PacienteModel updatePaciente() {
        return null;
    }
    @DeleteMapping("{id_paciente}") //DELETE
    public PacienteModel deletePaciente(@PathVariable int id_paciente){
        PacienteModel pacienteModel = PacienteRepository.findById(id_paciente);
        pacienteRepository.delete(PacienteModel);
        return this.pacienteService.deletePaciente(pacienteModel);
    }


}
