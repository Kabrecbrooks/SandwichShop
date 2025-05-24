import java.util.Scanner;

public class Drinks {
    Scanner scanner = new Scanner(System.in)
    private String size;
    private String flavor;
    private double price;

    public String getSize() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Drinks(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
    }

    public String drinkFlavor(){
        System.out.println("What drink would you like?");
        System.out.println("(1.) Cola \n(2.) Lemonade \n(3.) Orange \n(4.) Sprite");
        String userFlavor = scanner.nextLine();

        switch (userFlavor){
            case "1" -> {
                return "Cola"; }
            case "2" -> {
                return "Lemonade";}
            case "3" -> {
                return "Orange";}
            case "4" -> {
                return "Sprite";}
            default -> System.out.println("Invalid entry. Please try again");
        }
        return userFlavor;
    }

    public String drinkSize(){
        System.out.println("What size would you like? ");
        System.out.println("(1.) Small  \n(2.) Medium \n(3.) Large  " );

        String userSize = scanner.nextLine();

        switch (userSize){
            case "1" -> {
                return "Small";}
            case "2" -> {
                return "Medium";}
            case "3" -> {
                return "Large";}
            default -> System.out.println("Invalid entry. Please try again");
        }
        return userSize;
    }
}
