package co.edu.uniempresarial.appmascotas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import co.edu.uniempresarial.appmascotas.MainActivity;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.R;
import co.edu.uniempresarial.appmascotas.control.ControlPersona;

public class maps extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    GoogleMap mMap;
    Persona persona;
    EditText longitud, latitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        longitud = findViewById(R.id.txtLongitud);
        latitud = findViewById(R.id.txtLatitud);

        persona = (Persona) getIntent().getSerializableExtra("persona");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng colombia = new LatLng(4.6486259,-74.2478936);
        marcarUbicacion(colombia);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        latitud.setText("Latitud: "+latLng.latitude);
        longitud.setText("Longitud: "+latLng.longitude);
        persona.setLatitud(""+latLng.latitude);
        persona.setLongitud(""+latLng.longitude);
        mMap.clear();
        LatLng ubicacion = new LatLng(latLng.latitude,latLng.longitude);
        marcarUbicacion(ubicacion);

    }
    private void marcarUbicacion(LatLng ubicacion){
        mMap.addMarker(new MarkerOptions().position(ubicacion));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
    }
    public void btnVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void btnRegistrar(View view){
        if(persona.getLatitud() != null && persona.getLongitud()!=null){
            ControlPersona ctrlPersona= new ControlPersona(persona);
            ctrlPersona.registrar(this, view);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}