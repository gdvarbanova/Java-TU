import java.util.List;

class CartEntry {
    String storeName;
    List<Product> products;

    public CartEntry(String storeName, List<Product> products) {
        this.storeName = storeName;
        this.products = products;
    }
}