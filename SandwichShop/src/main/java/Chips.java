import java.util.List;
import java.util.Scanner;

public class Chips {

    private static final Scanner scanner = new Scanner(System.in);
    private final double price;
    private String name;
    List<String> chipsList = List.of(
            "Cheetos",
            "Doritos",
            "Lays"
    );

    public Chips(String name) {
        this.price = 1.50;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public Chips createChips(){
        while (true){
            System.out.println("Available chips:");
            chipsList.forEach(System.out :: println);
            String userChips = scanner.nextLine().trim().toLowerCase();
            if (chipsList.contains(userChips)){
                return new Chips(userChips);
            } else {
                System.out.println("We don't have these chips in our menu. Try again.");
            }
        }
    }
}