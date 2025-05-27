import java.util.List;
import java.util.Scanner;

public class Sauces {

    Scanner scanner = new Scanner(System.in);
    private String name;
    public static List<String> saucesList = List.of(
            "mayo",
            "mustard",
            "ketchup",
            "ranch",
            "thousand island",
            "vinaigrette");

    public Sauces(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
