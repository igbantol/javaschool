package schoolutils;

public class StringUtils {

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return a.equalsIgnoreCase(b);
    }

    public static boolean contains(String a, String b) {
        return a.toLowerCase().contains(b.toLowerCase());
    }

    public static int length(String s) {
        return s.length();
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        String r = reverse(s).toLowerCase();
        return s.toLowerCase().equals(r);
    }

    public static String trimSpaces(String s) {
        return s.trim();
    }

    public static int countWords(String s) {
        if (s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    public static String capitalize(String s) {
        if (s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static int countVowels(String s) {
        int c = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) c++;
        }
        return c;
    }

    public static int countConsonants(String s) {
        int c = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) < 0) c++;
        }
        return c;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String repeat(String s, int times) {
        return s.repeat(Math.max(0, times));
    }

    public static String padLeft(String s, int length) {
        while (s.length() < length) s = " " + s;
        return s;
    }

    public static String padRight(String s, int length) {
        while (s.length() < length) s = s + " ";
        return s;
    }

    public static String replaceAll(String s, String find, String replace) {
        return s.replace(find, replace);
    }

    public static String firstLetter(String s) {
        return s.isEmpty() ? "" : String.valueOf(s.charAt(0));
    }

    public static String lastLetter(String s) {
        return s.isEmpty() ? "" : String.valueOf(s.charAt(s.length() - 1));
    }

    public static String substring(String s, int start, int end) {
        return s.substring(start, end);
    }

    public static String removeSpaces(String s) {
        return s.replace(" ", "");
    }

    public static String initials(String fullName) {
        StringBuilder b = new StringBuilder();
        for (String part : fullName.trim().split("\\s+")) {
            b.append(part.charAt(0));
        }
        return b.toString().toUpperCase();
    }
}
