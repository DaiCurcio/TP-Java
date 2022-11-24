package com.example.Consultorio.services;

import com.example.Consultorio.models.TurnoModel;

import com.example.Consultorio.repositories.TurnoRepository;
import com.example.Consultorio.services.Interfaces.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TurnoService implements ITurnoService
{
    @Autowired
    TurnoRepository turnoRepository;

    public ArrayList<TurnoModel> LeerListaDeTurnos()
    {
        return (ArrayList<TurnoModel>) turnoRepository.findAll();
    }
    public TurnoModel createTurno(TurnoModel turnoModel)
    {
        Integer id = 0;
        List<Integer> pacientesID = (turnoRepository
                .findAll()
                .stream().map(TurnoModel::getId).toList());
        int maxid = Collections.max(pacientesID) + 1;
        turnoModel.setId(maxid);
        turnoRepository.save(turnoModel);
        return turnoRepository.save(turnoModel);
    }

    public TurnoModel updateTurno(TurnoModel turnoModel)
    {
        boolean existsPaciente = turnoRepository
                .findAll()
                .stream()
                .filter(x -> x.getId() == (turnoModel.getId()))
                .count() == 1;
        if(!existsPaciente)
        {
            return null;
        }
        return turnoRepository.save(turnoModel);
    }
    public TurnoModel deleteTurno(int turnoModel)
    {
        turnoRepository.deleteById(turnoModel);
        return null;
    }
}
