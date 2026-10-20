package quarter2.product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create a New Product ===");
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock: ");
        int stock = scanner.nextInt();

        Product product = new Product(productName, price, stock);
        System.out.println();
        product.displayInfo();

        System.out.println("=== Update Price and Stock ===");
        System.out.print("Enter new price: ");
        product.setPrice(scanner.nextDouble());

        System.out.print("Enter new stock: ");
        product.setStock(scanner.nextInt());

        System.out.println();
        product.displayInfo();

        scanner.close();
    }
}
