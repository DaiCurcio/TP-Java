package com.example.Consultorio.services;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    public ArrayList<PacienteModel> LeerListaDePacientes() {
        return (ArrayList<PacienteModel>)pacienteRepository.findAll();
    }

    public PacienteModel createPaciente(PacienteModel Paciente) {return pacienteRepository.save(new PacienteModel());
    }

    public PacienteModel updatePaciente(PacienteModel paciente) {return pacienteRepository.save(paciente);
    }

    public PacienteModel deletePaciente(PacienteModel pacienteModel) {return pacienteRepository.save(pacienteModel);
    }
}
