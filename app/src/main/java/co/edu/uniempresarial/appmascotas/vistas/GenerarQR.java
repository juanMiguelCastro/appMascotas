package co.edu.uniempresarial.appmascotas.vistas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import co.edu.uniempresarial.appmascotas.R;

public class GenerarQR extends AppCompatActivity {
    private ImageView imagenQr;
    private TextView mensaje;
    private Bitmap bitmap;
    private Activity activity;
    private int idMascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_qr);
        idMascota = (int) getIntent().getSerializableExtra("idMascota");
        imagenQr=findViewById(R.id.qrCode);
        mensaje=findViewById(R.id.lblid);
        mensaje.setText("mascota id: "+idMascota);
        generarQr();
    }
    public void generarQr(){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            String id= Integer.toString(idMascota);
             bitmap = barcodeEncoder.encodeBitmap(id, BarcodeFormat.QR_CODE,750,750);
            imagenQr.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void enviar(View view){
        activity = this;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.setPackage("com.whatsapp");
        String path = MediaStore.Images.Media.insertImage(view.getContext().getContentResolver(), bitmap, "QR", null);
        Uri imageUri = Uri.parse(path);
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        try {
            activity.startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            ex.printStackTrace();
            Snackbar.make(view, "El dispositivo no tiene instalado WhatsApp", Snackbar.LENGTH_LONG).show();
        }

    }
}