import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private final Scanner scanner;
    private final List<Sandwich> sandwichList = new ArrayList<>();
    private final List<Drinks> drinkList = new ArrayList<>();
    private final List<Chips> chipsList = new ArrayList<>();
    private boolean orderMenuRunning = true;

    public Order(Scanner scanner) {
        this.scanner = scanner;
    }

    public void orderMenu() {
        orderMenuRunning = true;
        while (orderMenuRunning) {
            System.out.println("""
                What would you like to add to your order?
                1. Add Sandwich
                2. Add Drink
                3. Add Chips
                4. Checkout
                5. Cancel Order
                """);
            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());
                switch (userChoice) {
                    case 1 -> addSandwich();
                    case 2 -> addDrink();
                    case 3 -> addChips();
                    case 4 -> checkout();
                    case 5 -> {
                        System.out.println("Order cancelled.");
                        orderMenuRunning = false;
                    }
                    default -> System.out.println("Invalid entry. Try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void addSandwich() {
        Sandwich sandwich = Sandwich.createSandwich(scanner);
        sandwichList.add(sandwich);
        System.out.println("Sandwich added!");
    }

    public void addDrink() {
        Drinks drink = Drinks.createDrink(scanner);
        drinkList.add(drink);
        System.out.println("Drink added!");
    }

    public void addChips() {
        Chips chips = Chips.createChips(scanner);
        chipsList.add(chips);
        System.out.println("Chips added!");
    }

    public void checkout() {
        System.out.println("\nOrder summary:");
        double total = 0.0;
        StringBuilder receipt = new StringBuilder();

        if (!sandwichList.isEmpty()) {
            receipt.append("Sandwiches:\n");
            for (Sandwich s : sandwichList) {
                receipt.append(s).append("\n");
                total += s.calculatePrice();
            }
        }

        if (!drinkList.isEmpty()) {
            receipt.append("Drinks:\n");
            for (Drinks d : drinkList) {
                receipt.append(d).append("\n");
                total += d.getPrice();
            }
        }

        if (!chipsList.isEmpty()) {
            receipt.append("Chips:\n");
            for (Chips c : chipsList) {
                receipt.append(c).append("\n");
                total += c.getPrice();
            }
        }

        receipt.append(String.format("Total: $%.2f%n", total));
        receipt.append("Thank you for your order!\n");

        System.out.print(receipt);

        System.out.print("Would you like to place this order? (Y/N): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            try {
                File receiptsDir = new File("receipts");
                if (!receiptsDir.exists()) {
                    receiptsDir.mkdir();
                }
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
                File receiptFile = new File(receiptsDir, timestamp + ".txt");
                try (FileWriter writer = new FileWriter(receiptFile)) {
                    writer.write(receipt.toString());
                }
                System.out.println("Receipt saved to: " + receiptFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Could not save receipt: " + e.getMessage());
            }
            System.out.println("Order placed! Thank you!");
            orderMenuRunning = false;
        } else {
            System.out.println("Order cancelled.");
            orderMenuRunning = false;
        }
    }
}
