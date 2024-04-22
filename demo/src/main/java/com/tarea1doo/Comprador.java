package com.tarea1doo;

public class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida b = exp.comprarBebida(m, cualBebida);
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
        } else{
            sonido = b.beber();
        }
        
    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}
