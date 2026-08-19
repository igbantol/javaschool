package schoolutils;

public class DataStructuresUtils {

    public static int[] removeDuplicates(int[] arr) {
        int[] temp = new int[arr.length];
        int size = 0;
        for (int v : arr) {
            boolean found = false;
            for (int i = 0; i < size; i++) if (temp[i] == v) found = true;
            if (!found) temp[size++] = v;
        }
        int[] res = new int[size];
        System.arraycopy(temp, 0, res, 0, size);
        return res;
    }

    public static int[] union(int[] a, int[] b) {
        int[] combined = new int[a.length + b.length];
        System.arraycopy(a, 0, combined, 0, a.length);
        System.arraycopy(b, 0, combined, a.length, b.length);
        return removeDuplicates(combined);
    }

    public static int[] intersection(int[] a, int[] b) {
        int[] temp = new int[a.length];
        int size = 0;
        for (int v : a) if (ArrayUtils.contains(b, v)) temp[size++] = v;
        int[] res = new int[size];
        System.arraycopy(temp, 0, res, 0, size);
        return removeDuplicates(res);
    }

    public static int[] difference(int[] a, int[] b) {
        int[] temp = new int[a.length];
        int size = 0;
        for (int v : a) if (!ArrayUtils.contains(b, v)) temp[size++] = v;
        int[] res = new int[size];
        System.arraycopy(temp, 0, res, 0, size);
        return res;
    }

    public static boolean isSubset(int[] subset, int[] set) {
        for (int v : subset) if (!ArrayUtils.contains(set, v)) return false;
        return true;
    }

    public static int secondLargest(int[] arr) {
        return ArrayUtils.secondLargest(arr);
    }

    public static int kthLargest(int[] arr, int k) {
        int[] copy = arr.clone();
        AlgorithmUtils.bubbleSort(copy);
        return copy[arr.length - k];
    }

    public static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        k = k % n;
        for (int i = 0; i < n; i++) res[(i + k) % n] = arr[i];
        return res;
    }

    public static int mostFrequent(int[] arr) {
        int best = arr[0], maxCount = 0;
        for (int v : arr) {
            int count = ArrayUtils.countOccurrences(arr, v);
            if (count > maxCount) {
                maxCount = count;
                best = v;
            }
        }
        return best;
    }

    public static int[] compress(int[] arr) {
        int[] res = new int[arr.length];
        int size = 0;
        for (int v : arr) if (size == 0 || res[size - 1] != v) res[size++] = v;
        int[] out = new int[size];
        System.arraycopy(res, 0, out, 0, size);
        return out;
    }
}
