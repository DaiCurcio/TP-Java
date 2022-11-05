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

    //LEER LISTA DE DENTISTAS
    public ArrayList<DentistaModel> LeerListaDeDentistas() {
        return (ArrayList<DentistaModel>)dentistaRepository.findAll();
    }

    // CREAR DENTISTA
    public DentistaModel createDentista(DentistaModel dentistaModel) {return dentistaRepository.save(dentistaModel);}

    //UPDATE DENTISTA
    public DentistaModel updateDentista(DentistaModel dentistaModel){return dentistaRepository.save(dentistaModel);}

    //DELETE DENTISTA
    public DentistaModel deleteDentista(DentistaModel dentistaModel){return dentistaRepository.save(dentistaModel);}

}
