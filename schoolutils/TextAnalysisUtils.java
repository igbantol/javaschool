package schoolutils;

public class TextAnalysisUtils {

    public static int countChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) if (ch == c) count++;
        return count;
    }

    public static int countSentences(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '.' || ch == '!' || ch == '?') count++;
        }
        return count;
    }

    public static String longestWord(String s) {
        String best = "";
        for (String w : s.split("\\s+")) {
            if (w.length() > best.length()) best = w;
        }
        return best;
    }

    public static String shortestWord(String s) {
        String best = null;
        for (String w : s.split("\\s+")) {
            if (best == null || w.length() < best.length()) best = w;
        }
        return best == null ? "" : best;
    }

    public static boolean isAnagram(String a, String b) {
        String x = a.replace(" ", "").toLowerCase();
        String y = b.replace(" ", "").toLowerCase();
        if (x.length() != y.length()) return false;
        int[] counts = new int[26];
        for (char c : x.toCharArray()) counts[c - 'a']++;
        for (char c : y.toCharArray()) counts[c - 'a']--;
        for (int n : counts) if (n != 0) return false;
        return true;
    }

    public static char mostFrequentChar(String s) {
        int[] counts = new int[256];
        char best = s.isEmpty() ? ' ' : s.charAt(0);
        for (char c : s.toCharArray()) {
            counts[c]++;
            if (counts[c] > counts[best]) best = c;
        }
        return best;
    }

    public static String replaceVowels(String s, char replacement) {
        StringBuilder b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) b.append(replacement);
            else b.append(c);
        }
        return b.toString();
    }

    public static boolean isIsogram(String s) {
        String lower = s.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            if (Character.isLetter(lower.charAt(i))
                    && lower.indexOf(lower.charAt(i)) != lower.lastIndexOf(lower.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int countDigits(String s) {
        int count = 0;
        for (char c : s.toCharArray()) if (Character.isDigit(c)) count++;
        return count;
    }

    public static int countSpecialChars(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) count++;
        }
        return count;
    }
}
