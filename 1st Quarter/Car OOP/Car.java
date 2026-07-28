public class Car {
    String model;
    String brand;
    int year;
    double price;

    Car(String model, String brand, int year, double price) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    void honk() {
        System.out.println("Your " + this.brand + " " + this.model + " is honking");
    }
}
