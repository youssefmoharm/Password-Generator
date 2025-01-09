import java.util.Scanner;

public class PassGen {

    private static final PassGen2 passwordGenerator = new PassGen2();
    private static final PassHist passwordHistory = new PassHist();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Password Generator Menu ===");
            System.out.println("1. Generate a new password");
            System.out.println("2. View password history");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    passwordGenerator.generateNewPassword(scanner, passwordHistory);
                    break;
                case 2:
                    passwordHistory.viewHistory();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye thanks !");
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
                    break;
            }
        }
    }
}
