package quarter2.product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create a New Product ===");
        System.out.print("Enter product name: ");
        Product product = new Product(scanner.nextLine());

        while (true) {
            System.out.print("Enter price: ");
            if (product.setPrice(scanner.nextDouble())) {
                break;
            }
            System.out.println("Try again.");
        }

        while (true) {
            System.out.print("Enter stock: ");
            if (product.setStock(scanner.nextInt())) {
                break;
            }
            System.out.println("Try again.");
        }

        System.out.println();
        product.displayInfo();

        System.out.println("=== Update Price and Stock ===");
        while (true) {
            System.out.print("Enter new price: ");
            if (product.setPrice(scanner.nextDouble())) {
                break;
            }
            System.out.println("Try again.");
        }

        while (true) {
            System.out.print("Enter new stock: ");
            if (product.setStock(scanner.nextInt())) {
                break;
            }
            System.out.println("Try again.");
        }

        System.out.println();
        product.displayInfo();

        scanner.close();
    }
}
