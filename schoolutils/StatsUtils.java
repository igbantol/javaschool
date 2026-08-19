package schoolutils;

public class StatsUtils {

    public static double mean(double[] data) {
        double s = 0;
        for (double d : data) s += d;
        return s / data.length;
    }

    public static double median(double[] data) {
        double[] sorted = data.clone();
        java.util.Arrays.sort(sorted);
        int n = sorted.length;
        if (n % 2 == 0) return (sorted[n / 2 - 1] + sorted[n / 2]) / 2;
        return sorted[n / 2];
    }

    public static double variance(double[] data) {
        double m = mean(data);
        double s = 0;
        for (double d : data) s += (d - m) * (d - m);
        return s / data.length;
    }

    public static double standardDeviation(double[] data) {
        return Math.sqrt(variance(data));
    }

    public static double range(double[] data) {
        return schoolutils.ArrayUtils.max(toIntArray(data)) - schoolutils.ArrayUtils.min(toIntArray(data));
    }

    public static double mode(double[] data) {
        double mode = data[0];
        int maxCount = 0;
        for (double d : data) {
            int count = 0;
            for (double e : data) if (e == d) count++;
            if (count > maxCount) {
                maxCount = count;
                mode = d;
            }
        }
        return mode;
    }

    public static double geometricMean(double[] data) {
        double p = 1;
        for (double d : data) p *= d;
        return Math.pow(p, 1.0 / data.length);
    }

    public static double sumOfSquares(double[] data) {
        double s = 0;
        for (double d : data) s += d * d;
        return s;
    }

    public static double percentile(double[] data, double p) {
        double[] sorted = data.clone();
        java.util.Arrays.sort(sorted);
        int index = (int) Math.ceil(p / 100.0 * sorted.length) - 1;
        return sorted[Math.max(0, index)];
    }

    public static double coefficientOfVariation(double[] data) {
        return standardDeviation(data) / mean(data) * 100;
    }

    private static int[] toIntArray(double[] data) {
        int[] r = new int[data.length];
        for (int i = 0; i < data.length; i++) r[i] = (int) data[i];
        return r;
    }
}
