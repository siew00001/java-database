package Model;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, float price){
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price + ", ID: " + id;
    }
}
