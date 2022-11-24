package com.example.Consultorio.services.Interfaces;

import com.example.Consultorio.models.DentistaModel;

import java.util.ArrayList;

public interface IDentistaService
{
    public ArrayList<DentistaModel> LeerListaDeDentistas();
    public DentistaModel createDentista(DentistaModel dentistaModel);
    public DentistaModel updateDentista(DentistaModel dentistaModel);
    public DentistaModel deleteDentista(int dentistaModel);

}
