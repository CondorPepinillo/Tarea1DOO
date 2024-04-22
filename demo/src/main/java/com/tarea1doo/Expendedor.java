package com.tarea1doo;

public class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private Deposito dulce;
    private int precio;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public Expendedor(int numBebidas, int precioBebidas){
        precio = precioBebidas;
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();
        for(int i = 0;i < numBebidas;i++){
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual){
        if(m == null){
            return null;
        }

        if(m.getValor() < precio){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        } 

        if(cual != COCA && cual != SPRITE){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        }

        if(coca.checkSize() && sprite.checkSize()){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        }
        
        if(cual == COCA){
            for(int i = 0;i < (m.getValor() - precio)/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return coca.getBebida();
        } else if(cual == SPRITE){
            for(int i = 0;i < (m.getValor() - precio)/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return sprite.getBebida();
        }
        return null; 
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
