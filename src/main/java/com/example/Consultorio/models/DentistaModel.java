package com.example.Consultorio.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentista")
public class DentistaModel {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dentista;

    private String nombre;
    private String apellido;
    private Integer matricula;

    // relacion con turnos
    @OneToMany(fetch = FetchType.LAZY)
    private Set<TurnoModel> turno = new HashSet<>();

    public DentistaModel() {
    }

    //constructor

   /* public DentistaModel(int id_dentista, String nombre, String apellido, Integer matricula, Set<TurnoModel> turno) {
        this.id_dentista = id_dentista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turno = turno;
    } */

    public int getId_dentista() {
        return id_dentista;
    }

    public void setId_dentista(int id_dentista) {
        this.id_dentista = id_dentista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<TurnoModel> getTurno() {
        return turno;
    }

    public void setTurno(Set<TurnoModel> turno) {
        this.turno = turno;
    }
}
