package co.edu.uniempresarial.appmascotas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uniempresarial.appmascotas.Modelo.Mascota;
import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.controlMascota;

public class editarMascota extends AppCompatActivity {
    private Mascota mascota;
    private EditText nombre, especie, raza, comida;
    private String idPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);
        mascota = (Mascota) getIntent().getSerializableExtra("mascota");
        idPersona = (String) getIntent().getSerializableExtra("persona");
        begin();
        llenarCampos();
    }
    public void begin(){
        nombre=findViewById(R.id.txtEditNombreMascota);
        especie=findViewById(R.id.txtEditEspecie);
        raza=findViewById(R.id.txtEditRaza);
        comida=findViewById(R.id.txtEditTipoComida);
    }
    public void llenarCampos(){
        nombre.setText(mascota.getNombre());
        especie.setText(mascota.getEspecie());
        raza.setText(mascota.getRaza());
        comida.setText(mascota.getTipoComida());
    }
    public void btnGenerarQr(View view){
        Intent intent = new Intent(this,GenerarQR.class);
        intent.putExtra("idMascota",mascota.getIdMascota());
        startActivity(intent);
    }
    public void btnModificar(View view){
        mascota.setNombre(nombre.getText().toString());
        mascota.setEspecie(especie.getText().toString());
        mascota.setRaza(raza.getText().toString());
        mascota.setTipoComida(comida.getText().toString());
        System.out.println("----------"+mascota.getIdMascota());
        controlMascota controlMascota = new controlMascota(mascota,this,view);
        boolean val=controlMascota.actualizarMascota();
        if(val){
            Toast.makeText(this, "Se ha modificado correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No se ha podio modificar", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnEliminar(View view){
        System.out.println("----------"+mascota.getIdMascota());
        controlMascota controlMascota = new controlMascota(mascota,this,view);
        boolean val=controlMascota.eliminarMascota();
        if(val){
            Toast.makeText(this, "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
            btnAtras(view);
        }else{
            Toast.makeText(this, "No se ha podio eliminado", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnAtras(View view){
        Intent intent = new Intent(this,MisMascotas.class);
        intent.putExtra("documentoId", idPersona);
        startActivity(intent);
    }


}