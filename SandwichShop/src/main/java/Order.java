import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    Scanner scanner = new Scanner(System.in);

    boolean orderMenuRunning = true;

    public void orderMenu(){
        List<Sandwich> sandwichList = new ArrayList<>();
        List<Drinks> drinkList = new ArrayList<>();
        List<Chips> chipsList = new ArrayList<>();

        System.out.println(""" 
            What would you like to add to your order?
            1. Add Sandwich
            2. Add Drink
            3. Add Chips
            4. Checkout
            5. Cancel
          
           """);

        while (orderMenuRunning){

            try {
                int userChoice =Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice){
                    case 1 -> addSandwich(); // for loop how many sandwiches // count variable (takes user input) // for iterations

                    case 2 -> addDrink();

                    case 3 -> addChips();

                    case 4 -> checkout();

                    case 0 -> orderMenuRunning = false;

                    default ->
                            System.out.println("Invalid entry. Try again");
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }

    }
    public createOrder
    public Sandwich addSandwich(){
        return new Sandwich().createSandwich();
    }
    public void addDrink(){

    }

    public void addChips(){}
    public void checkout(){}



}
