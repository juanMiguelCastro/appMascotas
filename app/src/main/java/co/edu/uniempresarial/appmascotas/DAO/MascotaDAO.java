package co.edu.uniempresarial.appmascotas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniempresarial.appmascotas.Modelo.Mascota;

public class MascotaDAO {
    private ManageDB manageDB;
    Context context;
    View view;
    Mascota mascota;
    public MascotaDAO(Context context,View view) {
        this.context = context;
        this.view = view;
        this.manageDB = new ManageDB(context);

    }
    public boolean insertPet(Mascota pet) {
        boolean valInsert;
        try {
            SQLiteDatabase db = manageDB.getWritableDatabase();
            if (db != null) {
                System.out.println("------------------"+pet);
                ContentValues values = new ContentValues();
                values.put("dueño", pet.getDueño());
                values.put("nombre", pet.getNombre());
                values.put("especie", pet.getEspecie());
                values.put("raza", pet.getRaza());
                values.put("estado", pet.getEstado());
                values.put("longitud", pet.getLongitud());
                values.put("latitud", pet.getLatitud());
                values.put("tipoComida", pet.getTipoComida());
                Long cod = db.insert("mascota", null, values);
                Snackbar.make(this.view, "Se ha registrado satisfactoriamente" + cod, Snackbar.LENGTH_LONG).show();
                Log.i("DATABASE", "Se ha registrado satisfactoriamente");
                System.out.println("Se ha registrado satisfactoriamente");
                System.out.println("---"+pet.getEstado()+"----"+values.get("estado"));

                valInsert = true;
            } else {
                Snackbar.make(this.view, "Ha habido un error, no se ha podido registrar", Snackbar.LENGTH_LONG).show();
                valInsert = false;
            }
        } catch (Exception e) {
            Log.i("Error", "" + e);
            valInsert = false;
        }
        return valInsert;
    }
    public ArrayList<Mascota> getMascotaList(String id){
        SQLiteDatabase db=manageDB.getReadableDatabase();
        //String query ="select * from mascota where dueño="+id;
        String query ="SELECT mascota.idMascota,mascota.dueño, mascota.nombre, mascota.especie ,mascota.raza, mascota.estado, mascota.longitud, mascota.latitud, mascota.tipoComida FROM persona LEFT JOIN mascota ON mascota.dueño = persona.idPersona where persona.documentoId="+id+" ORDER BY idMascota";

        java.util.ArrayList<Mascota> petList = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                mascota = new Mascota();
                mascota.setIdMascota(cursor.getInt(0));
                mascota.setDueño(cursor.getInt(1));
                mascota.setNombre(cursor.getString(2));
                mascota.setEspecie(cursor.getString(3));
                mascota.setRaza(cursor.getString(4));
                mascota.setEstado(cursor.getString(5));
                mascota.setLongitud(cursor.getString(6));
                mascota.setLatitud(cursor.getString(7));
                mascota.setTipoComida(cursor.getString(8));
                petList.add(mascota);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return petList;
    }

    public List<String> getMascotaInfo(String id){
        SQLiteDatabase db=manageDB.getReadableDatabase();
        String query ="SELECT mascota.idMascota, mascota.dueño, mascota.nombre, mascota.especie ,mascota.raza, mascota.estado, mascota.longitud, mascota.latitud, mascota.tipoComida, persona.whatsapp, persona.longitud, persona.latitud FROM persona INNER JOIN mascota ON mascota.dueño = persona.idPersona where  mascota.idMascota="+id;
        List<String> petList = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            petList.add(Integer.toString(cursor.getInt(0)));
            petList.add(Integer.toString(cursor.getInt(1)));
            for(int i=2;i<=11;i++){
                petList.add(cursor.getString(i));
            }
        }
        cursor.close();
        db.close();
        return petList;
    }
    public boolean updatePet(Mascota pet) {
        boolean valUpdate;
        System.out.println("---1");
        try {
            SQLiteDatabase db = manageDB.getWritableDatabase();
            System.out.println("---2");

            if (db != null) {
                System.out.println("---3");

                System.out.println("----------pet"+pet.getIdMascota());
                ContentValues values = new ContentValues();
                values.put("nombre", pet.getNombre());
                values.put("especie", pet.getEspecie());
                values.put("raza", pet.getRaza());
                values.put("estado", pet.getEstado());
                values.put("tipoComida", pet.getTipoComida());
                String id= Integer.toString(pet.getIdMascota());
                System.out.println("--------------------------------"+id);
                Long cod = Long.valueOf(db.update("mascota",values,"idMascota = ?",new String[]{id}));
                Snackbar.make(this.view, "Se ha registrado satisfactoriamente" + cod, Snackbar.LENGTH_LONG).show();
                Log.i("DATABASE", "Seha registrado satisfactoriamente");


                valUpdate = true;
            } else {
                Log.i("DATABASE ERROR", "NO se ha registrado satisfactoriamente");

                Snackbar.make(this.view, "Ha habido un error, no se ha podido actualizar", Snackbar.LENGTH_LONG).show();
                valUpdate = false;
            }
        } catch (Exception e) {
            Log.i("Error ii", "" + e);
            valUpdate = false;
        }
        return valUpdate;
    }
    public boolean deletePet(Mascota pet) {
        boolean valDelete;
        try {
            SQLiteDatabase db = manageDB.getWritableDatabase();
            if (db != null) {
                System.out.println("----------pet"+pet.getIdMascota());
                String id= Integer.toString(pet.getIdMascota());
                System.out.println("--------------------------------"+id);
                Long cod = Long.valueOf(db.delete("mascota","idMascota = ?",new String[]{id}));
                Snackbar.make(this.view, "Se ha eliminado satisfactoriamente" + cod, Snackbar.LENGTH_LONG).show();
                Log.i("DATABASE", "Se ha eliminado satisfactoriamente");
                valDelete = true;
            } else {
                Log.i("DATABASE ERROR", "Ha habido un error, no se ha podido eliminado\"");

                Snackbar.make(this.view, "Ha habido un error, no se ha podido eliminado", Snackbar.LENGTH_LONG).show();
                valDelete = false;
            }
        } catch (Exception e) {
            Log.i("Error ii", "" + e);
            valDelete = false;
        }
        return valDelete;
    }
}
