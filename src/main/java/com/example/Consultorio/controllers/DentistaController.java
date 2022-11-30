package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.repositories.DentistaRepository;
import com.example.Consultorio.services.Interfaces.IDentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Dentista") // url
public class DentistaController {
    @Autowired
    IDentistaService dentistaService; //control llama al servicio

    @Autowired
    DentistaRepository dentistarepo; //servicio llama al repositorio

    @GetMapping() //READ
    public ArrayList<DentistaModel> LeerListaDeDentistas(){
        return dentistaService.LeerListaDeDentistas();
    }

    @PostMapping() //CREATE
    public DentistaModel createDentista(@RequestBody DentistaModel dentistaModel){
        return this.dentistaService.createDentista(dentistaModel);
    }
    @PutMapping() //UPDATE
    public DentistaModel updateDentista(@RequestBody DentistaModel dentistaModel)
    {
        return this.dentistaService.updateDentista(dentistaModel);
    }

    @DeleteMapping() //DELETE
    public DentistaModel deleteDentista(@RequestParam Integer id_dentista){
        return this.dentistaService.deleteDentista(id_dentista);
    }
}
