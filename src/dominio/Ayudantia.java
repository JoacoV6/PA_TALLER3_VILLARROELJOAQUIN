package dominio;

public class Ayudantia extends Oferta{
    private String nombreAsignatura;
    private String rolAyudante;
    private int cantidadHorasSemanales;
    private double promedioMinimo;

    public Ayudantia(String codigoIdentificador, String titulo, String descripcion, int duracion, String nombreUnidad, String nombreAsignatura, int cantidadHorasSemanales, double promedioMinimo) {
        super(codigoIdentificador, titulo, descripcion, duracion, nombreUnidad);
        this.nombreAsignatura = nombreAsignatura;
        this.rolAyudante = rolAyudante;
        this.cantidadHorasSemanales = cantidadHorasSemanales;
        this.promedioMinimo = promedioMinimo;
    }
}
