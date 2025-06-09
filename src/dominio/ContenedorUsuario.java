package dominio;

public class ContenedorUsuario {
    private int cantidadMaxima;
    private Usuario[] usuarios;
    private int cantidadActual;

    public ContenedorUsuario(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.usuarios = new Usuario[cantidadMaxima];
        this.cantidadActual = 0;
    }

    public boolean agregar(Usuario usuario) {
        if (this.cantidadActual < cantidadMaxima) {
            usuarios[cantidadActual] = usuario;
            cantidadActual++;
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(String rut) {
        int posicion = -1;
        for (int i = 0; i < this.cantidadActual; i++) {
            if (this.usuarios[i].getRut().equals(rut)) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            for (int i = posicion + 1; i < cantidadActual; i++) {
                this.usuarios[i - 1] = usuarios[i];
            }
            this.usuarios[this.cantidadActual - 1] = null;
            this.cantidadActual--;
            return true;
        } else {
            return false;
        }
    }

    public int obtenerPosicion(String rut) {
        for (int i = 0; i < this.cantidadActual; i++) {
            Usuario usuario = this.usuarios[i];
            if (usuario.getRut().equals(rut)) {
                return i;
            }
        }
        return -1;
    }

    public Usuario obtenerElemento(int i) {
        if (i >= 0 && i < cantidadActual) {
            return this.usuarios[i];
        }
        return null;
    }

    public Usuario buscarUsuarioPorRut(String rut) {
        for (int i = 0; i < this.cantidadActual; i++) {
            Usuario usuario = this.usuarios[i];
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }
}

