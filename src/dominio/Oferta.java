package dominio;

public class Oferta {
    private String codigoIdentificador;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String nombreUnidad;

    public Oferta(String codigoIdentificador, String titulo, String descripcion, int duracion, String nombreUnidad) {
        this.codigoIdentificador = codigoIdentificador;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nombreUnidad = nombreUnidad;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void imprimir(){
        System.out.println("ID: " + this.codigoIdentificador);
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }
}
