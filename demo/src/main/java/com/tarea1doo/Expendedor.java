package com.tarea1doo;
/**
 *Esta clase representa un expendedor de bebidas y dulces.
 * El expendedor tiene depósitos para cada tipo de bebida y dulce (Coca-Cola, Sprite, Chocolate y Caramelo) y un depósito para las monedas.
 * El expendedor también tiene un precio para cada tipo de bebida y dulce.
 */
public class Expendedor{
    /* El depósito de Coca-Cola.*/
    private Deposito coca;
    /* El depósito de Sprite.*/
    private Deposito sprite;
    /*El depósito de Chocolate.*/
    private Deposito chocolate;
    /* El depósito de Caramelo.*/
    private Deposito caramelo;
    /* El depósito de monedas.*/
    private DepositoM monVu;
    /* El precio del producto seleccionado.*/
    private int precio;



    public Expendedor(int numProductos, ProductList Producto){
        switch (Producto) {
            case COCA:
                this.precio = 300;
                break;
            case SPRITE:
                this.precio = 200;
                break;
            case CHOCOLATE:
                this.precio = 500;
                break;
            case CARAMELO:
                this.precio = 100;
                break;
            default:
                break;
        }
        coca = new Deposito();
        sprite = new Deposito();
        chocolate = new Deposito();
        caramelo = new Deposito();
        monVu = new DepositoM();
        for(int i = 0;i < numProductos;i++){
            coca.addProducto(new CocaCola(100 + i));
            sprite.addProducto(new Sprite(200 + i));
            chocolate.addProducto(new Chocolate(300 + i));
            caramelo.addProducto(new Caramelo(400 + i));
        }
    }

    /**
     * Compra un producto con una moneda.
     *
     * @param m La moneda a utilizar para comprar el producto.
     * @param cual El tipo de producto a comprar.
     * @return El producto comprado, o null si la compra no es posible.
     */
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

        if(cual != 1 && cual != 2 && cual != 3 && cual != 4){
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
                return coca.getProducto();
            case 2:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return sprite.getProducto();
            case 3:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return chocolate.getProducto();
            case 4:
                for(int i = 0;i < (m.getValor() - precio)/100;i++){
                    monVu.addMoneda(new Moneda100());
                }
                return caramelo.getProducto();
            default:
                return null; 
        }
    }

    /**
     * Devuelve el vuelto de la compra.
     *
     * @return El vuelto de la compra, o null si no hay vuelto.
     */
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
