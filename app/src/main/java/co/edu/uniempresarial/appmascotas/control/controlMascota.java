package co.edu.uniempresarial.appmascotas.control;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import co.edu.uniempresarial.appmascotas.DAO.MascotaDAO;
import co.edu.uniempresarial.appmascotas.DAO.PersonaDAO;
import co.edu.uniempresarial.appmascotas.Modelo.Mascota;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.vistas.MisMascotas;

public class controlMascota {
    private Mascota mascota;
    private Persona persona;
    public String mensaje;
    private Context context;
    private  View view;

    public controlMascota(){}
    public controlMascota(Mascota mascota, Context context, View view){
        this.mascota = mascota;
        this.context=context;
        this.view= view;
    }
    public controlMascota(String id){
        persona = new Persona();
        persona.setDocumentoId(id);
    }
    /*public listaMascotas(Mascota mascota){
        this.mascota = mascota;
    }*/


    public void registrar(Context context) {
        PersonaDAO person = new PersonaDAO(context);
        int id=person.recuperarId(mascota.getDueño());
        mascota.setDueño(id);
        MascotaDAO mascotaDAO = new MascotaDAO(context,view);
        System.out.println("-----------------------"+mascota);
        boolean val = mascotaDAO.insertPet(mascota);
        if (val) {
            Intent intent = new Intent(context, MisMascotas.class);
            intent.putExtra("documentoId",persona.getDocumentoId());
            context.startActivity(intent);
        }
    }
    public ArrayList<Mascota> buscarMascotas(Context context){
        MascotaDAO mascotaDAO = new MascotaDAO(context,view);
        ArrayList<Mascota> mascotas;
        mascotas = mascotaDAO.getMascotaList(persona.getDocumentoId());
        return mascotas;
    }
}
