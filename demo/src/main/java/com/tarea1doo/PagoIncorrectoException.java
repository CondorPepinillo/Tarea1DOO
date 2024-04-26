package com.tarea1doo;

public class PagoIncorrectoException extends Exception{
    public  PagoIncorrectoException(){
        super("No se introdujo moneda");
    }
}
