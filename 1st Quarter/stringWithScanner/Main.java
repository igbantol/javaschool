import java.util.Scanner;

public class Main {

    static String normalize(String text) {
        return text.toLowerCase()
                   .replace(" ", "")
                   .replace("(", "")
                   .replace(")", "")
                   .replace(";", "")
                   .replace(".", "")
                   .replace(",", "")
                   .replace("-", "")
                   .trim();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final String[] questions = {
            "1. What keyword is used to declare a class in Java?",
            "2. Which method reads a full line of text from the keyboard?",
            "3. What string method compares two strings ignoring case?",
            "4. What method checks if one string contains another?",
            "5. What method converts a string to all uppercase letters?"
        };

        final String[] answers = {
            "class",
            "nextline",
            "equalsignorecase",
            "contains",
            "touppercase"
        };

        int score = 0;

        System.out.println("========================================");
        System.out.println("        JAVA BASICS QUIZ v1.0");
        System.out.println("========================================");
        System.out.println("Answer the 5 short-response questions!\n");

        String[] userAnswers = new String[5];

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i] + " ");
            userAnswers[i] = input.nextLine();

            String given = normalize(userAnswers[i]);
            String key = answers[i];

            if (given.equals(key) || given.contains(key)
                    || (given.length() >= 4 && key.contains(given))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The answer is: " + answers[i].toUpperCase() + "\n");
            }
        }

        System.out.println("========================================");
        System.out.println("              QUIZ RESULTS");
        System.out.println("========================================");
        System.out.println("Your score: " + score + " out of " + questions.length);

        int percent = (score * 100) / questions.length;

        if (percent == 100) {
            System.out.println("PERFECT! You are a Java Master!");
        } else if (percent >= 60) {
            System.out.println("Good job! Keep practicing.");
        } else {
            System.out.println("Keep studying the basics!");
        }

        System.out.println("========================================");

        input.close();
    }
}
