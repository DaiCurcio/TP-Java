package com.example.Consultorio.controllers;

import com.example.Consultorio.models.DentistaModel;
import com.example.Consultorio.repositories.DentistaRepository;
import com.example.Consultorio.services.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public DentistaModel createDentista(@RequestBody DentistaModel dentista){
        return this.dentistaService.createDentista(dentista);
    }
    @PutMapping("{id_dentista}") //UPDATE
    public DentistaModel updateDentista(@PathVariable int id_dentista, @RequestBody DentistaModel dentista){
        dentistaService.updateDentista(dentista).setId_dentista(dentista.getId_dentista());
        dentistaService.updateDentista(dentista).setMatricula(dentista.getMatricula());
        dentistaService.updateDentista(dentista).setApellido(dentista.getApellido());
        dentistaService.updateDentista(dentista).setNombre(dentista.getNombre());
        dentistaService.updateDentista(dentista).setTurno(dentista.getTurno());
        return this.dentistaService.updateDentista(dentista);
    }

    @DeleteMapping("{id_dentista}") //DELETE
    public DentistaModel deleteDentista(@PathVariable int id_dentista){
        DentistaModel dentista = dentistarepo.findById(id_dentista).orElseThrow();
        dentistarepo.delete(dentista);
        return this.dentistaService.deleteDentista(dentista);
    }


}
