package com.tarea1doo;

public class Tarea1Main {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(5, ProductList.COCA);
        Expendedor exp2 = new Expendedor(5, ProductList.SNICKERS);
        Moneda m = null;
        Comprador c = null;
        try{
            m = new Moneda1000();
            c = new Comprador(m,ProductList.COCA,exp);
            System.out.println(c.queBebiste());
            System.out.println(c.cuantoVuelto());
        } catch(PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
        Comprador dulce = null;
        try{
            dulce = new Comprador(m,ProductList.SNICKERS,exp2);
            System.out.println(dulce.queComiste());
            System.out.println(dulce.queBebiste ());
            System.out.println(dulce.cuantoVuelto());
        } catch(PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}

