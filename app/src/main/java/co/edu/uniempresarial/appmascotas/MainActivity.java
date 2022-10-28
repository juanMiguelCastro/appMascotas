package co.edu.uniempresarial.appmascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import co.edu.uniempresarial.appmascotas.vistas.LocalizarMascota;
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
    public void scan(View view){
        IntentIntegrator integrador = new IntentIntegrator(MainActivity.this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrador.setPrompt("lector - CDP");
        integrador.setCameraId(0);//camara trasera
        integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.initiateScan();
    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        IntentResult result =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_LONG).show();
            }else{
                String resultado= result.getContents();
                Intent intent= new Intent(this, LocalizarMascota.class);
                intent.putExtra("codigo",resultado);
                startActivity(intent);
                Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}