import java.io.*;
import java.util.*;

public class word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counter");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String text = "";

        if (choice == 1) {
            System.out.print("Enter your text: ");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter the path to the file: ");
            String filePath = scanner.nextLine();
            text = readFile(filePath);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total words: " + wordCount);

        // You can add more features like stop words and word frequency analysis here
        
        scanner.close();
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }
}