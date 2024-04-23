package com.tarea1doo;

public class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito chocolate;
    private Deposito caramelo;
    private DepositoM monVu;
    private int precio;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int CHOCOLATE = 3;
    public static final int CARAMELO = 4;

    public Expendedor(int numProductos, int precioProducto){
        precio = precioProducto;
        coca = new Deposito();
        sprite = new Deposito();
        chocolate = new Deposito();
        caramelo = new Deposito();
        monVu = new DepositoM();
        for(int i = 0;i < numProductos;i++){
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
            chocolate.addBebida(new Chocolate(300 + i));
            caramelo.addBebida(new Caramelo(400 + i));
        }
    }

    public Producto comprarBebida(Moneda m, int cual){
        if(m == null){
            return null;
        }

        if(m.getValor() < precio){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        } 

        if(cual != COCA && cual != SPRITE && cual != CHOCOLATE && cual != CARAMELO){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        }

        if(coca.checkSize() && sprite.checkSize() && chocolate.checkSize() && caramelo.checkSize()){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            return null;
        }
        
        switch (cual) {
            case 1:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return coca.getBebida();
            case 2:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return sprite.getBebida();
            case 3:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return chocolate.getBebida();
            case 4:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return caramelo.getBebida();
            default:
                return null; 
        }
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
