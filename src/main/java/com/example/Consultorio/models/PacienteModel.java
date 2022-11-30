package com.example.Consultorio.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity  //clase
@Table(name = "paciente")  //url
public class PacienteModel {
    //atributos
    @Id  //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremental

    //atributos
    private int id_paciente;
    private String nombre;
    private String apellido;
    private String fechaTurno = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());

     //constructor
    public PacienteModel(Integer id_paciente, String nombre, String apellido, String fechaTurno, Set<TurnoModel> turno) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaTurno = fechaTurno;
    }
    //constructor vacio
    public PacienteModel() {

    }
    //getter and setter
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
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

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
