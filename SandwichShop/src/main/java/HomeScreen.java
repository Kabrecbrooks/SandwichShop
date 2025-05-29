import java.util.Scanner;

public class HomeScreen {
    private static final Scanner scanner = new Scanner(System.in);

    public void display() {
        boolean running = true;
        while (running) {
            System.out.println("\n*** Home Screen ***");
            System.out.println("""
            1. New Order
            2. Exit""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());
                switch (userChoice) {
                    case 1:
                        Order order = new Order(scanner);
                        order.orderMenu();
                        break;
                    case 2:
                        System.out.println("Thank you! Bye.");
                        running = false;
                        break;
                    default:
                        System.out.println("Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

