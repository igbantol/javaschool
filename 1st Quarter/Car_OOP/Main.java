public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Civic", "Honda", 2011, 123456);
        Car car2 = new Car("Jesko", "Koenigsegg", 2025, 184321);
        Car car3 = new Car("Vios", "Toyota", 2010, 1234);
        car1.flex();
        car2.flex();
        car3.flex();
        car1.honk();
        car2.honk();
        car3.honk();
        car1.leak();
        car2.leak();
        car3.leak();
    }
}