import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean homeMenuRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            Order order = new Order(scanner);

            while (homeMenuRunning) {
                System.out.println("WELCOME TO THE BEST SANDWICH SHOP \n1. New order \n2. Exit-exit the application");
                int userInput = Integer.parseInt(scanner.nextLine().trim());
                switch (userInput) {
                    case 1:
                        System.out.println("Menu");
                        order.orderMenu();
                        break;
                    case 2:
                        System.out.println("Exit");
                        homeMenuRunning = false;
                        break;
                    default:
                        System.out.println("Try again");
                }
            }
        }
    }
}

