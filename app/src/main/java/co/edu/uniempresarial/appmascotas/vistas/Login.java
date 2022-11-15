package co.edu.uniempresarial.appmascotas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uniempresarial.appmascotas.MainActivity;
import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.ControlPersona;

public class Login extends AppCompatActivity {
    EditText id, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id=findViewById(R.id.txtIdentificacion);
        pass=findViewById(R.id.txtPassword);
    }
    public void btnvolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void btnEntrar(View view){
        ControlPersona ctrlPersona= new ControlPersona(id.getText().toString(),pass.getText().toString());
        ctrlPersona.Login(this);
    }
}