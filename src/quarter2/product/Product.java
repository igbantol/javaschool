package quarter2.product;

public class Product {
    private String productName;
    private double price;
    private int stock;

    public Product(String productName) {
        this.productName = productName;
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

    public boolean setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            return true;
        }
        System.out.println("Invalid price!");
        return false;
    }

    public int getStock() {
        return stock;
    }

    public boolean setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            return true;
        }
        System.out.println("Invalid stock!");
        return false;
    }

    public void displayInfo() {
        System.out.println("Product Information");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println();
    }
}
