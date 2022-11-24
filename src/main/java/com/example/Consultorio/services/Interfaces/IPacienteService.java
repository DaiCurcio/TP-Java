package com.example.Consultorio.services.Interfaces;

import com.example.Consultorio.models.PacienteModel;

import java.util.ArrayList;

public interface IPacienteService
{
    public ArrayList<PacienteModel> LeerListaDePacientes();
    public PacienteModel createPaciente(PacienteModel pacienteModel);
    public PacienteModel updatePaciente(PacienteModel pacienteModel);
    public PacienteModel deletePaciente(Integer pacienteModel);
}
