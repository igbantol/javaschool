package schoolutils;

public class LinearAlgebraUtils {

    public static double dotProduct(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i] * b[i];
        return sum;
    }

    public static double vectorMagnitude(double[] v) {
        return Math.sqrt(dotProduct(v, v));
    }

    public static double[] crossProduct(double[] a, double[] b) {
        return new double[]{
                a[1] * b[2] - a[2] * b[1],
                a[2] * b[0] - a[0] * b[2],
                a[0] * b[1] - a[1] * b[0]
        };
    }

    public static double[][] matrixAdd(double[][] a, double[][] b) {
        int r = a.length, c = a[0].length;
        double[][] res = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    public static double[][] matrixMultiply(double[][] a, double[][] b) {
        int r = a.length, c = b[0].length, n = b.length;
        double[][] res = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                double sum = 0;
                for (int k = 0; k < n; k++) sum += a[i][k] * b[k][j];
                res[i][j] = sum;
            }
        return res;
    }

    public static double[][] matrixTranspose(double[][] m) {
        int r = m.length, c = m[0].length;
        double[][] t = new double[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) t[j][i] = m[i][j];
        return t;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double trace(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) sum += m[i][i];
        return sum;
    }

    public static double[][] scalarMultiply(double[][] m, double scalar) {
        double[][] res = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++) res[i][j] = m[i][j] * scalar;
        return res;
    }

    public static double[][] identityMatrix(int n) {
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        return res;
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;
        return new double[][]{
                {m[1][1] / det, -m[0][1] / det},
                {-m[1][0] / det, m[0][0] / det}
        };
    }
}
