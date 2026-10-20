package quarter2.product;

public class Product {
    private String productName;
    private double price;
    private int stock;

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        setPrice(price);
        setStock(stock);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price!");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Invalid stock!");
        }
    }

    public void displayInfo() {
        System.out.println("Product Information");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println();
    }
}
