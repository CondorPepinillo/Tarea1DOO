package com.tarea1doo;

import java.util.ArrayList;
/**
 * Esta clase representa un depósito de monedas.
 * El depósito puede almacenar un número ilimitado de monedas.
 */
public class DepositoM{
    private ArrayList<Moneda> arr;
    /**
     * Crea un nuevo depósito de monedas.
     */
    public DepositoM(){
        arr = new ArrayList<Moneda>();
    }
    /**
     * Añade una moneda al depósito.
     *
     * @param m La moneda a añadir.
     */
    public void addMoneda(Moneda m){
        arr.add(m);
    }
    /**
     * Obtiene una moneda del depósito.
     *
     * @return La moneda obtenida.
     */
    public Moneda getMoneda(){
        if(arr.size() > 0){
            return arr.remove(0);
        } else{
            return null;
        }
    }
}
