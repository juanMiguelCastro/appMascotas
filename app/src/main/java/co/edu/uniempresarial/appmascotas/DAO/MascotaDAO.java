package co.edu.uniempresarial.appmascotas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import co.edu.uniempresarial.appmascotas.Modelo.Mascota;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;

public class MascotaDAO {
    private ManageDB manageDB;
    Context context;
    View view;
    Mascota mascota;
    Persona persona
    public MascotaDAO(Context context, View view) {
        this.context = context;
        this.view = view;
        this.manageDB = new ManageDB(context);

    }
    public boolean insertUser(Mascota pet) {
        boolean valInsert;
        try {
            SQLiteDatabase db = manageDB.getWritableDatabase();
            if (db != null) {
                ContentValues values = new ContentValues();
                values.put("idMascota", pet.getIdMascota());
                values.put("dueño", pet.getDocumentoId());
                values.put("nombre", pet.getNombre());
                values.put("especie", pet.getPass());
                values.put("raza", pet.getWhatsapp());
                values.put("longitud", pet.getLatitud());
                values.put("latitud", pet.getLongitud());
                values.put("tipoComida", pet.getLongitud());
                Long cod = db.insert("persona", null, values);
                Snackbar.make(this.view, "Se ha registrado satisfactoriamente" + cod, Snackbar.LENGTH_LONG).show();
                Log.i("DATABASE", "Se ha registrado satisfactoriamente");
                System.out.println("Se ha registrado satisfactoriamente");
                valInsert = true;
            } else {
                Snackbar.make(this.view, "Ha habido un error, no se ha podido registrar", Snackbar.LENGTH_LONG).show();
                valInsert = false;
            }
        } catch (Exception e) {
            Log.i("Error", "" + e);
            valInsert = false;
        }
    }
}
