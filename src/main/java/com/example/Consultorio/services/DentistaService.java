package com.example.Consultorio.services;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.models.PacienteModel;
import com.example.Consultorio.repositories.DentistaRepository;
import com.example.Consultorio.services.Interfaces.IDentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service //tipo
public class DentistaService implements IDentistaService
{
    @Autowired //instancia
    DentistaRepository dentistaRepository; //servicio llama a repositorio

    //LEER LISTA DE DENTISTAS
    public ArrayList<DentistaModel> LeerListaDeDentistas()
    {
        return (ArrayList<DentistaModel>)dentistaRepository.findAll();
    }

    // CREAR DENTISTA
    public DentistaModel createDentista(DentistaModel dentistaModel)
    {
        Integer id = 0;
        List<Integer> dentistaID = (dentistaRepository
                .findAll()
                .stream().map(DentistaModel::getId_dentista).toList());
        int maxid = Collections.max(dentistaID) + 1;
        dentistaModel.setId_dentista(maxid);
        return dentistaRepository.save(dentistaModel);
    }

    //UPDATE DENTISTA
    public DentistaModel updateDentista(DentistaModel dentistaModel)
    {
        boolean existsDentista = dentistaRepository
                .findAll()
                .stream()
                .filter(x -> x.getId_dentista() == (dentistaModel.getId_dentista()))
                .count() == 1;
        if(!existsDentista)
        {
            return null;
        }
        return dentistaRepository.save(dentistaModel);
    }

    //DELETE DENTISTA
    public DentistaModel deleteDentista(int dentistaModel)
    {
        dentistaRepository.deleteById(dentistaModel);
        return null;
    }

}
