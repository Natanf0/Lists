package entities;

public class Product extends Node<Product> {
    String code;
    public Product(int ID, String code){
        super(ID);
        this.code=code;
    }
}
