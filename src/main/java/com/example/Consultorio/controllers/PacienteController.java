package com.example.Consultorio.controllers;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.PacienteRepository;
import com.example.Consultorio.services.Interfaces.IPacienteService;
import com.example.Consultorio.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Paciente") // url
public class PacienteController {
    @Autowired
    IPacienteService pacienteService; //llama al servicio

    @Autowired
    PacienteRepository pacienteRepository; //llama a repositorio
    @GetMapping() //READ
    public ArrayList<PacienteModel> LeerListaDePacientes()
    {
        return pacienteService.LeerListaDePacientes();
    }

    @PostMapping() //CREATE
    public PacienteModel createPaciente(@RequestBody PacienteModel pacienteModel)
    {
        return this.pacienteService.createPaciente(pacienteModel);
    }

    @PutMapping() //UPDATE
    public PacienteModel updatePaciente(@RequestBody PacienteModel pacienteModel)
    {
        return this.pacienteService.updatePaciente(pacienteModel);
    }

    @DeleteMapping() //DELETE
    public PacienteModel deletePaciente(@RequestParam Integer id)
    {
        return this.pacienteService.deletePaciente(id);
    }
}
