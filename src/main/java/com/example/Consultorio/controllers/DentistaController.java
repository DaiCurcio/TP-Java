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
        updateDentista().setId_dentista(dentista.getId_dentista());
        updateDentista().setMatricula(dentista.getMatricula());
        updateDentista().setApellido(dentista.getApellido());
        updateDentista().setNombre(dentista.getNombre());
        updateDentista().setTurno(dentista.getTurno());
        return this.dentistaService.updateDentista(dentista);
    }
       //cree esto para que me ande el update
    private DentistaModel updateDentista() {
        return null;
    }
    @DeleteMapping("{id_dentista}") //DELETE
    public DentistaModel deleteDentista(@PathVariable int id_dentista){
        DentistaModel dentista = DentistaRepository.findById(id_dentista);
        DentistaRepository.delete(dentista);
        return this.dentistaService.deleteDentista(dentista);
    }


}
