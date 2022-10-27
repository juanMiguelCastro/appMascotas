package co.edu.uniempresarial.appmascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.edu.uniempresarial.appmascotas.vistas.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void entrar(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}