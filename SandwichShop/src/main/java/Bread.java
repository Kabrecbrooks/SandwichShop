import java.util.List;
import java.util.Scanner;

public class Bread {

    Scanner scanner = new Scanner(System.in);


    private String type;
    private String size;
    private double price;
    private List<String> breadTypeList = List.of(
            "Wheat",
            "White",
            "Rye",
            "Wrap"
    );
    public Bread (){}


    public Bread(String type, String size) {
        this.type = type;
        this.size = size;
        this.price = getPrice(size);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize() {
        this.size = size;
    }

    public double getPrice(String size) {
        return switch (size){
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 5.50;
        };
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Bread createBread (){
        Bread bread = null;
        System.out.println("What kinda of bread would you like?");
        breadTypeList.forEach(System.out :: println);
        String userBreadType = scanner.nextLine().trim().toLowerCase();
        System.out.println("What size of bread would you like?" );
        String userBreadSize = scanner.nextLine().trim();
        if (breadTypeList.contains(userBreadType)){
            bread = new Bread(userBreadType,userBreadSize);
        }
        return bread;
    }
}