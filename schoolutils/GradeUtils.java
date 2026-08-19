package schoolutils;

public class GradeUtils {

    public static double computeAverage(double[] scores) {
        double sum = 0;
        for (double s : scores) sum += s;
        return sum / scores.length;
    }

    public static String letterGrade(double score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public static String remark(double score) {
        if (score >= 90) return "Excellent";
        if (score >= 80) return "Very Good";
        if (score >= 70) return "Good";
        if (score >= 60) return "Pass";
        return "Needs Improvement";
    }

    public static boolean isPassing(double score) {
        return score >= 60;
    }

    public static double percentage(double earned, double total) {
        if (total == 0) return 0;
        return (earned / total) * 100;
    }

    public static double weightedAverage(double[] scores, double[] weights) {
        double sum = 0, wsum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i] * weights[i];
            wsum += weights[i];
        }
        return wsum == 0 ? 0 : sum / wsum;
    }

    public static double highest(double[] scores) {
        double m = scores[0];
        for (double s : scores) m = Math.max(m, s);
        return m;
    }

    public static double lowest(double[] scores) {
        double m = scores[0];
        for (double s : scores) m = Math.min(m, s);
        return m;
    }

    public static int countFailing(double[] scores) {
        int c = 0;
        for (double s : scores) if (s < 60) c++;
        return c;
    }

    public static String gradeRange(double score) {
        if (score >= 90) return "90-100";
        if (score >= 80) return "80-89";
        if (score >= 70) return "70-79";
        if (score >= 60) return "60-69";
        return "0-59";
    }
}
