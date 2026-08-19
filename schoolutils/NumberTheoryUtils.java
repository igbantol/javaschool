package schoolutils;

public class NumberTheoryUtils {

    public static boolean isArmstrong(int n) {
        int sum = 0, original = n, digits = String.valueOf(n).length();
        while (n > 0) {
            int d = n % 10;
            sum += Math.pow(d, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static boolean isPerfect(int n) {
        return n > 0 && sumOfDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return n > 0 && sumOfDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return n > 0 && sumOfDivisors(n) < n;
    }

    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) if (n % i == 0) sum += i;
        return sum;
    }

    public static boolean isCoprime(int a, int b) {
        return MathUtils.gcd(a, b) == 1;
    }

    public static int eulerTotient(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (MathUtils.gcd(i, n) == 1) count++;
        return count;
    }

    public static int digitSum(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int reverseNumber(int n) {
        int rev = 0;
        n = Math.abs(n);
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static int numberOfDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
