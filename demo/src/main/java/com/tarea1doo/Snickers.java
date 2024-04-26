package com.tarea1doo;

public class Snickers extends Producto{
    /**
     * Constructor de la clase Snickers.
     * @param serie Serie del producto.
     */
    public Snickers(int serie){
        super(serie);
    }
    /**
     * Método que simula el acto de comer el producto.
     *
     * @return Nombre del producto.
     */
    public String beber(){
        return new String("snickers");
    }
}