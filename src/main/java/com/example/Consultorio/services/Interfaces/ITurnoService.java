package com.example.Consultorio.services.Interfaces;

import com.example.Consultorio.models.TurnoModel;

import java.util.ArrayList;

public interface ITurnoService
{
    public ArrayList<TurnoModel> LeerListaDeTurnos();
    public TurnoModel createTurno(TurnoModel turnoModel);
    public TurnoModel updateTurno(TurnoModel turnoModel);
    public TurnoModel deleteTurno(int turnoModel);
}
