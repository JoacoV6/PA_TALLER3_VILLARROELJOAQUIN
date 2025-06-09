package sistema;

import dominio.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Implementación del sistema UCN que permite gestionar usuarios y ofertas académicas.
 * Incluye operaciones como registro, inicio de sesión, ingreso y edición de ofertas, entre otras.
 */
public class SistemaUCNImpl implements SistemaUCN {
    private Scanner scanner;
    private Usuario usuario;
    private ContenedorOferta contenedorOfertas;
    private ContenedorUsuario contenedorUsuarios;

    /**
     * Constructor por defecto que inicializa los contenedores y el scanner.
     */
    public SistemaUCNImpl() {
        this.scanner = new Scanner(System.in);
        this.usuario = null;
        this.contenedorOfertas = new ContenedorOferta(100);
        this.contenedorUsuarios = new ContenedorUsuario(100);
    }
    /**
     * Devuelve el usuario actualmente autenticado.
     * @return Usuario en sesión o null si no hay sesión activa.
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Registra un nuevo usuario solicitando sus datos por consola.
     */
    public void registrarUsuario() {
        System.out.println("REGISTRAR USUARIO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (rut.length() > 3 && rut.length() < 255) {
            if (contrasena.length() > 6 && contrasena.length() < 255) {
                Usuario nuevoUsuario = new Usuario(nombre, rut, correo, contrasena);
                contenedorUsuarios.agregar(nuevoUsuario);
                System.out.println("USUARIO AGREGADO");
            } else {
                System.out.println("CONTRASEÑA INVÁLIDA");
            }
        } else {
            System.out.println("RUT INVÁLIDO");
        }
    }
    /**
     * Permite iniciar sesión solicitando rut y contraseña.
     * @return true si el inicio de sesión fue exitoso, false si falló.
     */
    public boolean iniciarSesion() {
        System.out.println("INICIAR SESIÓN");
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = contenedorUsuarios.buscarUsuarioPorRut(rut);
        if (usuario == null) {
            System.out.println("USUARIO NO ENCONTRADO");
        } else {
            if (usuario.getContrasena().equals(contrasena)) {
                this.usuario = usuario;
                System.out.println("INICIO DE SESIÓN EXITOSO");
                return true;
            } else {
                System.out.println("CONTRASEÑA INCORRECTA");
            }
        }
        return false;
    }
    /**
     * Muestra la información del perfil del usuario actualmente autenticado.
     */
    public void verPerfil() {
        if (this.usuario != null) {
            this.usuario.imprimir();
        }
    }
    /**
     * Cierra la sesión del usuario actualmente autenticado.
     */
    public void cerrarSesion() {
        if (usuario != null) {
            this.usuario = null;
            System.out.println("SESIÓN CERRADA EXITOSAMENTE");
        }
    }
    /**
     * Permite al usuario editar su nombre y correo electrónico.
     */
    public void editarPerfil() {
        if (this.usuario != null) {
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo correo electrónico: ");
            String correo = scanner.nextLine();
            this.usuario.setNombre(nombre);
            this.usuario.setCorreoElectronico(correo);
        }
    }
    /**
     * Permite ingresar una nueva oferta académica.
     * Solicita tipo y datos según sea Ayudantía, Capstone o Práctica.
     */
    public void IngresarOferta() {
        System.out.print("Tipo de oferta (A/C/P): ");
        String tipoOferta = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Duración (días): ");
        int duracionDias = Integer.parseInt(scanner.nextLine());

        boolean validacionGeneral = titulo.length() >= 8 && titulo.length() <= 255 &&
                descripcion.length() >= 8 && descripcion.length() <= 255 &&
                duracionDias >= 1;

        if (tipoOferta.equalsIgnoreCase("A")) {
            System.out.print("Nombre asignatura: ");
            String nombreAsignatura = scanner.nextLine();
            System.out.print("Rol ayudante: ");
            String rolAyudante = scanner.nextLine();
            System.out.print("Horas semanales: ");
            int horas = Integer.parseInt(scanner.nextLine());
            System.out.print("Promedio mínimo: ");
            double promedio = Double.parseDouble(scanner.nextLine());

            boolean validacionNoGeneral = nombreAsignatura.length() >= 6 && rolAyudante.length() >= 6 && horas >= 2;

            if (validacionGeneral && validacionNoGeneral) {
                Ayudantia ayudantia = new Ayudantia(codigo, titulo, descripcion, duracionDias, "NA", nombreAsignatura, rolAyudante, horas, promedio);
                contenedorOfertas.agregar(ayudantia);
            } else {
                System.out.println("VALIDACIÓN INCORRECTA, REVISAR CAMPOS");
            }

        } else if (tipoOferta.equalsIgnoreCase("C")) {
            System.out.print("Fecha de inicio: ");
            String fechaInicio = scanner.nextLine();
            System.out.print("Empresa solicitante: ");
            String empresa = scanner.nextLine();
            System.out.print("Nombre guía: ");
            String guia = scanner.nextLine();
            System.out.print("Tipo de proyecto: ");
            String tipoProyecto = scanner.nextLine();
            System.out.print("Duración (meses): ");
            int duracionMeses = Integer.parseInt(scanner.nextLine());
            System.out.print("Carreras necesarias: ");
            String carreras = scanner.nextLine();
            System.out.print("Cantidad mínima estudiantes: ");
            int cantidadMinima = Integer.parseInt(scanner.nextLine());

            boolean validacionNoGeneral = (tipoProyecto.equalsIgnoreCase("capstone") || tipoProyecto.equalsIgnoreCase("investigacion") || tipoProyecto.equalsIgnoreCase("memoria"))
                    && (duracionDias == 6 || duracionDias == 12 || duracionDias == 18)
                    && (cantidadMinima >= 2 && cantidadMinima <= 5);

            if (validacionGeneral && validacionNoGeneral) {
                Capstone capstone = new Capstone(codigo, titulo, descripcion, duracionDias, "NA", fechaInicio, empresa, guia, tipoProyecto, duracionMeses, carreras, cantidadMinima);
                contenedorOfertas.agregar(capstone);
            } else {
                System.out.println("VALIDACIÓN INCORRECTA, REVISAR CAMPOS");
            }

        } else if (tipoOferta.equalsIgnoreCase("P")) {
            System.out.print("Fecha de inicio: ");
            String fechaInicio = scanner.nextLine();
            System.out.print("Empresa solicitante: ");
            String empresa = scanner.nextLine();
            System.out.print("Nombre guía: ");
            String guia = scanner.nextLine();
            System.out.print("¿Posee remuneración? (true/false): ");
            boolean remuneracion = Boolean.parseBoolean(scanner.nextLine());

            if (validacionGeneral) {
                Practica practica = new Practica(codigo, titulo, descripcion, duracionDias, "NA", fechaInicio, empresa, guia, remuneracion);
                contenedorOfertas.agregar(practica);
            } else {
                System.out.println("VALIDACIÓN INCORRECTA, REVISAR CAMPOS");
            }
        }
    }

    /**
     * Carga ofertas académicas desde un archivo de texto.
     */
    public void cargarOfertas() {
        try {
            File archivo = new File("OfertasAcademicas.txt");
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] campos = line.split(",");
                String tipo = campos[0];
                String id = campos[1];
                String titulo = campos[2];
                String descripcion = campos[3];
                String unidad = campos[4];
                int duracion = Integer.parseInt(campos[5]);

                if (tipo.equals("A")) {
                    String asignatura = campos[6];
                    String rol = campos[7];
                    int horas = Integer.parseInt(campos[8]);
                    double promedio = Double.parseDouble(campos[9]);
                    Ayudantia ayudantia = new Ayudantia(id, titulo, descripcion, duracion, unidad, asignatura, rol, horas, promedio);
                    contenedorOfertas.agregar(ayudantia);
                } else if (tipo.equals("C")) {
                    String fecha = campos[6];
                    String empresa = campos[7];
                    String guia = campos[8];
                    String tipoProyecto = campos[9];
                    int meses = Integer.parseInt(campos[10]);
                    String carreras = campos[11];
                    int minEstudiantes = Integer.parseInt(campos[12]);
                    Capstone capstone = new Capstone(id, titulo, descripcion, duracion, unidad, fecha, empresa, guia, tipoProyecto, meses, carreras, minEstudiantes);
                    contenedorOfertas.agregar(capstone);
                } else if (tipo.equals("P")) {
                    String fecha = campos[6];
                    String empresa = campos[7];
                    String guia = campos[8];
                    boolean remuneracion = Boolean.parseBoolean(campos[9]);
                    Practica practica = new Practica(id, titulo, descripcion, duracion, unidad, fecha, empresa, guia, remuneracion);
                    contenedorOfertas.agregar(practica);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    /**
     * Muestra todas las ofertas académicas almacenadas.
     */
    public void verOfertas() {
        this.contenedorOfertas.imprimir();
    }
    /**
     * Elimina una oferta académica utilizando su código identificador.
     */
    public void eliminarOferta() {
        System.out.print("Código de oferta a eliminar: ");
        String codigo = scanner.nextLine();
        if (contenedorOfertas.eliminar(codigo)) {
            System.out.println("OFERTA ELIMINADA");
        } else {
            System.out.println("OFERTA NO ENCONTRADA");
        }
    }
    /**
     * Permite editar los datos principales de una oferta existente.
     */
    public void editarOferta() {
        System.out.print("Código de oferta a editar: ");
        String codigoEliminar = scanner.nextLine();
        Oferta oferta = contenedorOfertas.buscarOfertaPorCodigo(codigoEliminar);

        if (oferta != null) {
            System.out.print("Nuevo código: ");
            String codigo = scanner.nextLine();
            System.out.print("Nuevo título: ");
            String titulo = scanner.nextLine();
            System.out.print("Nueva descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Nueva duración (días): ");
            int duracion = Integer.parseInt(scanner.nextLine());

            oferta.setCodigoIdentificador(codigo);
            oferta.setTitulo(titulo);
            oferta.setDescripcion(descripcion);
            oferta.setDuracion(duracion);
            System.out.println("OFERTA EDITADA EXITOSAMENTE");
        } else {
            System.out.println("OFERTA NO ENCONTRADA");
        }
    }
}

