package com.example.Consultorio.services;

import com.example.Consultorio.models.TurnoModel;
import com.example.Consultorio.repositories.TurnoRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service // llama al servicio donde esta el metodo
public class CrearArchivo implements Serializable
{
    @Autowired    //instancia el repositorio
    public TurnoRepository repo;
    public void main() throws IOException
    {    //lee la lista de turnos q la busca en el ropositorio
        List<TurnoModel> LeerListaDeTurnos =
                        repo.findAll();
        //nombre del txt
        String nombreFichero = "Reporte.txt";
         //crea un objeto fichero si no existe.
        File f = new File(nombreFichero);
        if (!f.exists()) f.createNewFile();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
        String newLine = System.getProperty("line.separator");
        //recorre la lista de turnos con las columnas q necesita como parametro y las obtiene
        for (TurnoModel p : LeerListaDeTurnos){
            dos.writeBytes(String.format("%s - %s - %s",
                    "ID", "ID de dentista", "ID de paciente"));
            dos.writeBytes(newLine);
            dos.writeBytes(String.format("%-10s%-10s%-10d",
                    p.getId(), p.getId_dentista(), p.getId_paciente()));
            dos.writeBytes(newLine);
        }

        dos.close();
    }
}
