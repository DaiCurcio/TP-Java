package com.example.Consultorio.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity //clase
@Table(name = "turno") //tabla
public class TurnoModel {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremental
    //atributos
    private Integer id;
    private Integer id_dentista;
    private Integer id_paciente;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    //constructor
    public TurnoModel() {
    }
      //constructor
    public TurnoModel(LocalDate date, LocalTime time, Integer id_dentista, Integer id_paciente) {
        this.date = date;
        this.time = time;
        this.id_dentista = id_dentista;
        this.id_paciente = id_paciente;
    }
     //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_dentista() {
        return id_dentista;
    }

    public void setId_dentista(Integer id_dentista) {
        this.id_dentista = id_dentista;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
