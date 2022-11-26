package com.example.Consultorio.reporte;
import com.example.Consultorio.models.TurnoModel;
import java.io.*;
import java.util.ArrayList;


public class CrearArchivo {
    public static void main(String[] args) throws IOException {
        ArrayList<TurnoModel> LeerListaDeTurnos = new ArrayList<>();
        String nombreFichero = "Reporte.txt";
        
            File f = new File(nombreFichero);
            if (!f.exists()) f.createNewFile();

            DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

            for (TurnoModel turnoModel: LeerListaDeTurnos){
                dos.writeInt(turnoModel.getId());
                dos.writeInt(turnoModel.getId_dentista());
                dos.writeInt(turnoModel.getId_paciente());
                System.out.println(LeerListaDeTurnos);
            }
            dos.close();
    }

}
