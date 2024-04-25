package com.tarea1doo;

import java.util.ArrayList;

public class Deposito{
    private ArrayList<Producto> arr;
    public  Deposito(){
        arr = new ArrayList<>();
    }

    public void addBebida(Producto b){
        arr.add(b);
    }

    public Producto getBebida(){
        if(arr.size() > 0){
            return arr.remove(0);
        } else{
            return null;
        }
    }

    public boolean checkSize(){
        if(arr.size() == 0){
            return true;
        } else{
            return false;
        }
    }
}
