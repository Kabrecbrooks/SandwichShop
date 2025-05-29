import java.util.List;
import java.util.Scanner;

public class CheeseToppings extends Toppings {

    public static List<String> cheeseList = List.of(
            "American",
            "Swiss",
            "Provolone",
            "Pepper Jack"
    );

    public CheeseToppings(String name, Bread bread, boolean extra) {
        super(name, extra, getPrice(bread, extra));
    }

    public static CheeseToppings createTopping(Scanner scanner, Bread bread) {
        Integer userChoice = null;
        while (userChoice == null) {
            System.out.println("What kind of cheese would you like?");
            for (int i = 0; i < cheeseList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, cheeseList.get(i));
            }
            System.out.print("Select a cheese by number: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= cheeseList.size()) {
                    userChoice = choice;
                } else {
                    System.out.println("Invalid number. Please select from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        String userCheese = cheeseList.get(userChoice - 1);
        System.out.println("Would you like extra cheese for an additional price? (Y/N)");
        boolean extraCheese = scanner.nextLine().trim().equalsIgnoreCase("Y");
        return new CheeseToppings(userCheese, bread, extraCheese);
    }

    private static double getPrice(Bread bread, boolean isExtra) {
        return switch (bread.getSize()) {
            case "4" -> isExtra ? 1.05 : 0.75;
            case "8" -> isExtra ? 2.10 : 1.50;
            case "12" -> isExtra ? 3.15 : 2.25;
            default -> 0.75;
        };
    }
}
