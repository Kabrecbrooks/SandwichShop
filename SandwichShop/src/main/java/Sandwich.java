import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private boolean toasted;
    private double price;
    private Bread bread;
    private List<Toppings> toppings;
    private List<Sauces> sauces;
    private List<Sides> sides;

    public Sandwich() {
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public Sandwich(Bread bread, boolean toasted, List<Toppings> toppings, List<Sauces> sauces, List<Sides> sides) {
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.sauces = sauces != null ? sauces : new ArrayList<>();
        this.sides = sides != null ? sides : new ArrayList<>();
        this.price = calculatePrice();
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double calculatePrice() {
        double sandwichCost = 0.0;
        if (bread != null) {
            sandwichCost += bread.getPrice(bread.getSize());
        }
        if (toppings != null) {
            for (Toppings topping : toppings) {
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

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public static Sandwich createSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich();
        sandwich.bread = Bread.createBread(scanner);

        sandwich.toppingsPrompt(scanner, sandwich.bread);
        sandwich.addSauces(scanner);
        sandwich.addSides(scanner);

        System.out.println("Would you like it toasted? (yes/no)");
        sandwich.toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        sandwich.price = sandwich.calculatePrice();
        return sandwich;
    }

    public void toppingsPrompt(Scanner scanner, Bread bread) {
        boolean selectionProcess = true;
        while (selectionProcess) {
            System.out.println("""
                    What topping would you like to add:
                    (1.) Meat Toppings
                    (2.) Cheese Toppings
                    (3.) Regular Toppings
                    (4.) Back""");
            try {
                int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());
                switch (userToppingSelect) {
                    case 1 -> createMeatTopping(scanner, bread);
                    case 2 -> createCheeseTopping(scanner, bread);
                    case 3 -> regularTopping(scanner);
                    case 4 -> {
                        System.out.println("Done selecting Toppings");
                        selectionProcess = false;
                    }
                    default -> System.out.println("Wrong input, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void createMeatTopping(Scanner scanner, Bread bread) {
        while (true) {
            System.out.println("What kind of meat would you like? (Type 'done' to go back)");
            MeatToppings.meatList.forEach(System.out::println); // Accessing the static list
            String userMeat = scanner.nextLine().trim();
            if (userMeat.equalsIgnoreCase("done")) break;

            // Case-insensitive match
            String matchedMeat = MeatToppings.meatList.stream()
                    .filter(m -> m.equalsIgnoreCase(userMeat))
                    .findFirst().orElse(null);

            if (matchedMeat != null) {
                System.out.println("Would you like extra meat for an additional price? (Y/N)");
                boolean extraMeat = scanner.nextLine().trim().equalsIgnoreCase("Y");
                Toppings meatTopping = new MeatToppings(matchedMeat, bread, extraMeat);
                this.toppings.add(meatTopping);
                System.out.printf("Added: %s\n", matchedMeat);
            } else {
                System.out.println("Sorry, we don't have this meat topping. Try again.");
            }
        }
    }

    public void createCheeseTopping(Scanner scanner, Bread bread) {
        while (true) {
            System.out.println("What kind of cheese would you like? (Type 'done' to go back)");
            CheeseToppings.cheeseList.forEach(System.out::println);
            String userCheese = scanner.nextLine().trim();
            if (userCheese.equalsIgnoreCase("done")) break;

            String matchedCheese = CheeseToppings.cheeseList.stream()
                    .filter(c -> c.equalsIgnoreCase(userCheese))
                    .findFirst().orElse(null);

            if (matchedCheese != null) {
                System.out.println("Would you like extra cheese for an additional price? (Y/N)");
                boolean extraCheese = scanner.nextLine().trim().equalsIgnoreCase("Y");
                Toppings cheeseTopping = new CheeseToppings(matchedCheese, bread, extraCheese);
                this.toppings.add(cheeseTopping);
                System.out.printf("Added: %s\n", matchedCheese);
            } else {
                System.out.println("Sorry, we don't have this cheese topping. Try again.");
            }
        }
    }

    public void regularTopping(Scanner scanner) {
        while (true) {
            System.out.println("Please select a Regular topping (type 'done' to go back):");
            RegularToppings.regularToppingList.forEach(System.out::println);
            String userRegularTopping = scanner.nextLine().trim();
            if (userRegularTopping.equalsIgnoreCase("done")) break;

            String matchedTopping = RegularToppings.regularToppingList.stream()
                    .filter(r -> r.equalsIgnoreCase(userRegularTopping))
                    .findFirst().orElse(null);

            if (matchedTopping != null) {
                RegularToppings regularTopping = new RegularToppings(matchedTopping);
                this.toppings.add(regularTopping);
                System.out.printf("Added: %s\n", matchedTopping);
            } else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }
        }
    }

    public void addSauces(Scanner scanner) {
        this.sauces = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Sauce (type 'done' to go back):");
            Sauces.saucesList.forEach(System.out::println);
            String userSauce = scanner.nextLine().trim();
            if (userSauce.equalsIgnoreCase("done")) break;

            String matchedSauce = Sauces.saucesList.stream()
                    .filter(s -> s.equalsIgnoreCase(userSauce))
                    .findFirst().orElse(null);

            if (matchedSauce != null) {
                Sauces sauce = new Sauces(matchedSauce);
                this.sauces.add(sauce);
                System.out.printf("Added: %s\n", matchedSauce);
            } else {
                System.out.println("Sorry, we don't have this sauce.");
            }
        }
    }

    public void addSides(Scanner scanner) {
        this.sides = new ArrayList<>();
        while (true) {
            System.out.println("Please select a side (type 'done' to go back):");
            Sides.sidesList.forEach(System.out::println);
            String userSide = scanner.nextLine().trim();
            if (userSide.equalsIgnoreCase("done")) break;

            String matchedSide = Sides.sidesList.stream()
                    .filter(s -> s.equalsIgnoreCase(userSide))
                    .findFirst().orElse(null);

            if (matchedSide != null) {
                Sides side = new Sides(matchedSide);
                this.sides.add(side);
                System.out.printf("Added: %s\n", matchedSide);
            } else {
                System.out.println("Sorry, we don't have this side.");
            }
        }
    }

    @Override
    public String toString() {
        return "Sandwich {" +
                "\n  Bread: " + (bread != null ? bread.getType() + " (" + bread.getSize() + "\")" : "N/A") +
                "\n  Toasted: " + (toasted ? "Yes" : "No") +
                "\n  Toppings: " + (toppings != null && !toppings.isEmpty() ? toppings : "None") +
                "\n  Sauces: " + (sauces != null && !sauces.isEmpty() ? sauces : "None") +
                "\n  Sides: " + (sides != null && !sides.isEmpty() ? sides : "None") +
                String.format("\n  Total Price: $%.2f", price) +
                "\n}";
    }
}
