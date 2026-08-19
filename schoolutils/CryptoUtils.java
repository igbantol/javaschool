package schoolutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtils {

    public static String caesarEncrypt(String text, int shift) {
        StringBuilder b = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                b.append((char) ((c - base + shift) % 26 + base));
            } else b.append(c);
        }
        return b.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - (shift % 26));
    }

    public static String rot13(String text) {
        return caesarEncrypt(text, 13);
    }

    public static String atbash(String text) {
        StringBuilder b = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) b.append((char) ('Z' - c + 'A'));
            else if (Character.isLowerCase(c)) b.append((char) ('z' - c + 'a'));
            else b.append(c);
        }
        return b.toString();
    }

    public static String reverseCipher(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static String xorCipher(String text, char key) {
        StringBuilder b = new StringBuilder();
        for (char c : text.toCharArray()) b.append((char) (c ^ key));
        return b.toString();
    }

    public static String vigenereEncrypt(String text, String key) {
        StringBuilder b = new StringBuilder();
        int ki = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int k = Character.toLowerCase(key.charAt(ki % key.length())) - 'a';
                b.append((char) ((c - base + k) % 26 + base));
                ki++;
            } else b.append(c);
        }
        return b.toString();
    }

    public static String vigenereDecrypt(String text, String key) {
        StringBuilder b = new StringBuilder();
        int ki = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int k = Character.toLowerCase(key.charAt(ki % key.length())) - 'a';
                b.append((char) ((c - base - k + 26) % 26 + base));
                ki++;
            } else b.append(c);
        }
        return b.toString();
    }

    public static String simpleHash(String text) {
        int hash = 7;
        for (char c : text.toCharArray()) hash = hash * 31 + c;
        return Integer.toHexString(hash);
    }

    public static String sha256Hex(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(text.getBytes());
            StringBuilder b = new StringBuilder();
            for (byte x : bytes) b.append(String.format("%02x", x));
            return b.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static String base64Encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String base64Decode(String encoded) {
        return new String(Base64.getDecoder().decode(encoded));
    }
}
