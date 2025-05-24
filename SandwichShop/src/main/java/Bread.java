import java.util.Scanner;

public class Bread {

    Scanner scanner = new Scanner(System.in);


    private String type;
    private String size;
    private double price;


    public Bread(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
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

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        double basePrice = 0;

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void breadSize (Scanner scanner){
        System.out.println("""
    What bread size would you like?
    1. 4' = 5.50
    2. 8' = 7.00
    3. 12' = 8.50
    """);
        int userSize = Integer.parseInt(scanner.nextLine());

        double size = userSize;

        if (userSize == 1){
            size = 4;
        } else if (userSize == 2){
            size = 8;
        } else if (userSize == 3){
            size = 12;
        } else {
            System.out.println("Invalid choice. Please try again");
        }
    }

    public static void breadType(Scanner scanner){
        System.out.println("""
        What type of bread would you like?
        1. White
        2. Wheat
        3. Rye
        4. Wrap
        """);
        int userType = scanner.nextInt();
        String type;

        if (userType == 1){
            type = "White";
        } else if (userType == 2){
            type = "Wheat";
        } else if (userType == 3){
            type = "Rye";
        } else if (userType == 4){
            type = "Wrap";
        } else {
            System.out.println("Invalid choice. Please try again");
        }
    }

}
