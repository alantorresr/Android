package Models;

/**
 * Created by alan9 on 17/09/2018.
 */

public class Persona {

    private  int IdPersona;
    private String Nombre;
    private String Apellidos;
    private int Foto;
    private String Escolaridad;

    public Persona(int id, String nombre, String apellidos, int foto){
        IdPersona = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Foto = foto;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int idPersona) {
        IdPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getEscolaridad() {
        return Escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        Escolaridad = escolaridad;
    }
}
