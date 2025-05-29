import java.util.List;
import java.util.Scanner;

public class MeatToppings extends Toppings {

    public static final List<String> meatList = List.of(
            "steak",
            "ham",
            "salami",
            "roast beef",
            "chicken",
            "bacon"
    );

    public MeatToppings(String name, Bread bread, boolean extra) {
        super(name, extra, getPrice(bread, extra));
    }

    private static double getPrice(Bread bread, boolean extra) {
        return switch (bread.getSize()) {
            case "4" -> extra ? 1.50 : 1.00;
            case "8" -> extra ? 3.00 : 2.00;
            case "12" -> extra ? 3.50 : 3.00;
            default -> 1.00;
        };
    }

    public static MeatToppings createTopping(Scanner scanner, Bread bread) {
        String userMeat = null;
        while (userMeat == null) {
            System.out.println("What kind of meat would you like?");
            for (String meat : meatList) {
                System.out.println(meat);
            }
            String input = scanner.nextLine().trim();
            for (String meat : meatList) {
                if (meat.equalsIgnoreCase(input)) {
                    userMeat = meat;
                    break;
                }
            }
            if (userMeat == null) {
                System.out.println("Invalid meat. Please select from the list.");
            }
        }
        System.out.println("Would you like extra meat for an additional price? (Y/N)");
        boolean extraMeat = scanner.nextLine().trim().equalsIgnoreCase("Y");
        return new MeatToppings(userMeat, bread, extraMeat);
    }
}

