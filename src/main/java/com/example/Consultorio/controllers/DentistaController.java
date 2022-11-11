package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.repositories.DentistaRepository;
import com.example.Consultorio.services.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//indica donde se activan los metodos
@RequestMapping("/Dentista")
public class DentistaController {
    @Autowired
    DentistaService dentistaService;

    @Autowired
    DentistaRepository dentistarepo;

    // cuando llega una peticion get, lo ejecuta y trae el dentista
    @GetMapping() //READ
    public ArrayList<DentistaModel> LeerListaDeDentistas(){
        return dentistaService.LeerListaDeDentistas();
    }

    @PostMapping() //CREATE
    public DentistaModel createDentista(@RequestBody DentistaModel dentistaModel){
        return this.dentistaService.createDentista(dentistaModel);
    }
    @PutMapping("/{id_dentista}") //UPDATE
    public DentistaModel updateDentista(@PathVariable Integer id_dentista, @RequestBody DentistaModel dentistaModel){
        dentistaService.updateDentista(dentistaModel).setId_dentista(dentistaModel.getId_dentista());
        dentistaService.updateDentista(dentistaModel).setApellido(dentistaModel.getApellido());
        dentistaService.updateDentista(dentistaModel).setNombre(dentistaModel.getNombre());
        dentistaService.updateDentista(dentistaModel).setTurno(dentistaModel.getTurno());
        return this.dentistaService.updateDentista(dentistaModel);
    }

    @DeleteMapping("/{id_dentista}") //DELETE
    public DentistaModel deleteDentista(@PathVariable Integer id_dentista){
        DentistaModel dentistaModel = dentistarepo.findById(id_dentista).orElseThrow();
        dentistarepo.delete(dentistaModel);
        return this.dentistaService.deleteDentista(dentistaModel);
    }


}
