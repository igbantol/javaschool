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

    void flex() {
        System.out.println("I have a " + this.model + " " + this.brand + " " + this.model + " that is worth "
                + this.price + " dollars");
    }
}
