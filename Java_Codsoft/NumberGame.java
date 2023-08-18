import java.util.Scanner;
import java.util.Random;

class NumberGame 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        boolean playAgain = true;

		while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("Welcome to the Number Game!");
            System.out.println("You have to choose a number between " + minRange + " and " + maxRange + ".");
            System.out.println("Try to guess it within " + maxAttempts + " attempts.");

			while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                
				if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + (attempts + 1) + " attempts.");
                    score++;
                    break;
                }
                
                attempts++;
            }

			if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber + ".");
            }

            System.out.println("Your current score: " + score);
      
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

		System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
	}
}
