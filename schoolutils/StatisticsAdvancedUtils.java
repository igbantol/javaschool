package schoolutils;

public class StatisticsAdvancedUtils {

    public static double mean(double[] data) {
        return StatsUtils.mean(data);
    }

    public static double covariance(double[] x, double[] y) {
        double mx = mean(x), my = mean(y);
        double sum = 0;
        for (int i = 0; i < x.length; i++) sum += (x[i] - mx) * (y[i] - my);
        return sum / x.length;
    }

    public static double correlation(double[] x, double[] y) {
        double cov = covariance(x, y);
        double sx = StatsUtils.standardDeviation(x);
        double sy = StatsUtils.standardDeviation(y);
        return (sx == 0 || sy == 0) ? 0 : cov / (sx * sy);
    }

    public static double linearRegressionSlope(double[] x, double[] y) {
        double mx = mean(x), my = mean(y);
        double num = 0, den = 0;
        for (int i = 0; i < x.length; i++) {
            num += (x[i] - mx) * (y[i] - my);
            den += (x[i] - mx) * (x[i] - mx);
        }
        return den == 0 ? 0 : num / den;
    }

    public static double linearRegressionIntercept(double[] x, double[] y) {
        return mean(y) - linearRegressionSlope(x, y) * mean(x);
    }

    public static double rSquared(double[] x, double[] y) {
        double r = correlation(x, y);
        return r * r;
    }

    public static double zScore(double value, double mu, double sigma) {
        return sigma == 0 ? 0 : (value - mu) / sigma;
    }

    public static double standardError(double[] data) {
        return StatsUtils.standardDeviation(data) / Math.sqrt(data.length);
    }

    public static double tStatistic(double sampleMean, double popMean, double sampleSD, int n) {
        return sampleSD == 0 ? 0 : (sampleMean - popMean) / (sampleSD / Math.sqrt(n));
    }

    public static double normalCDF(double x) {
        return 0.5 * (1 + erf(x / Math.sqrt(2)));
    }

    private static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
        double inner = 1.00002368
                + t * (0.37409196 + t * (0.09678418
                + t * (-0.18628806 + t * (0.27886807 + t * (-1.13520398
                + t * (1.48851587 + t * (-0.82215223 + t * 0.17087277)))))));
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 + t * inner);
        return z >= 0 ? ans : -ans;
    }

    public static double confidenceInterval(double mean, double sd, int n, double z) {
        return z * sd / Math.sqrt(n);
    }
}
