package dominio;

public class ContenedorOferta {
    private int cantidadMaxima;
    private Oferta[] ofertas;
    private int cantidadActual;

    public ContenedorOferta(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.ofertas = new Oferta[cantidadMaxima];
        this.cantidadActual = 0;
    }

    public boolean agregar(Oferta oferta){
        if(this.cantidadActual < cantidadMaxima){
            ofertas[cantidadActual]= oferta;
            cantidadActual++;
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminar(String ofertaId){
        int posicion= -1;
        for(int i=0; i<this.cantidadActual; i++){
            if(this.ofertas[i].getCodigoIdentificador().equals(ofertaId)){
                posicion= i;
                break;
            }
        }
        if(posicion != -1){
            for(int i=posicion+1; i<cantidadActual; i++){
                this.ofertas[i-1]= ofertas[i];
            }
            this.ofertas[this.cantidadActual-1]= null;
            this.cantidadActual--;
            return true;
        }else{
            return false;
        }
    }

    public int obtenerPosicion(String ofertaId) {
        for(int i=0; i<this.cantidadActual; i++){
            Oferta oferta= this.ofertas[i];
            if(oferta.getCodigoIdentificador().equals(ofertaId)){
                return i;
            }
        }

        return -1;
    }

    public Oferta obtenerElemento(int i){
        return this.ofertas[i];
    }

    public Oferta buscarOfertaPorCodigo(String ofertaId){
        for(int i=0; i<this.cantidadActual; i++){
            Oferta oferta= this.ofertas[i];
            if(oferta.getCodigoIdentificador().equals(ofertaId)){
                return this.ofertas[i];
            }
        }
        return null;
    }

    public Oferta buscarOfertaPorTitulo(String titulo){
        for(int i=0; i<this.cantidadActual; i++){
            Oferta oferta= this.ofertas[i];
            if(oferta.getTitulo().equals(titulo)){
                return this.ofertas[i];
            }
        }
        return null;
    }

    public void imprimir(){
        for(int i=0; i<this.cantidadActual; i++){
            Oferta oferta = this.ofertas[i];
            oferta.imprimir();
        }
    }
}
