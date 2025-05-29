import java.util.List;
import java.util.Scanner;

public class Sauces {

    public String name;
    public static final List<String> saucesList = List.of(
            "mayo",
            "mustard",
            "ketchup",
            "ranch",
            "thousand island",
            "vinaigrette"
    );

    public Sauces(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sauces createSauce(Scanner scanner) {
        Integer userChoice = null;
        while (userChoice == null) {
            System.out.println("Available sauces:");
            for (int i = 0; i < saucesList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, saucesList.get(i));
            }
            System.out.print("Select a sauce by number: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= saucesList.size()) {
                    userChoice = choice;
                } else {
                    System.out.println("Invalid number. Please select from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return new Sauces(saucesList.get(userChoice - 1));
    }

    @Override
    public String toString() {
        return name;
    }
}

