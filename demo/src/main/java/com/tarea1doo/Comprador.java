package com.tarea1doo;

public class Comprador{
    private String sonido;
    private int vuelto;
    private int cualProducto;
    public Comprador(Moneda m, int cualProducto, Expendedor exp){
        Producto b = exp.comprarBebida(m, cualProducto);
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


        this.cualProducto = cualProducto;
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
