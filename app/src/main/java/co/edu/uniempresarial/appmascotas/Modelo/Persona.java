
package co.edu.uniempresarial.appmascotas.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Persona implements Serializable {

    @SerializedName("idPersona")
    @Expose
    private Integer idPersona;
    @SerializedName("documentoId")
    @Expose
    private String documentoId;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("whatsapp")
    @Expose
    private String whatsapp;
    @SerializedName("longitud")
    @Expose
    private String longitud;
    @SerializedName("latitud")
    @Expose
    private String latitud;



    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

}
 class ListaPersona {

    @SerializedName("items")
    @Expose
    private List<Persona> items = null;

    public List<Persona> getItems() {
        return items;
    }

    public void setItems(List<Persona> items) {
        this.items = items;
    }

}