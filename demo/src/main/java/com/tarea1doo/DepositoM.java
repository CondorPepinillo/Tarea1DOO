package com.tarea1doo;

import java.util.ArrayList;

public class DepositoM{
    private ArrayList<Moneda> arr;
    public DepositoM(){
        arr = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda m){
        arr.add(m);
    }

    public Moneda getMoneda(){
        if(arr.size() > 0){
            return arr.remove(0);
        } else{
            return null;
        }
    }
}
