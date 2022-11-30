package com.example.Consultorio.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity //clase
@Table(name = "dentista") //tabla
public class DentistaModel {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremental
    //atributos
    private int id_dentista;
    private String nombre;
    private String apellido;
    private Integer matricula;
     //constructor
    public DentistaModel(int id_dentista, String nombre, String apellido, Integer matricula) {
        this.id_dentista = id_dentista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    //constructor vacio
    public DentistaModel() {
    }
     // getters and setters
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

}
