package com.tarea1doo;

/* Representa a un comprador que puede comprar bebidas o dulces de un expendedor.*/
public class Comprador{
    /* El sonido que hace la bebida o el dulce al ser consumido. */
    private String sonido;
     /*La cantidad de dinero devuelta al comprador después de la compra. */
    private int vuelto;
    /*El tipo de producto comprado (1 para Coca-Cola, 2 para Sprite, 3 para Fanta, 4 para Snickers, 5 para Super8). */
    private int cualProducto;
    
    /**
     * Crea un nuevo comprador que compra un producto desde un expendedor.
     *
     * @param m La moneda utilizada para comprar el producto.
     * @param Producto El tipo de producto comprado.
     * @param exp El expendedor del que se compró el producto.
     * @throws PagoIncorrectoException Si la moneda utilizada no es válida.
     * @throws NoHayProductoException Si el producto no está disponible.
     * @throws PagoInsuficienteException Si la moneda utilizada no es suficiente para comprar el producto.
     */
    public Comprador(Moneda m, ProductList Producto, Expendedor exp) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        switch (Producto) {
            case COCA:
                this.cualProducto = 1;
                break;
            case SPRITE:
                this.cualProducto = 2;
                break;
            case FANTA:
                this.cualProducto = 3;
                break;
            case SNICKERS:
                this.cualProducto = 4;
                break;
            case SUPER8:
                this.cualProducto = 5;
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

    /**
     * Devuelve la cantidad de dinero sobrante al comprador después de la compra.
     *
     * @return La cantidad de dinero devuelto.
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Devuelve el sonido que hace la bebida al ser consumida.
     *
     * @return El sonido de la bebida.
     */
    public String queBebiste(){
        if(cualProducto == 1 || cualProducto == 2 || cualProducto == 3){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }

    /**
     * Devuelve el sonido que hace el dulce al ser consumido.
     *
     * @return El sonido del dulce.
     */
    public String queComiste(){
        if(cualProducto == 4 || cualProducto == 5){
            return sonido;
        }
        else{
            return "No se puede";
        }
    }
}
