package co.edu.uniempresarial.appmascotas.vistas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.uniempresarial.appmascotas.DAO.PersonaDAO;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.R;

public class MisMascotas extends AppCompatActivity {
    private ListView listaMascotas;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_mascotas);
        listaMascotas = findViewById(R.id.lsMascotas);
        persona = (Persona) getIntent().getSerializableExtra("persona");
        userList();
    }
    private void userList(){
        PersonaDAO personaDAO = new PersonaDAO(this,listaMascotas);
        ArrayList<String> userArrayList = personaDAO.getUserList();
        System.out.println(userArrayList);
        ArrayAdapter<Persona> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,userArrayList);
        listaMascotas.setAdapter(adapter);
    }
}