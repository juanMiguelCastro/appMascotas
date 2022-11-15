package co.edu.uniempresarial.appmascotas.control;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import co.edu.uniempresarial.appmascotas.API.PersonaService;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControlPersona {
    private final String Base_URL = "https://apimascota.herokuapp.com/items/";
    private Persona persona;
    public String mensaje;
    public ControlPersona(String id, String pass ){
        this.persona = new Persona();
        this.persona.setDocumentoId(id);
        this.persona.setPass(pass);
    }
    public ControlPersona(Persona persona){
        this.persona = persona;
    }

    public void registrar(Context context){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaService personaService = retrofit.create(PersonaService.class);
         Call<String> respuesta = personaService.getPersonaCreate(persona);
         respuesta.enqueue(new Callback<String>() {
             @Override
             public void onResponse(Call<String> call, Response<String> response) {
                 if(response.isSuccessful()){
                     mensaje = response.body();
                     Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
                 }
             }

             @Override
             public void onFailure(Call<String> call, Throwable t) {

             }
         });
    }

    public void Login(Context context){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaService personaService = retrofit.create(PersonaService.class);
        Call<Boolean> respuesta = personaService.getLogin(persona.getDocumentoId(),persona.getPass());
        respuesta.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()){
                    Log.i(TAG, "----------------------post submitted to API 2 ." + response.body().toString());
                     if(response.body()){
                         Log.i(TAG, "---------------------post submitted to API." + response.body().toString());

                     }else{
                         Toast.makeText(context, "No coincide numero de identificacion o contraseña, por favor verifique", Toast.LENGTH_LONG).show();
                         Log.d("ControlPersona", "error loading from API");
                     }
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.d("ControlPersona", "---------------------post submitted to API.error loading from API");
            }
        });
    }

}
