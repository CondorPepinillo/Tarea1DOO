package com.tarea1doo;

public class Comprador{
    private String sonido;
    private int vuelto;
    private int cualProducto;
    public Comprador(Moneda m, ProductList Producto, Expendedor exp) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        switch (Producto) {
            case COCA:
                this.cualProducto = 1;
                break;
            case SPRITE:
                this.cualProducto = 2;
                break;
            case CHOCOLATE:
                this.cualProducto = 3;
                break;
            case CARAMELO:
                this.cualProducto = 4;
                break;
            default:
                break;
        }

        Producto b = exp.comprarProducto(m, this.cualProducto);
        while(true){
            Moneda aux = exp.getVuelto();
            if(aux == null){
                break;
            } else{
                vuelto += aux.getValor();
            }
        }
        if(b == null){
            sonido = null;
        }
        else{
            sonido = b.beber();
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queBebiste(){
        if(cualProducto == 1 || cualProducto == 2){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }

    public String queComiste(){
        if(cualProducto == 3 || cualProducto == 4){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }
}
