package dominio;

public class Usuario {
    private String nombre;
    private String rut;
    private String correoElectronico;
    private String contrasena;

    public Usuario(String nombre, String rut, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.rut = rut;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void imprimir(){
        System.out.println("NOMBRE: " + this.nombre + " " + "RUT:" + this.rut);
    }
}
