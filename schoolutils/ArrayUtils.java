package schoolutils;

public class ArrayUtils {

    public static int sum(int[] arr) {
        int s = 0;
        for (int n : arr) s += n;
        return s;
    }

    public static int max(int[] arr) {
        int m = arr[0];
        for (int n : arr) m = Math.max(m, n);
        return m;
    }

    public static int min(int[] arr) {
        int m = arr[0];
        for (int n : arr) m = Math.min(m, n);
        return m;
    }

    public static double average(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    public static boolean contains(int[] arr, int value) {
        for (int n : arr) if (n == value) return true;
        return false;
    }

    public static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == value) return i;
        return -1;
    }

    public static int[] reverse(int[] arr) {
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length; i++) r[i] = arr[arr.length - 1 - i];
        return r;
    }

    public static void print(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    public static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i] < arr[i - 1]) return false;
        return true;
    }

    public static int[] evenNumbers(int[] arr) {
        int count = 0;
        for (int n : arr) if (n % 2 == 0) count++;
        int[] r = new int[count];
        int i = 0;
        for (int n : arr) if (n % 2 == 0) r[i++] = n;
        return r;
    }

    public static int[] oddNumbers(int[] arr) {
        int count = 0;
        for (int n : arr) if (n % 2 != 0) count++;
        int[] r = new int[count];
        int i = 0;
        for (int n : arr) if (n % 2 != 0) r[i++] = n;
        return r;
    }

    public static String join(int[] arr, String sep) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            b.append(arr[i]);
            if (i < arr.length - 1) b.append(sep);
        }
        return b.toString();
    }

    public static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > largest) {
                second = largest;
                largest = n;
            } else if (n > second && n != largest) {
                second = n;
            }
        }
        return second;
    }

    public static int countOccurrences(int[] arr, int value) {
        int c = 0;
        for (int n : arr) if (n == value) c++;
        return c;
    }

    public static int[] generateSequence(int start, int end) {
        int[] r = new int[end - start + 1];
        for (int i = start; i <= end; i++) r[i - start] = i;
        return r;
    }

    public static double sum(double[] arr) {
        double s = 0;
        for (double n : arr) s += n;
        return s;
    }
}
