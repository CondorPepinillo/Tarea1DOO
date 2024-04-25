package com.tarea1doo;

public class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito chocolate;
    private Deposito caramelo;
    private DepositoM monVu;
    private int precio;
    private int precioProducto;


    public Expendedor(int numProductos, ProductList Producto){
        switch (Producto) {
            case COCA:
                this.precioProducto = 300;
                break;
            case SPRITE:
                this.precioProducto = 200;
                break;
            case CHOCOLATE:
                this.precioProducto = 500;
                break;
            case CARAMELO:
                this.precioProducto = 100;
                break;
            default:
                break;
        }
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

    public Producto comprarProducto(Moneda m, int cual) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        if(m == null){
            throw new PagoIncorrectoException("No se introdujo moneda");
        }

        if(m.getValor() < precio){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new PagoInsuficienteException("Pago insuficiente");
        } 

        if(cual != 1 && cual != 2 && cual != 3 && cual != 4){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new NoHayProductoException("Producto no existe");
        }

        if(coca.checkSize() && sprite.checkSize() && chocolate.checkSize() && caramelo.checkSize()){
            for(int i = 0;i < m.getValor()/100;i++){
                monVu.addMoneda(new Moneda100());
            }
            throw new NoHayProductoException("No hay producto");
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
