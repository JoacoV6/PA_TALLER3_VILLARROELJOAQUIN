package sistema;

    /**
     * Interfaz que define las operaciones principales del sistema UCN.
     * Contiene métodos para gestionar usuarios y ofertas académicas.
     */
    public interface SistemaUCN {

        /**
         * Registra un nuevo usuario solicitando sus datos por consola.
         */
        void registrarUsuario();

        /**
         * Permite iniciar sesión solicitando rut y contraseña.
         *
         * @return true si el inicio de sesión fue exitoso, false si falló
         */
        boolean iniciarSesion();

        /**
         * Muestra la información del perfil del usuario actualmente autenticado.
         */
        void verPerfil();

        /**
         * Cierra la sesión del usuario actualmente autenticado.
         */
        void cerrarSesion();

        /**
         * Permite al usuario editar su nombre y correo electrónico.
         */
        void editarPerfil();

        /**
         * Permite ingresar una nueva oferta académica (Ayudantía, Capstone o Práctica).
         */
        void IngresarOferta();

        /**
         * Carga ofertas académicas desde un archivo de texto.
         */
        void cargarOfertas();

        /**
         * Muestra todas las ofertas académicas almacenadas.
         */
        void verOfertas();

        /**
         * Elimina una oferta académica utilizando su código identificador.
         */
        void eliminarOferta();

        /**
         * Permite editar los datos principales de una oferta existente.
         */
        void editarOferta();
    }


