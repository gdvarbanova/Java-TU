import java.io.Serializable;

class Product {
    int id;
    String name;
    double price;
    String store;

    public Product(int id, String name, double price, String store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }
}