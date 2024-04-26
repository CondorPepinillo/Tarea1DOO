package com.tarea1doo;

import java.util.ArrayList;

/**
 * Esta clase representa un depósito de productos.
 * Permite añadir y obtener productos del depósito.
 */
public class Deposito{
    /**
     * Lista de productos en el depósito.
     */
    private ArrayList<Producto> arr;
    /**
     * Constructor de la clase Deposito.
     * Inicializa la lista de productos.
     */
    public  Deposito(){
        arr = new ArrayList<>();
    }

    /**
     * Añade un producto al depósito.
     * @param b Producto a añadir.
     */
    public void addProducto(Producto b){
        arr.add(b);
    }

    /**
     * Obtiene un producto del depósito.
     * @return Producto obtenido, o null si el depósito está vacío.
     */
    public Producto getProducto(){
        if(arr.size() > 0){
            return arr.remove(0);
        } else{
            return null;
        }
    }

    /**
     * Comprueba si el depósito está vacío.
     * @return True si el depósito está vacío, false en caso contrario.
     */
    public boolean checkSize(){
        if(arr.size() == 0){
            return true;
        } else{
            return false;
        }
    }
}
