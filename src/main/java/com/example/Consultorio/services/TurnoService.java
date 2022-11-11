package com.example.Consultorio.services;

import com.example.Consultorio.models.TurnoModel;

import com.example.Consultorio.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository turnoRepository;

    public ArrayList<TurnoModel> LeerListaDeTurnos() { return (ArrayList<TurnoModel>) turnoRepository.findAll();
    }
    public TurnoModel createTurno(TurnoModel turnoModel) { return turnoRepository.save(turnoModel);
    }

    public TurnoModel updateTurno(TurnoModel turnoModel) {return turnoRepository.save(turnoModel);
    }
    public TurnoModel deleteTurno(TurnoModel turnoModel) {return turnoRepository.save(turnoModel);
    }
}
