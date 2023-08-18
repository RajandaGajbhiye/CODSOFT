import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter 
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);

		System.out.println("Word Counter");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");

		int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

		String inputText = "";

		if (choice == 1)
			{
            System.out.print("Enter your text: ");
            inputText = scanner.nextLine();
            } 
		else if (choice == 2) 
			{
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try 
				{
                inputText = readFile(filePath);
                } 
			catch (FileNotFoundException e) 
				{
                System.out.println("File not found.");
                scanner.close();
                return;
                }
			} 
		else 
			{
            System.out.println("Invalid choice.");
            scanner.close();
            return;
            }

		// Split the input text into an array of words
        String[] words = inputText.split("[\\s\\p{Punct}]+");

		int wordCount = words.length;

		// Ignoring common words
        String[] commonWords = {"the", "and", "is", "in", "it", "of", "to", "a", "for", "on"};
        int nonCommonWordCount = 0;

        Map<String, Integer> wordFrequency = new HashMap<>();

		for (String word : words) 
			{
            if (!isCommonWord(word, commonWords)) 
				{
                nonCommonWordCount++;
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
                }
            }

		// Display results
        System.out.println("Total words (including common words): " + wordCount);
        System.out.println("Total non-common words: " + nonCommonWordCount);

        // Display word frequency statistics
        System.out.println("\nWord Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) 
			{
			System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        scanner.close();
    }

	private static String readFile(String filePath) throws FileNotFoundException 
		{
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) 
			{
            content.append(fileScanner.nextLine()).append(" ");
            }
        fileScanner.close();
        return content.toString();
        }

		private static boolean isCommonWord(String word, String[] commonWords) 
			{
			for (String commonWord : commonWords) 
			  {
                if (word.equalsIgnoreCase(commonWord)) 
				{
                return true;
                }
              }
              return false;
	        }
}
