package com.tarea1doo;

public class Tarea1Main {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(5,300);
        Expendedor exp2 = new Expendedor(5,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste());
        System.out.println(c.cuantoVuelto());
        Comprador dulce = null;
        dulce = new Comprador(m,Expendedor.CHOCOLATE,exp2);
        System.out.println(dulce.queComiste());
        System.out.println(dulce.queBebiste ());
        System.out.println(dulce.cuantoVuelto());
    }
}
