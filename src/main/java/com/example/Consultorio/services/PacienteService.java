package com.example.Consultorio.services;

import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.PacienteRepository;
import com.example.Consultorio.services.Interfaces.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service //tipo
public class PacienteService implements IPacienteService
{
    @Autowired // instancia
    PacienteRepository pacienteRepository; //llama al repositorio

    public ArrayList<PacienteModel>LeerListaDePacientes()
    {
        return (ArrayList<PacienteModel>)pacienteRepository.findAll();
    }

    public PacienteModel createPaciente(PacienteModel pacienteModel)
    {
        Integer id = 0;
        List<Integer> pacientesID = (pacienteRepository
                .findAll()
                .stream().map(PacienteModel::getId_paciente).toList());
        int maxid = Collections.max(pacientesID) + 1;
        pacienteModel.setId_paciente(maxid);
        pacienteRepository.save(pacienteModel);
        return pacienteModel;
    }

    public PacienteModel updatePaciente(PacienteModel pacienteModel)
    {
        boolean existsPaciente = pacienteRepository
                .findAll()
                .stream()
                .filter(x -> x.getId_paciente() == (pacienteModel.getId_paciente()))
                .count() == 1;
        if(!existsPaciente)
        {
            return null;
        }
        pacienteRepository.save(pacienteModel);
        return pacienteModel;
    }

    public PacienteModel deletePaciente(Integer pacienteModel)
    {
        pacienteRepository.deleteById(pacienteModel);
        return null;
    }
}
