import array.Array;
import array.ArrayImp;
import entities.Product;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Product product = new Product(-3,"C0101");
        Product product2 = new Product(2, "C0102");
        Product product3 = new Product(50,"C0103");
        Product product4 = new Product(1, "C0102");
        Product product5 = new Product(20,"C0103");

        Product[] products = {product,product2,product3,product4,product5};

        Array<Product> list = new ArrayImp<>(2);
        try {
            list.insert(product);
            list.insert(product2);
            list.insert(product3);
            list.insert(product4);
            //list.insert(product5);
            //list.insertionSort();
        } catch (InvalidIDException | AlreadyExistsException | OverFlowException
                  e) {
            System.out.println(e.getMessage());
        }


    }
}