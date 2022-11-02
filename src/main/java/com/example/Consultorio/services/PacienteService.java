package com.example.Consultorio.services;

import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    //obtener lista como array
    public ArrayList<PacienteModel> obtenerTodosLosPacientes(){
        return (ArrayList<PacienteModel>)pacienteRepository.findAll();
    }
    // recibir informacion y guardarla
    public PacienteModel guardarPaciente(PacienteModel paciente){
        return pacienteRepository.save(paciente);

    }

}
