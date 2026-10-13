package quarter1.guesser;

import java.util.Random;
import java.util.Scanner;

public class Guesser {

    private static final String USERNAME = "igbantol";
    private static final String PASSWORD = "hashedpassword123";
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!login(scanner)) {
            System.out.println("Too many failed attempts. Access denied.");
            scanner.close();
            return;
        }

        System.out.println("Login successful! Welcome to the game.");
        playGame(scanner, new Random());
        scanner.close();
    }

    private static boolean login(Scanner scanner) {
        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
            System.out.print("Username: ");
            String username = scanner.next();

            System.out.print("Password: ");
            String password = scanner.next();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                return true;
            }

            System.out.println("Invalid credentials. Attempts left: "
                    + (MAX_LOGIN_ATTEMPTS - attempt));
        }
        return false;
    }

    private static void playGame(Scanner scanner, Random random) {
        int attempts = 0, upperBound = 0;
        System.out.println("=".repeat(27));
        System.out.println("HELLO, WELCOME TO GUESSING NUMBER GAME");
        System.out.println("Choose a range:");
        System.out.println("  1 - From 0 to 30");
        System.out.println("  2 - From 0 to 70");
        System.out.println("  3 - From 0 to 100");
        System.out.println("=".repeat(27));
        while (true) {
            System.out.print("Enter your choice: ");
            int rangeChoice = scanner.nextInt();

            if (rangeChoice < 1 || rangeChoice > 3) {
                System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                continue;
            }

            if (rangeChoice == 1) {
                upperBound = 30;
            } else if (rangeChoice == 2) {
                upperBound = 70;
            } else {
                upperBound = 100;
            }
            int secretNumber = random.nextInt(upperBound + 1);

            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("The number is: " + secretNumber);
                    System.out.println("You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < secretNumber) {
                    System.out.println("Wrong guess. Try a higher number.");
                } else {
                    System.out.println("Wrong guess. Try a lower number.");
                }
            }
            break;
        }
    }
}
