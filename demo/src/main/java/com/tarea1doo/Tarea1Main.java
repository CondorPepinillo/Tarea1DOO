package com.tarea1doo;

import java.util.ArrayList;

public class Tarea1Main {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(5,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste());
        System.out.println(c.cuantoVuelto());
    }
}

class Comprador{
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

class Expendedor{
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

abstract class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie = serie;
    }

    public int getSerie(){
        return serie;
    }

    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }

    public String beber(){
        return new String("sprite");
    }
}

class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }

    public String beber(){
        return new String("cocacola");
    }
}

class DepositoM{
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

class Deposito<T>{
    private T t;
    private ArrayList<T> arr;
    public T Deposito(){
        T ret = this.t;
        arr = new ArrayList<>();
    }

    public void addBebida(T b){
        arr.add(b);
    }

    public T getBebida(){
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

abstract class Moneda{
    public Moneda(){

    }

    public Moneda getSerie(){
        return this;
    };

    public abstract int getValor();
}

class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }

    public int getValor(){
        return 1500;
    };

}

class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }

    public int getValor(){
        return 1000;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }

    public int getValor(){
        return 500;
    }

}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }

    public int getValor(){
        return 100;
    }
}