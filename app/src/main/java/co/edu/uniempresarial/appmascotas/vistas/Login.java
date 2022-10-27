package co.edu.uniempresarial.appmascotas.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.edu.uniempresarial.appmascotas.MainActivity;
import co.edu.uniempresarial.appmascotas.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void btnvolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}