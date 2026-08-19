package schoolutils;

public class MatrixUtils {

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] m) {
        int r = m.length, c = m[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) t[j][i] = m[i][j];
        return t;
    }

    public static int[][] addMatrices(int[][] a, int[][] b) {
        int r = a.length, c = a[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int r = a.length, c = b[0].length, n = b.length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) sum += a[i][k] * b[k][j];
                res[i][j] = sum;
            }
        return res;
    }

    public static int[][] scalarMultiply(int[][] m, int scalar) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++) res[i][j] = m[i][j] * scalar;
        return res;
    }

    public static int[][] identityMatrix(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        return res;
    }

    public static boolean isSquare(int[][] m) {
        return m.length == m[0].length;
    }

    public static int sumAll(int[][] m) {
        int sum = 0;
        for (int[] row : m) for (int v : row) sum += v;
        return sum;
    }

    public static int trace(int[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) sum += m[i][i];
        return sum;
    }

    public static int[][] rotate90(int[][] m) {
        int n = m.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) res[j][n - 1 - i] = m[i][j];
        return res;
    }

    public static int[] flatten(int[][] m) {
        int size = 0;
        for (int[] row : m) size += row.length;
        int[] res = new int[size];
        int idx = 0;
        for (int[] row : m) for (int v : row) res[idx++] = v;
        return res;
    }
}
