package com.tarea1doo;

public class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("No hay producto");
    }
}
