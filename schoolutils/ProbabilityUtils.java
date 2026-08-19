package schoolutils;

public class ProbabilityUtils {

    public static double combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        return MathUtils.factorial(n) / (MathUtils.factorial(r) * MathUtils.factorial(n - r));
    }

    public static double permutation(int n, int r) {
        if (r < 0 || r > n) return 0;
        return MathUtils.factorial(n) / MathUtils.factorial(n - r);
    }

    public static double probabilityOfEvent(int favorable, int total) {
        return total == 0 ? 0 : (double) favorable / total;
    }

    public static double expectedValue(double[] values, double[] probabilities) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) sum += values[i] * probabilities[i];
        return sum;
    }

    public static double binomialProbability(int n, int k, double p) {
        return combination(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    public static double diceRollProbability(int favorableOutcomes) {
        return favorableOutcomes / 36.0;
    }

    public static double conditionalProbability(double pAandB, double pB) {
        return pB == 0 ? 0 : pAandB / pB;
    }

    public static double complementProbability(double p) {
        return 1 - p;
    }
}
