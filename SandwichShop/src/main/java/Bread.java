import java.util.List;
import java.util.Scanner;

public class Bread {

    private static final List<String> breadTypeList = List.of(
            "Wheat",
            "White",
            "Rye",
            "Wrap"
    );

    private String type;
    private String size;
    private double price;

    public Bread() {}

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

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice(String size) {
        return switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 5.50;
        };
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static Bread createBread(Scanner scanner) {
        System.out.println("What kind of bread would you like?");
        for (int i = 0; i < breadTypeList.size(); i++) {
            System.out.println((i + 1) + ". " + breadTypeList.get(i));
        }
        String userBreadType = null;
        while (userBreadType == null) {
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= breadTypeList.size()) {
                    userBreadType = breadTypeList.get(choice - 1);
                } else {
                    System.out.println("Invalid choice. Please select a number from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.println("What size of bread would you like? (4, 8, or 12)");
        String userBreadSize = null;
        while (userBreadSize == null) {
            String sizeInput = scanner.nextLine().trim();
            if (sizeInput.equals("4") || sizeInput.equals("8") || sizeInput.equals("12")) {
                userBreadSize = sizeInput;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }
        return new Bread(userBreadType, userBreadSize);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}