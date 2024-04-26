package com.tarea1doo;

public class Sprite extends Producto{
    /**
     * Constructor de la clase Sprite.
     * @param serie Serie del producto.
     */
    public Sprite(int serie){
        super(serie);
    }
    /**
     * Método que simula el acto de beber el producto.
     *
     * @return Nombre del producto.
     */
    public String beber(){
        return new String("sprite");
    }
}
