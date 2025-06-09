package dominio;

public class Capstone extends Oferta{
    private String fechaInicio;
    private String nombreEmpresaSolicitante;
    private String nombreGuia;
    private String tipoProyecto;
    private int duracionMeses;
    private String carrerasNecesarias;
    private int cantidadMinimaEstudiantes;

    public Capstone(String codigoIdentificador, String titulo, String descripcion, int duracion, String nombreUnidad, String fechaInicio, String nombreEmpresaSolicitante, String nombreGuia, String tipoProyecto, int duracionMeses, String carrerasNecesarias, int cantidadMinimaEstudiantes) {
        super(codigoIdentificador, titulo, descripcion, duracion, nombreUnidad);
        this.fechaInicio = fechaInicio;
        this.nombreEmpresaSolicitante = nombreEmpresaSolicitante;
        this.nombreGuia = nombreGuia;
        this.tipoProyecto = tipoProyecto;
        this.duracionMeses = duracionMeses;
        this.carrerasNecesarias = carrerasNecesarias;
        this.cantidadMinimaEstudiantes = cantidadMinimaEstudiantes;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getNombreEmpresaSolicitante() {
        return nombreEmpresaSolicitante;
    }

    public String getNombreGuia() {
        return nombreGuia;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public String getCarrerasNecesarias() {
        return carrerasNecesarias;
    }

    public int getCantidadMinimaEstudiantes() {
        return cantidadMinimaEstudiantes;
    }
}
