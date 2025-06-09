package vista;

import sistema.SistemaUCNImpl;

import java.util.Scanner;

public class VistaConsola {
    private SistemaUCNImpl sistema;

    public VistaConsola() {
        this.sistema = new SistemaUCNImpl();
    }

    public void iniciar(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("INICIO");
        sistema.cargarOfertas();

        while(true){
            System.out.println("Registrar usuario[1], Inicia sesion[2], ");
            String opcionPadre= scanner.nextLine();
            if(opcionPadre.equals("1")){
                sistema.registrarUsuario();
            }else if(opcionPadre.equals("2")){
                sistema.iniciarSesion();
                if(this.sistema.getUsuario() != null){
                    System.out.println("Ingresar oferta[1], BuscarOferta[2], VerOfertas[3]. EditarOferta[4], EliminarOFerta[5], VerPerfil[6], EditarPerfil[7], CerrasSesion[8]");
                    String opcion= scanner.nextLine();
                    if(opcion.equals("0")){
                        sistema.iniciarSesion();
                    }else if(opcion.equals("1")){
                        sistema.IngresarOferta();
                    }else if(opcion.equals("2")){
                        sistema.editarOferta();
                    }else if(opcion.equals("3")){
                        sistema.verOfertas();
                    }else if(opcion.equals("4")){
                        sistema.editarOferta();
                    }else if(opcion.equals("5")){
                        sistema.eliminarOferta();
                    }else if(opcion.equals("6")){
                        sistema.verPerfil();
                    }else if(opcion.equals("7")){
                        sistema.editarPerfil();
                    }else if(opcion.equals("8")){
                        sistema.cerrarSesion();
                    }
                }
            }
        }
    }
}
