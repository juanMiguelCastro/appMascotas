package co.edu.uniempresarial.appmascotas.vistas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.controlMascota;

public class LocalizarMascota extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{
    private TextView nombre, especie, raza, comida, contacto;
    private double  longitude, latitude;
    GoogleMap mMap;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar_mascota);
        begin();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        id= getIntent().getStringExtra("codigo");
        llenarCampos();

    }
    public void begin(){
        nombre = findViewById(R.id.lblNombreMascota);
        especie = findViewById(R.id.lblEspecieMacota);
        raza = findViewById(R.id.lblRazaMascota);
        comida = findViewById(R.id.lblComidaMascota);
        contacto = findViewById(R.id.lblContacto);
    }
    public void llenarCampos(){
        controlMascota controlMascota = new controlMascota();
        List<String> mascota = controlMascota.encontrarMascota(this, id);
        nombre.setText(mascota.get(2));
        especie.setText(mascota.get(3));
        raza.setText(mascota.get(4));
        comida.setText(mascota.get(8));
        contacto.setText(mascota.get(9));
        System.out.println("-----------------------"+mascota);
        longitude= Double.parseDouble(mascota.get(10));
        latitude= Double.parseDouble(mascota.get(11));

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);
        System.out.println("-------------------------- ubicacion");
        LatLng ubicacion = new LatLng(longitude,latitude);
        mMap.addMarker(new MarkerOptions().position(ubicacion));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
}


    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

    }
}