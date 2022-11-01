package com.example.Consultorio.services;

import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository usuarioRepository;

    public ArrayList<TurnoModel> obtenerUsuarios(){
        return (ArrayList<TurnoModel>) usuarioRepository.findAll();
    }

    public TurnoModel guardarUsuario(TurnoModel usuario){
        return usuarioRepository.save(usuario);
    }
}
