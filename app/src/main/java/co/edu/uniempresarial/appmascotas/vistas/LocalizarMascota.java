package co.edu.uniempresarial.appmascotas.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import co.edu.uniempresarial.appmascotas.R;

public class LocalizarMascota extends AppCompatActivity {
    private TextView idMascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar_mascota);
        idMascota = findViewById(R.id.idMascota);
        String id= getIntent().getStringExtra("codigo");
        idMascota.setText(id);
    }
}