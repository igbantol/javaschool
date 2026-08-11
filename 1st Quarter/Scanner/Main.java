import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Building letter: ");
        char building = scanner.next().charAt(0);
        System.out.print("Stall count: ");
        byte stalls = scanner.nextByte();
        System.out.print("Toilet count: ");
        short toilets = scanner.nextShort();
        System.out.print("Door count: ");
        int doors = scanner.nextInt();
        System.out.print("Broken utilities: ");
        long broken = scanner.nextLong();
        System.out.print("Water available (L): ");
        double waterAvailable = scanner.nextDouble();
        System.out.print("Open? (true/false): ");
        boolean open = scanner.nextBoolean();
        System.out.print("How much water do you want to use? ");
        float waterUsed = scanner.nextFloat();
        scanner.close();
        CR cr = new CR(stalls, toilets, doors, broken, waterUsed, waterAvailable, building, open);
        cr.printCR();
    }
}
