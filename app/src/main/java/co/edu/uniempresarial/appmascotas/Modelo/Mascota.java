package co.edu.uniempresarial.appmascotas.Modelo;

public class Mascota {
    private int idMascota;
    private int dueño;
    private String nombre;
    private String especie;
    private String raza;
    private String estado;
    private String longitud;
    private String latitud;
    private String tipoComida;

    public Mascota(){}
    public Mascota(int idMascota, int dueño, String nombre, String especie, String raza, String estado, String longitud, String latitud, String tipoComida) {
        this.idMascota = idMascota;
        this.dueño = dueño;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.estado = estado;
        this.longitud = longitud;
        this.latitud = latitud;
        this.tipoComida = tipoComida;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getDueño() {
        return dueño;
    }

    public void setDueño(int dueño) {
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + idMascota +
                ", dueño='" + dueño + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", estado='" + estado + '\'' +
                ", longitud='" + longitud + '\'' +
                ", latitud='" + latitud + '\'' +
                ", tipoComida='" + tipoComida + '\'' +
                '}';
    }
}
