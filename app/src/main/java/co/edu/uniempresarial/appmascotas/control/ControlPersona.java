package co.edu.uniempresarial.appmascotas.control;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import co.edu.uniempresarial.appmascotas.DAO.PersonaDAO;
import co.edu.uniempresarial.appmascotas.MainActivity;
import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.vistas.MisMascotas;

public class ControlPersona {
    private final String Base_URL = "https://apimascota.herokuapp.com/items/";
    private Persona persona;
    public String mensaje;
    private Context context;

    public ControlPersona(Persona persona){
        this.persona = persona;
    }

    public void registrar(Context context, View view){
        PersonaDAO personaDAO = new PersonaDAO(context,view);
        boolean val = personaDAO.insertUser(persona);
        if(val){
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
        /*
        System.out.println("--------------------------------PETICION----------------------------------");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaService personaService = retrofit.create(PersonaService.class);
         Call<String> respuesta = personaService.getPersonaCreate(persona);
         respuesta.enqueue(new Callback<String>() {
             @Override
             public void onResponse(Call<String> call, Response<String> response) {
                 System.out.println("--------------------------------SIII 1----------------------------------");
                 if(response.isSuccessful()){
                     System.out.println("--------------------------------SIII 2----------------------------------");
                     mensaje = response.body();
                     Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
                 }
             }

             @Override
             public void onFailure(Call<String> call, Throwable t) {
                 System.out.println("--------------------------------NOOOO----------------------------------");

             }
         });*/
    }

    public void Login(Context context, View view){
        PersonaDAO personaDAO = new PersonaDAO(context,view);
        boolean val = personaDAO.Login(persona.getDocumentoId(),persona.getPass());
        if(val){
            Toast.makeText(context, "Bienvenid@", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, MisMascotas.class);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "el numero de identificacion o contraseña son incorrectos", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
        /*
        System.out.println("--------------------------------PETICION----------------------------------");
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaService personaService = retrofit.create(PersonaService.class);
        Call<RespLogin> respuesta = personaService.getLogin(persona.getDocumentoId(),persona.getPass());
        respuesta.enqueue(new Callback<RespLogin>() {
            @Override
            public void onResponse(Call<RespLogin> call, Response<RespLogin> response) {
                System.out.println("--------------------------------SIII 1----------------------------------");
                System.out.println("response: "+ response.code());
                System.out.println("response: "+ response.body());
                if(response.isSuccessful()){
                    System.out.println("--------------------------------SIII 2----------------------------------");

                    reDirigir(response.body().getResp());
                }else{
                    System.out.println("--------------------------------NO 2----------------------------------" + response.errorBody().toString());
                    Toast.makeText(context,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RespLogin> call, Throwable t) {
                System.out.println("--------------------------------NOOOO 1----------------------------------");
            }
        });
    }
    public void reDirigir(boolean conf){
        Toast.makeText(context, "llegoo", Toast.LENGTH_SHORT).show();
        if(conf){
            Intent intent = new Intent(this.context, MisMascotas.class);
            this.context.startActivity(intent);
        }else{
            Intent intent = new Intent(this.context, MainActivity.class);
            this.context.startActivity(intent);

        }
*/
    }
}
