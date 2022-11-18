package co.edu.uniempresarial.appmascotas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.uniempresarial.appmascotas.Modelo.Mascota;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.controlMascota;

public class MisMascotas extends AppCompatActivity {
    private ListView listaMascotas;
    TextView mensajeVacio;
    private Persona persona;
    private String idPersona;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_mascotas);
        listaMascotas = findViewById(R.id.lsMascotas);
        mensajeVacio=findViewById(R.id.lblMensaje);
        idPersona = (String) getIntent().getSerializableExtra("documentoId");
        userList();
    }
    private void userList(){
        intent = new Intent(this,editarMascota.class);
        controlMascota controlMascota = new controlMascota(idPersona);
        ArrayList<Mascota> petArrayList = controlMascota.buscarMascotas(this);
        System.out.println(petArrayList);
        if(petArrayList.get(0).getNombre()!=null){
            ArrayAdapter<Mascota> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,petArrayList);
            listaMascotas.setAdapter(adapter);
            listaMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Mascota pet = (Mascota) listaMascotas.getItemAtPosition(position);
                    System.out.println("---------------ITEM"+pet);
                    intent.putExtra("mascota",pet);
                    intent.putExtra("persona",idPersona);
                    startActivity(intent);
                }
            });
        }else{

            mensajeVacio.setText("No tiene mascotas registradas");
            listaMascotas.setEmptyView(mensajeVacio);

        }

    }

    public AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            System.out.println("---------------ITEM"+listaMascotas.getItemAtPosition(position));
            Mascota mascota = (Mascota) listaMascotas.getItemAtPosition(position);
            intent.putExtra("mascota",mascota);
            startActivity(intent);
        }
    };
    public void btnRegistrar(View view){
        Intent intent = new Intent(this, RegistroMascotas.class);
        intent.putExtra("documentoId",idPersona);
        startActivity(intent);
    }

}