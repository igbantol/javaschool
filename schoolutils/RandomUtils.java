package schoolutils;

import java.util.Random;

public class RandomUtils {

    private static final Random rand = new Random();

    public static int randomInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static double randomDouble() {
        return rand.nextDouble();
    }

    public static double randomBetween(double min, double max) {
        return min + rand.nextDouble() * (max - min);
    }

    public static boolean randomBoolean() {
        return rand.nextBoolean();
    }

    public static String randomChoice(String[] options) {
        return options[rand.nextInt(options.length)];
    }

    public static int rollDie(int sides) {
        return rand.nextInt(sides) + 1;
    }

    public static char randomChar() {
        return (char) ('a' + rand.nextInt(26));
    }

    public static int[] shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return arr;
    }
}
