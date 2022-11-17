package co.edu.uniempresarial.appmascotas.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ManageDB extends SQLiteOpenHelper {
    private static final String DATA_BASE_USER = "dbUsers";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE_PERSONA ="create table persona(\n" +
            "    idPersona INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    documentoId varchar(100),\n" +
            "    nombre varchar(100),\n" +
            "    apellido varchar(100),\n" +
            "    contraseña varchar(100),\n" +
            "    whatsapp varchar(50),\n" +
            "    longitud varchar(200),\n" +
            "    latitud varchar(200)\n" +
            ");";

    private static final String CREATE_TABLE_MASCOTA ="create table mascota(\n" +
            "    idMascota INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    dueño int,\n" +
            "    nombre varchar(100),\n" +
            "    especie varchar(100),\n" +
            "    raza varchar(100),\n" +
            "    estado varchar(10),\n" +
            "    longitud varchar(200),\n" +
            "    latitud varchar(200),\n" +
            "    tipoComida varchar(100),\n" +
            "    FOREIGN KEY (dueño) REFERENCES persona(idPersona)\n" +
            ");";

    private static final String CREATE_TABLE_VACUNA ="create table vacunas(\n" +
            "    idVacuna INTEGER PRIMARY KEY  AUTOINCREMENT,\n" +
            "    idMascota int,\n" +
            "    nombreVacuna varchar(100),\n" +
            "    FOREIGN KEY (idMascota) REFERENCES mascota(idMascota)\n" +
            ");";

    private static final String DELETE_TABLE_PERSONA="DROP TABLE IF EXISTS persona";
    private static final String DELETE_TABLE_VACUNA="DROP TABLE IF EXISTS vacuna";
    private static final String DELETE_TABLE_MASCOTA="DROP TABLE IF EXISTS mascota";

    public ManageDB(Context context){super(context, DATA_BASE_USER, null, VERSION);}


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSONA);
        sqLiteDatabase.execSQL(CREATE_TABLE_MASCOTA);
        sqLiteDatabase.execSQL(CREATE_TABLE_VACUNA);
        Log.i("DATABASE","se crearon las tablas: personas, mascotas, vacuna");
        System.out.println("se creo la tabla: personas, mascotas, vacuna");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE_PERSONA);
        sqLiteDatabase.execSQL(DELETE_TABLE_MASCOTA);
        sqLiteDatabase.execSQL(DELETE_TABLE_VACUNA);

        onCreate(sqLiteDatabase);
    }

}
