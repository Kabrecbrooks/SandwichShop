import java.util.List;

public class RegularToppings extends Toppings{

    public static List<String> regularToppingList = List.of(
            "lettuce",
            "peppers",
            "onions",
            "tomatoes",
            "jalapenos",
            "cucumbers",
            "pickles",
            "guacamole",
            "mushrooms");

    public RegularToppings(String name) {
        super(name, false, 0.0);
    }
}
