import java.util.ArrayList;
import java.util.List;

public class PassHist {

    private static final List<String> PassHist = new ArrayList<>();

    public static void addPassword(String password) {
        PassHist.add(password);
    }

    public void viewHistory() {
        if (PassHist.isEmpty()) {
            System.out.println("No passwords have been generated yet.");
        } else {
            System.out.println("\n=== Password History ===");
            for (int i = 0; i < PassHist.size(); i++) {
                System.out.println((i + 1) + ". " + PassHist.get(i));
            }
        }
    }
}
