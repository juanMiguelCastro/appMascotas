package co.edu.uniempresarial.appmascotas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uniempresarial.appmascotas.MainActivity;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.R;

public class Registro extends AppCompatActivity{

    public Persona persona =  new Persona();
    private EditText documento, nombre, apellido, contraseña1, contraseña2, whatsapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        init();
    }
    public void init(){
        documento=findViewById(R.id.txtDocumento);
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        contraseña1=findViewById(R.id.txtPass1);
        contraseña2=findViewById(R.id.txtPass2);
        whatsapp=findViewById(R.id.txtWhatsapp);
    }
    public boolean validar(){
        boolean confirmacion=false;
        if(documento.getText().toString() != "" && nombre.getText().toString() != "" && apellido.getText().toString() != "" && contraseña1.getText().toString() != "" && contraseña2.getText().toString() != "" && whatsapp.getText().toString() != ""){
            String pass1, pass2;
            pass1=contraseña1.getText().toString();
            pass2=contraseña2.getText().toString();
            if(pass1.equals(pass2)){
                confirmacion=true;
            }else{
                Toast.makeText(this, "las contraseñas no coinciden pass1:'"+pass1+"' pass2:'"+pass2+"'", Toast.LENGTH_LONG).show();
                confirmacion=false;
            }
        }else{
        }

        return confirmacion;
    }
    public void btnSiguiente(View view){
        if(validar()){
            //if(persona.getLatitud() != null && persona.getLongitud()!=null){
                persona.setDocumentoId(documento.getText().toString());
                persona.setNombre(nombre.getText().toString());
                persona.setApellido(apellido.getText().toString());
                persona.setPass(contraseña1.getText().toString());
                persona.setWhatsapp(whatsapp.getText().toString());
                Intent intent = new Intent(this, maps.class);
                intent.putExtra("persona",persona);
                startActivity(intent);
           // }else{
           //     Toast.makeText(this, "no hay ubicacion", Toast.LENGTH_SHORT).show();
            //}
        }else{
            Toast.makeText(this, "campos invalidos", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnvolver(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}