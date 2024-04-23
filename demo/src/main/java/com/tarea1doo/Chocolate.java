package com.tarea1doo;

public class Chocolate extends Producto{
    public Chocolate(int serie){
        super(serie);
    }

    public String beber(){
        return new String("chocolate");
    }
}