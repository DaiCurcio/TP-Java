package com.example.Consultorio.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "paciente")
public class PacienteModel {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paciente;

    private String nombre;
    private String apellido;
    private String fechaTurno = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());

    // Relacion con turno
    @OneToMany(fetch = FetchType.LAZY)
    private Set<TurnoModel> turno = new HashSet<>();

   /* public PacienteModel() {
    }

    public PacienteModel(int id_paciente, String nombre, String apellido, String fechaTurno, Set<TurnoModel> turno) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaTurno = fechaTurno;
        this.turno = turno;
 */

    public Integer getId_paciente() {
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

    public Set<TurnoModel> getTurno() {
        return turno;
    }

    public void setTurno(Set<TurnoModel> turno) {
        this.turno = turno;
    }
}
