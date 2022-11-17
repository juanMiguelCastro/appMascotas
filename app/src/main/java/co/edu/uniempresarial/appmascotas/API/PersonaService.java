package co.edu.uniempresarial.appmascotas.API;

import co.edu.uniempresarial.appmascotas.Modelo.Persona;
import co.edu.uniempresarial.appmascotas.Modelo.RespLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PersonaService {
    @POST("persona/create.php")
    Call<String> getPersonaCreate(@Body Persona persona);


    @POST("persona/login.php")
    @FormUrlEncoded
    Call<RespLogin> getLogin(@Field("documentoId") String documentoId, @Field("pass") String pass);

}
