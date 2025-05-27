import java.util.List;

public class MeatToppings extends Toppings {

    public static List<String> meatList = List.of(
            "steak",
            "ham",
            "salami",
            "roast beef",
            "chicken",
            "bacon");

    public MeatToppings(String name, Bread bread, boolean extra) {
        super(name, extra, getPrice(bread, extra));
    }

    private static double getPrice( Bread bread, boolean extra) {
        return switch (bread.getSize()) {
            case "4" ->  extra ? 1.50 : 1.00;
            case "8" ->  extra ? 3.00 : 2.00;
            case "12"->  extra ? 3.50 : 3.00;
            default -> 1.00;
        };
    }
}
