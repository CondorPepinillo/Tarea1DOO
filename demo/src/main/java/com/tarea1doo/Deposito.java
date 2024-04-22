package com.tarea1doo;

import java.util.ArrayList;

public class Deposito<T>{
    private T t;
    private ArrayList<Bebida> arr;
    public T Deposito(){
        T ret = this.t;
        arr = new ArrayList<t>();
        return ret;
    }

    public void addBebida(Bebida b){
        arr.add(b);
    }

    public Bebida getBebida(){
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
