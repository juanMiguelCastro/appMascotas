package co.edu.uniempresarial.appmascotas.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespLogin {
    @SerializedName("message")
    @Expose
    private boolean message;

    public boolean getResp() {
        return message;
    }

    public void setResp(boolean resp) {
        this.message = resp;
    }
}
