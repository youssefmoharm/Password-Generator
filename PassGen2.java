import java.util.Random;
import java.util.Scanner;
public class PassGen2 {

    // Character sets
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:',.<>?";

    public void generateNewPassword(Scanner scanner, PassHist passwordHistory) {
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Ask user for character types
        System.out.println("Include the following character types? (Yes/No)");
        System.out.print("Letters (a-z, A-Z): ");
        boolean includeLetters = scanner.next().equalsIgnoreCase("Yes");
        System.out.print("Numbers (0-9): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Yes");
        System.out.print("Symbols (!@#$%^&*()): ");
        boolean includeSymbols = scanner.next().equalsIgnoreCase("Yes");

        // Build the character pool
        String characterPool = "";
        if (includeLetters) characterPool += LETTERS;
        if (includeNumbers) characterPool += NUMBERS;
        if (includeSymbols) characterPool += SYMBOLS;

        // Ensure at least one character type is selected
        if (characterPool.isEmpty()) {
            System.out.println("You must include at least one character type!");
            return;
        }

        // Generate the password
        String password = generatePassword(length, characterPool);

        // Display the password and its strength
        System.out.println("Generated Password: " + password);
        System.out.println("Password Strength: " + assessPasswordStrength(password));

        // Add to history
        PassHist.addPassword(password);
    }

    private String generatePassword(int length, String characterPool) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }
        return password.toString();
    }

    private String assessPasswordStrength(String password) {
        int length = password.length();
        boolean hasLetters = password.matches(".*[a-zA-Z].*");
        boolean hasNumbers = password.matches(".*[0-9].*");
        boolean hasSymbols = password.matches(".*[!@#$%^&*()\\-_=+\\[\\]{}|;:',.<>?].*");

        int score = 0;
        if (length >= 8) score++;  // Length criterion
        if (hasLetters) score++;  // Letters criterion
        if (hasNumbers) score++;  // Numbers criterion
        if (hasSymbols) score++;  // Symbols criterion

        if (score == 4) return "Strong";
        if (score == 3) return "Medium";
        return "Weak";
    }
}
