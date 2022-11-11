package com.example.Consultorio.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turno")
public class TurnoModel {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_turno;
    private LocalDate date;
    private LocalTime time;

    //relaciones con paciente y dentista
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", referencedColumnName="id_paciente")
    private PacienteModel pacienteModel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentista", referencedColumnName="id_dentista")
    private DentistaModel dentistaModel;

    public TurnoModel() {
    }

   /* public TurnoModel(Integer id_turno, LocalDate date, LocalTime time, PacienteModel pacienteModel, DentistaModel dentistaModel) {
        this.id_turno = id_turno;
        this.date = date;
        this.time = time;
        this.pacienteModel = pacienteModel;
        this.dentistaModel = dentistaModel;
    }*/

    public Integer getId_turno() {
        return id_turno;
    }

    public void setId_turno(Integer id_turno) {
        this.id_turno = id_turno;
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

    public PacienteModel getPacienteModel() {
        return pacienteModel;
    }

    public void setPacienteModel(PacienteModel pacienteModel) {
        this.pacienteModel = pacienteModel;
    }

    public DentistaModel getDentistaModel() {
        return dentistaModel;
    }

    public void setDentistaModel(DentistaModel dentistaModel) {
        this.dentistaModel = dentistaModel;
    }
}
