package co.edu.uniempresarial.appmascotas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import co.edu.uniempresarial.appmascotas.Modelo.Persona;

public class PersonaDAO {
    private ManageDB manageDB;
    Context context;
    View view;
    Persona persona;
    public PersonaDAO(Context context, View view) {
        this.context = context;
        this.view = view;
        this.manageDB = new ManageDB(context);
    }
    public PersonaDAO(Context context) {
        this.context = context;
        this.manageDB = new ManageDB(context);
    }
    public boolean insertUser(Persona myUser){
        boolean valInsert;
        try{
            SQLiteDatabase db=manageDB.getWritableDatabase();
            if(db != null){
                ContentValues values = new ContentValues();
                values.put("idPersona",myUser.getIdPersona());
                values.put("documentoId",myUser.getDocumentoId());
                values.put("nombre",myUser.getNombre());
                values.put("apellido",myUser.getApellido());
                values.put("contraseña",myUser.getPass());
                values.put("whatsapp",myUser.getWhatsapp());
                values.put("longitud",myUser.getLatitud());
                values.put("latitud",myUser.getLongitud());
                Long cod = db.insert("persona",null,values);
                Snackbar.make(this.view,"Se ha registrado satisfactoriamente"+cod,Snackbar.LENGTH_LONG).show();
                Log.i("DATABASE","Se ha registrado satisfactoriamente");
                System.out.println("Se ha registrado satisfactoriamente");
                valInsert=true;
            }else{
                Snackbar.make(this.view,"Ha habido un error, no se ha podido registrar",Snackbar.LENGTH_LONG).show();
                valInsert=false;
            }
        }catch(Exception e){
            Log.i("Error",""+e);
            valInsert=false;
        }
        return valInsert;
    }
    public boolean Login(String id, String pass){
        boolean val;
        SQLiteDatabase db=manageDB.getReadableDatabase();
        String query ="select documentoId, contraseña from persona where documentoId="+id+" and contraseña="+pass;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
           val=true;
        }else{
            val=false;
        }
        cursor.close();
        db.close();

        return val;
    }
    public ArrayList<String> getUserList(){
        SQLiteDatabase db=manageDB.getReadableDatabase();
        String query ="select documentoId, contraseña from persona";
        ArrayList<String> userList = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                persona = new Persona();
                persona.setDocumentoId(cursor.getString(0));
                persona.setPass(cursor.getString(1));
                String ss = cursor.getString(0) + " "+cursor.getString(1);
                userList.add(ss);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }
    public int recuperarId(int id){
        SQLiteDatabase db=manageDB.getReadableDatabase();
        String query ="select idPersona from persona where documentoId="+id;
        int idPersona=0;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            idPersona=cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return idPersona;
    }
}
