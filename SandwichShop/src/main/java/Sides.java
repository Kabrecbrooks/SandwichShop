import java.util.List;
import java.util.Scanner;

public class Sides {

    Scanner scanner = new Scanner(System.in);
    private String name;

    public static List<String>sidesList = List.of(
            "Au jus",
            "sauce"
    );

    public Sides(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
