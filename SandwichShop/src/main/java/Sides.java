import java.util.List;
import java.util.Scanner;

public class Sides {

    public String name;
    public static final List<String> sidesList = List.of(
            "Au jus",
            "sauce"
    );

    public Sides(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sides createSide(Scanner scanner) {
        Integer userChoice = null;
        while (userChoice == null) {
            System.out.println("Available sides:");
            for (int i = 0; i < sidesList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, sidesList.get(i));
            }
            System.out.print("Select a side by number: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sidesList.size()) {
                    userChoice = choice;
                } else {
                    System.out.println("Invalid number. Please select from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return new Sides(sidesList.get(userChoice - 1));
    }

    @Override
    public String toString() {
        return name;
    }
}

