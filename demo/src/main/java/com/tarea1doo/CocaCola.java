package com.tarea1doo;

public class CocaCola extends Producto{
    /**
     * Constructor de la clase Cola-Cola.
     * @param serie Serie del producto.
     */
    public CocaCola(int serie){
        super(serie);
    }
    /**
     * Método que simula el acto de beber el producto.
     *
     * @return Nombre del producto.
     */
    public String beber(){
        return new String("cocacola");
    }
}