package schoolutils;

import java.util.function.DoubleUnaryOperator;

public class CalculusUtils {

    public static double derivative(DoubleUnaryOperator f, double x) {
        double h = 1e-6;
        return (f.applyAsDouble(x + h) - f.applyAsDouble(x - h)) / (2 * h);
    }

    public static double secondDerivative(DoubleUnaryOperator f, double x) {
        double h = 1e-6;
        return (f.applyAsDouble(x + h) - 2 * f.applyAsDouble(x) + f.applyAsDouble(x - h)) / (h * h);
    }

    public static double trapezoidalIntegral(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.applyAsDouble(a) + f.applyAsDouble(b));
        for (int i = 1; i < n; i++) sum += f.applyAsDouble(a + i * h);
        return sum * h;
    }

    public static double simpsonIntegral(DoubleUnaryOperator f, double a, double b, int n) {
        if (n % 2 != 0) n++;
        double h = (b - a) / n;
        double sum = f.applyAsDouble(a) + f.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f.applyAsDouble(x) * (i % 2 == 0 ? 2 : 4);
        }
        return sum * h / 3;
    }

    public static double riemannSumLeft(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) sum += f.applyAsDouble(a + i * h) * h;
        return sum;
    }

    public static double riemannSumRight(DoubleUnaryOperator f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0;
        for (int i = 1; i <= n; i++) sum += f.applyAsDouble(a + i * h) * h;
        return sum;
    }

    public static double limitFromRight(DoubleUnaryOperator f, double x) {
        double h = 1e-8;
        return f.applyAsDouble(x + h);
    }

    public static double taylorTerm(double x, int n) {
        return Math.pow(x, n) / MathUtils.factorial(n);
    }

    public static double eApproximation(int terms) {
        double sum = 0;
        for (int i = 0; i < terms; i++) sum += 1.0 / MathUtils.factorial(i);
        return sum;
    }

    public static double partialSum(DoubleUnaryOperator term, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) sum += term.applyAsDouble(i);
        return sum;
    }
}
