import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" WELCOME TO THE BEST SANDWICH SHOP \n" +
                "1. New order \n 2. Exit" );

        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        int userInput = Integer.parseInt(scanner.nextLine().trim());

        boolean homeMenuRunning = true;

            while (homeMenuRunning) {
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
