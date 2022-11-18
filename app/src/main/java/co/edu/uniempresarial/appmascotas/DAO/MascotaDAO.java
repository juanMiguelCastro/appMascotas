package co.edu.uniempresarial.appmascotas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

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
        String query ="SELECT mascota.idMascota,mascota.dueño, mascota.nombre, mascota.especie ,mascota.raza, mascota.estado, mascota.longitud, mascota.latitud, mascota.tipoComida FROM persona LEFT JOIN mascota ON mascota.dueño = persona.idPersona ORDER BY idMascota";

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
}
