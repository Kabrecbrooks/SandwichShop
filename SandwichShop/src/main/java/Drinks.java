import java.util.List;
import java.util.Scanner;
// Class representing a drink item
public class Drinks {
    // Instance variables to store the drink's size, flavor, and price
    private String size;
    private String flavor;
    private double price;

    private static final List<String> drinkList = List.of(
            "Cola",
            "Pepsi",
            "Sprite",
            "Orange"
    );

    // Constructor to initialize a Drinks object with size and flavor
    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = getPrice(size);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", flavor, size, price);
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    // Overloaded method to determine price based on size input
    public double getPrice(String size) {
        if (size.equalsIgnoreCase("M")) {
            this.price = 2.50;
        } else if (size.equalsIgnoreCase("L")) {
            this.price = 3.00;
        } else {
            this.price = 2.00;
        }
        return this.price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // Static method to create a new drink based on user input
    public static Drinks createDrink(Scanner scanner) {
        Integer userChoice = null;
        // Loop until valid user choice is made
        while (userChoice == null) {
            System.out.println("Available drinks:");
            for (int i = 0; i < drinkList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, drinkList.get(i));
            }
            System.out.print("Select a drink by number: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= drinkList.size()) {
                    userChoice = choice;
                } else {
                    System.out.println("Invalid number. Please select from the list.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            System.out.print("What size? (S, M, L): ");
            String userDrinkSize = scanner.nextLine().trim().toUpperCase();
            String selectedDrink = drinkList.get(userChoice - 1);
            Drinks drink = new Drinks(userDrinkSize, selectedDrink);
            System.out.println("Selected drink: " + selectedDrink + ", Size: " + userDrinkSize + ", Price: $" + drink.getPrice());
            return drink;
        }
        // Should never reach here
        return null;
    }
}