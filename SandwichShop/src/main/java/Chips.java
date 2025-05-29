import java.util.List;
import java.util.Scanner;

public class Chips {

    private static final List<String> chipsList = List.of(
            "Cheetos",
            "Doritos",
            "Lays"
    );
    private final double price;
    private String name;

    public Chips(String name) {
        this.price = 1.50;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public static Chips createChips(Scanner scanner) {
        Integer userChoice = null;
        while (userChoice == null) {
            System.out.println("Available chips:");
            for (int i = 0; i < chipsList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, chipsList.get(i));
            }
            System.out.print("Select chips by number: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= chipsList.size()) {
                    userChoice = choice;
                } else {
                    System.out.println("Invalid number. Please select from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return new Chips(chipsList.get(userChoice - 1));
    }
}