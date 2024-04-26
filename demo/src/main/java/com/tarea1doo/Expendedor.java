package com.tarea1doo;

public class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private DepositoM monVu;
    private int precio;
    private int precioProducto;


    public Expendedor(int numProductos, ProductList Producto){
        switch (Producto) {
            case COCA:
                this.precioProducto = 300;
                break;
            case SPRITE:
                this.precioProducto = 600;
                break;
            case FANTA:
                this.precioProducto = 500;
                break;
            case SNICKERS:
                this.precioProducto = 1000;
                break;
                case SUPER8:
                this.precioProducto = 800;
                break;
            default:
                break;
        }
        precio = precioProducto;
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        snickers = new Deposito();
        super8 = new Deposito();
        monVu = new DepositoM();
        for(int i = 0;i < numProductos;i++){
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
            fanta.addBebida(new Fanta(300 + i));
            snickers.addBebida(new Snickers(400 + i));
            super8.addBebida(new Super8(500 + i));
        }
    }

    public Producto comprarProducto(Moneda m, int cual) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        if(m == null){
            throw new PagoIncorrectoException();
        }

        if(m.getValor() < precio){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new PagoInsuficienteException();
        } 

        if(cual != 1 && cual != 2 && cual != 3 && cual != 4 && cual != 5){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new NoHayProductoException();
        }

        if(coca.checkSize() && sprite.checkSize() && fanta.checkSize() && snickers.checkSize() && super8.checkSize()){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new NoHayProductoException();
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
                return fanta.getBebida();
            case 4:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return snickers.getBebida();
            case 5:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return super8.getBebida();
            default:
                return null; 
        }
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
