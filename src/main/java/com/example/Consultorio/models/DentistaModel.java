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
    private Long id_dentista;

    private String nombre;
    private String apellido;
    private int matricula;

    //relacion con turnos
    //@OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    private Set<TurnoModel> turno = new HashSet<>();

    public DentistaModel() {
    }

    //constructor

    public DentistaModel(Long id_dentista, String nombre, String apellido, int matricula, Set<TurnoModel> turno) {
        this.id_dentista = id_dentista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turno = turno;
    }

    public Long getId_dentista() {
        return id_dentista;
    }

    public void setId_dentista(Long id_dentista) {
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Set<TurnoModel> getTurno() {
        return turno;
    }

    public void setTurno(Set<TurnoModel> turno) {
        this.turno = turno;
    }
}
