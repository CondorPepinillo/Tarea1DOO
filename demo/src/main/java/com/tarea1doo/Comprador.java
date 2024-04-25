package com.tarea1doo;


/* Representa a un comprador que puede comprar bebidas o dulces de un expendedor.*/
public class Comprador{
    /* El sonido que hace la bebida o el dulce al ser consumido. */
    private String sonido;
    /*La cantidad de dinero devuelta al comprador después de la compra. */
    private int vuelto;
    /*El tipo de producto comprado (1 para Coca-Cola, 2 para Sprite, 3 para Chocolate, 4 para Caramelo). */
    private int cualProducto;
    
    /*Crea un nuevo comprador que compra un producto del expendedor especificado utilizando la moneda especificada. */
    public Comprador(Moneda m, ProductList Producto, Expendedor exp){
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

        Producto b = exp.comprarBebida(m, this.cualProducto);
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

    /*Devuelve la cantidad de dinero devuelta al comprador. */
    public int cuantoVuelto(){
        return vuelto;
    }

    /*Devuelve el sonido que hace la bebida al ser consumida. */
    public String queBebiste(){
        if(cualProducto == 1 || cualProducto == 2){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }
    
    /*Devuelve el sonido que hace el dulce al ser consumido. */
    public String queComiste(){
        if(cualProducto == 3 || cualProducto == 4){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }
}
