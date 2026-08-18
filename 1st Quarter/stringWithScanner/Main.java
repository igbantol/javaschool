import java.util.Scanner;

class ExplorerProfile {

    String name;
    String language;
    String dreamProject;
    String aiAnswer;
    String secretPhrase;

    ExplorerProfile(String name, String language, String dreamProject,
                    String aiAnswer, String secretPhrase) {
        this.name = name;
        this.language = language;
        this.dreamProject = dreamProject;
        this.aiAnswer = aiAnswer;
        this.secretPhrase = secretPhrase;
    }

    void displayProfile() {
        System.out.println("\n========================================");
        System.out.println("      DIGITAL EXPLORER PROFILE");
        System.out.println("========================================");

        System.out.println("CODENAME : " + name.toUpperCase());
        System.out.println("Language : " + language.toLowerCase());

        System.out.println("\n--- SYSTEM ANALYSIS ---");

        if (language.toLowerCase().equals("java")) {
            System.out.println("Java detected! You chose the language of classes and objects.");
        } else {
            System.out.println(language + " sounds like an interesting choice!");
        }

        if (aiAnswer.equalsIgnoreCase("yes")) {
            System.out.println("You are ready to work with Artificial Intelligence.");
        } else {
            System.out.println("Perhaps AI will convince you someday.");
        }

        String project = dreamProject.toLowerCase();

        if (project.contains("game")) {
            System.out.println("CLASSIFICATION: Game Developer");
        } else if (project.contains("robot")) {
            System.out.println("CLASSIFICATION: Robotics Engineer");
        } else if (project.contains("ai")) {
            System.out.println("CLASSIFICATION: AI Developer");
        } else if (project.contains("app")) {
            System.out.println("CLASSIFICATION: App Developer");
        } else {
            System.out.println("CLASSIFICATION: Creative Technologist");
        }

        if (secretPhrase.toLowerCase().contains("code")) {
            System.out.println("BONUS ACHIEVEMENT: Code Master unlocked!");
        }

        System.out.println("\nDream Project: " + dreamProject);
        System.out.println("Secret Phrase: " + secretPhrase.toUpperCase());

        System.out.println("\n========================================");
        System.out.println("       SCAN COMPLETE - ACCESS GRANTED");
        System.out.println("========================================");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("     DIGITAL EXPLORER SCANNER v1.0");
        System.out.println("========================================");
        System.out.println("Answer 5 questions to discover your");
        System.out.println("technology explorer profile!\n");

        System.out.print("1. What is your name / codename? ");
        String name = input.nextLine();

        System.out.print("2. What programming language do you like? ");
        String language = input.nextLine();

        System.out.print("3. What would you like to create someday? ");
        String project = input.nextLine();

        System.out.print("4. Would you work with AI? (yes/no): ");
        String ai = input.nextLine();

        System.out.print("5. Enter your secret technology phrase: ");
        String phrase = input.nextLine();

        ExplorerProfile explorer =
                new ExplorerProfile(name, language, project, ai, phrase);

        explorer.displayProfile();

        input.close();
    }
}
