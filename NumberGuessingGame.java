import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private int score = 0;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }

    public void startGame() {
        System.out.println("===========================================");
        System.out.println("Welcome to the Professional Number Guessing Game! ");
        System.out.println("===========================================");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nChoose a difficulty level:");
            System.out.println("1. Easy (1-50, 15 attempts)");
            System.out.println("2. Medium (1-100, 10 attempts)");
            System.out.println("3. Hard (1-200, 7 attempts)");

            int range = 0;
            int maxAttempts = 0;

            while (true) {
                try {
                    System.out.print("Enter your choice (1/2/3): ");
                    int difficulty = Integer.parseInt(scanner.nextLine());
                    if (difficulty == 1) {
                        range = 50;
                        maxAttempts = 15;
                        break;
                    } else if (difficulty == 2) {
                        range = 100;
                        maxAttempts = 10;
                        break;
                    } else if (difficulty == 3) {
                        range = 200;
                        maxAttempts = 7;
                        break;
                    } else {
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            playRound(range, maxAttempts);

            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThank you for playing! ");
        System.out.println("Final Score: " + score);
        System.out.println("Goodbye!");
    }

    public void playRound(int range, int maxAttempts) {
        Random random = new Random();
        int secretNumber = random.nextInt(range) + 1;
        int attemptsLeft = maxAttempts;
        boolean guessedCorrectly = false;

        System.out.println("\nI have selected a number between 1 and " + range + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attemptsLeft > 0 && !guessedCorrectly) {
            try {
                System.out.print("\nAttempts remaining: " + attemptsLeft + ". Your guess: ");
                int guess = Integer.parseInt(scanner.nextLine());
                attemptsLeft--;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    score += attemptsLeft + 1; // Bonus points for remaining attempts
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println(" You've run out of attempts. The correct number was " + secretNumber + ".");
        }

        System.out.println("Current Score: " + score);
    }
}
