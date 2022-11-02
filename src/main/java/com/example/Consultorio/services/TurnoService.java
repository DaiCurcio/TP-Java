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

    //obtener lista como array
    public ArrayList<TurnoModel> obtenerTodosLosTurnos(){
        return (ArrayList<TurnoModel>)turnoRepository.findAll();
    }
    //recibir informacion y guardarla
    public TurnoModel guardarTurno(TurnoModel turno){
        return turnoRepository.save(turno);
    }

}
