import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    Scanner scanner = new Scanner(System.in);
    private boolean toasted;
    private double price;
    List<Toppings> toppings;
    List<Sauces> sauces;
    List<Sides> sides;


    public Sandwich(){}

    public Sandwich(Bread bread, boolean toasted,List<Toppings> toppings, List<Sauces>sauces, List<Sides>sides) {
        this.toasted = toasted;
        this.price = getPrice(bread);
        this.toppings = toppings;
        this.sauces = sauces;
        this.sides = sides;

    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double getPrice(Bread bread) {
        double sandwichCost = 0.0;
        sandwichCost += bread.getPrice(bread.getSize());

        if(toppings != null){
            for (Toppings topping : toppings){
                sandwichCost += topping.getPrice();
            }
        }
        return sandwichCost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Sandwich createSandwich (){
        Bread bread = new Bread().createBread();
        toppingsPrompt(bread);
        addSauces();
        addSides();
        System.out.println("Would you like it toasted?");
        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        return new Sandwich(bread,toasted,this.toppings, this.sauces, this.sides);
    }
    public void toppingsPrompt(Bread bread){
        //Topping Prompts
        this.toppings = new ArrayList<>();

        boolean selectionProcess = true;

        while (selectionProcess) {

            System.out.println("""
                    What topping you would like to add:
                    
                    (1.) Meat Toppings.
                    (2.) Cheese Toppings.
                    (3.) Regular Toppings.
                    (4.) Back""");
            try {
                int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());
                switch (userToppingSelect) {
                    case 1 -> createMeatTopping(bread);
                    case 2 -> createCheeseTopping(bread);
                    case 3 -> regularTopping();
                    case 4 -> {
                        System.out.println("Done selecting Toppings");
                        selectionProcess = false;}
                    default -> System.out.println("Wrong input please try again");}
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");}
        }
    }

    public void createMeatTopping(Bread bread){

        while (true) {
            System.out.println("What kind of meat would you like? (Type 'done' to go back)");
            MeatToppings.meatList.forEach(System.out :: println);
            String userMeat = scanner.nextLine().trim().toLowerCase();

            if(userMeat.equalsIgnoreCase("done")) break;
            if (MeatToppings.meatList.contains(userMeat)){
                System.out.println("Would you like extra meat for an additional price? (Y/N)");
                boolean extraMeat = scanner.nextLine().trim().equalsIgnoreCase("Y");
                Toppings meatTopping = new MeatToppings(userMeat,bread, extraMeat);
                this.toppings.add(meatTopping);

                System.out.printf("Added: %s\n", userMeat);
            }else {
                System.out.println("Sorry, we don't have this meat topping. Try again.");

            }
        }
    }

    public void createCheeseTopping(Bread bread){

        while (true) {
            System.out.println("What kind of cheese would you like? (Type 'done' to go back)");
            CheeseToppings.cheeseList.forEach(System.out :: println);
            String userCheese = scanner.nextLine().trim().toLowerCase();

            if(userCheese.equalsIgnoreCase("done")) break;
            if (CheeseToppings.cheeseList.contains(userCheese)){
                System.out.println("Would you like extra cheese for an additional price? (Y/N)");
                boolean extraCheese = scanner.nextLine().trim().equalsIgnoreCase("Y");
                Toppings cheeseTopping = new CheeseToppings(userCheese,bread, extraCheese);
                this.toppings.add(cheeseTopping);
                System.out.printf("Added: %s\n", userCheese);
            }else {
                System.out.println("Sorry, we don't have this cheese topping. Try again.");
            }
        }
    }
    public void regularTopping(){

        while (true) {
            System.out.println("Please select a Regular topping (type 'done' to go back):");
            RegularToppings.regularToppingList.forEach(System.out::println);

            String userRegularTopping = scanner.nextLine().trim().toLowerCase();

            if(userRegularTopping.equalsIgnoreCase("done")) break;

            if(RegularToppings.regularToppingList.contains(userRegularTopping)){
                RegularToppings regularTopping = new RegularToppings(userRegularTopping);
                this.toppings.add(regularTopping);

                System.out.printf("Added: %s\n", userRegularTopping);
            }else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }
        }
    }
    public void addSauces(){
        while(true) {
            System.out.println("Please select a Sauce (type 'DONE' to go back):");
            Sauces.saucesList.forEach(System.out::println);

            String userSauce = scanner.nextLine().trim().toLowerCase();

            if(userSauce.equalsIgnoreCase("done")) break;

            if(Sauces.saucesList.contains(userSauce)){
                Sauces sauce = new Sauces(userSauce);
                this.sauces.add(sauce);
                System.out.printf("Added: %s\n", userSauce);
            } else {
                System.out.println("Sorry we don't have this sauce.");
            }
        }
    }
    public void addSides(){

        while (true) {
            System.out.println("Please select a side (type 'done' to go back):");
            Sides.sidesList.forEach(System.out::println);

            String userSide = scanner.nextLine().trim().toLowerCase();

            if(userSide.equalsIgnoreCase("done")) break;

            if(Sides.sidesList.contains(userSide)){
                Sides side = new Sides(userSide);
                this.sides.add(side);
                System.out.printf("Added: %s\n", userSide);
            } else {
                System.out.println("Sorry we don't have this sauce");
            }
        }
    }
    // fix this at the end
    @Override
    public String toString() {
        return "Sandwich" + " | " +
                "price=" + price +
                ", isToasted=" + isToasted +
                ", breadSize='" + breadSize + '\'' +
                ", breadType='" + breadType + '\'' +
                '}';
    }

}
