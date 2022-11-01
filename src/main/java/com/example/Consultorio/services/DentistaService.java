package com.example.Consultorio.services;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.repositories.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DentistaService {
    @Autowired
    DentistaRepository dentistaRepository;

    //obtener lista como array
    public ArrayList<DentistaModel> obtenerTodosLosDentistas(){
        return (ArrayList<DentistaModel>)dentistaRepository.finda();
    }

    // recibir informacion y guardarla
    public DentistaModel guardarDentista(DentistaModel dentistaModel){
        return dentistaRepository.save(dentistaModel);
    }

}
