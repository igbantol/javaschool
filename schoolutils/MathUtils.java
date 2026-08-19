package schoolutils;

public class MathUtils {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) return Double.NaN;
        return a / b;
    }

    public static int modulus(int a, int b) {
        return a % b;
    }

    public static int power(int base, int exp) {
        return (int) Math.pow(base, exp);
    }

    public static int square(int n) {
        return n * n;
    }

    public static int cube(int n) {
        return n * n * n;
    }

    public static int absolute(int n) {
        return Math.abs(n);
    }

    public static double absolute(double n) {
        return Math.abs(n);
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static int sumUpTo(int n) {
        return n * (n + 1) / 2;
    }

    public static int sumRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) sum += i;
        return sum;
    }

    public static boolean isPerfectSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    public static int roundToInt(double n) {
        return (int) Math.round(n);
    }

    public static double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    public static double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public static double squareRoot(double n) {
        return Math.sqrt(n);
    }

    public static double log10(double n) {
        return Math.log10(n);
    }

    public static double naturalLog(double n) {
        return Math.log(n);
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
