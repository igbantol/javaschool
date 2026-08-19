package schoolutils;

public class CombinatoricsUtils {

    public static double permutation(int n, int r) {
        if (r < 0 || r > n) return 0;
        return MathUtils.factorial(n) / MathUtils.factorial(n - r);
    }

    public static double combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        return MathUtils.factorial(n) / (MathUtils.factorial(r) * MathUtils.factorial(n - r));
    }

    public static int factorial(int n) {
        return MathUtils.factorial(n);
    }

    public static int catalan(int n) {
        return (int) (MathUtils.factorial(2 * n) / (MathUtils.factorial(n + 1) * MathUtils.factorial(n)));
    }

    public static int binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) return 0;
        int res = 1;
        k = Math.min(k, n - k);
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static int powerSetSize(int n) {
        return (int) Math.pow(2, n);
    }

    public static int derangements(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 0;
        for (int i = 2; i <= n; i++) d[i] = (i - 1) * (d[i - 1] + d[i - 2]);
        return d[n];
    }

    public static int triangularNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int tetrahedralNumber(int n) {
        return n * (n + 1) * (n + 2) / 6;
    }

    public static int lucasNumber(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        int a = 2, b = 1;
        for (int i = 2; i <= n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}
