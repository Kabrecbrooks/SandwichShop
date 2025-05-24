import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);

    boolean orderMenuRunning = true;

    public void orderMenu() {

        System.out.println("""
                Select from the following options
                1. Add Sandwich
                2. Add Drink
                3. Add Chips
                4. Checkout
                5. Cancel
                """);

        while (orderMenuRunning) {

            try{
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice){
                    case 1 -> addSandwich();

                    case 2 -> addDrink();

                    case 3 -> addChips();

                    case 4 -> checkout();

                    case 5 -> orderMenu();

                    default ->
                        System.out.println("Invalid Entry");

                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }


    }
    public void addSandwich(){
        System.out.println("Would you like it toasted? (Y/N)");

        boolean userChoice = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("Yes");

    }
    public void addDrink(){
    }

    public void addChips(){}
    public void checkout(){}
}
