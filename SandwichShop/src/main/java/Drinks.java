import java.util.List;
import java.util.Scanner;

public class Drinks {

    Scanner scanner = new Scanner(System.in);

    private String size;
    private String flavor;
    private double price;
    List<String> drinkList = List.of(
            "Cola",
            "Pepsi",
            "Sprite",
            "Orange"

    );

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = getPrice(size);
    }

    public String getSize(String size) {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice(String size) {
        if (size.equalsIgnoreCase("M")) {
            return this.price = 2.50;
        } else if (size.equalsIgnoreCase("L")) {
            return this.price = 3.00;
        } else {
            return 2.00;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Drinks createDrink() {
        while (true) {
            System.out.println("What drink would you like?");
            drinkList.forEach(System.out::println);
            String userDrink = scanner.next().trim().toLowerCase();
            System.out.println("What size?: S, M, L");
            String userDrinkSize = scanner.nextLine().trim().toUpperCase();

            if (drinkList.contains(userDrink)) {
                return new Drinks(userDrinkSize, userDrink);
            } else {
                System.out.println("We don't have these drink flavor in our menu. Try again.");
            }
        }

    }
}