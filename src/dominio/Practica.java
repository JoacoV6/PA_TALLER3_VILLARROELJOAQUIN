package dominio;

public class Practica extends Oferta{
    private String fechaInicio;
    private String empresaSolicitante;
    private String nombreGuia;
    private boolean poseeRemuneracion;

    public Practica(String codigoIdentificador, String titulo, String descripcion, int duracion, String nombreUnidad, String fechaInicio, String empresaSolicitante, String nombreGuia, boolean poseeRemuneracion) {
        super(codigoIdentificador, titulo, descripcion, duracion, nombreUnidad);
        this.fechaInicio = fechaInicio;
        this.empresaSolicitante = empresaSolicitante;
        this.nombreGuia = nombreGuia;
        this.poseeRemuneracion = poseeRemuneracion;
    }
}
