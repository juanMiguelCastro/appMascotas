package co.edu.uniempresarial.appmascotas.vistas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uniempresarial.appmascotas.Modelo.Mascota;
import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.controlMascota;

public class RegistroMascotas extends AppCompatActivity {
    EditText nombre, especie, raza, comida;
    private String idPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascotas);
        idPersona = (String) getIntent().getSerializableExtra("documentoId");
        begin();

    }
    private void begin(){
        nombre=findViewById(R.id.txtNombreMascota);
        especie=findViewById(R.id.txtEspecie);
        raza=findViewById(R.id.txtRaza);
        comida=findViewById(R.id.txtTipoComida);
    }
    public void btnRegistroPet(View view){
        int idDueño = Integer.parseInt(idPersona);
        Mascota mascota= new Mascota();
        mascota.setNombre(nombre.getText().toString());
        mascota.setRaza(raza.getText().toString());
        mascota.setEspecie(especie.getText().toString());
        mascota.setTipoComida(comida.getText().toString());
        mascota.setLatitud("0");
        mascota.setLongitud("0");
        mascota.setEstado("1");
        mascota.setDueño(idDueño);

        controlMascota controlMascota = new controlMascota(mascota, this, view);
        controlMascota.registrar(this);
    }
}