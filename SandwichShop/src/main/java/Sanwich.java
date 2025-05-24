import java.util.ArrayList;
import java.util.List;

public class Sanwich {

    private String breadType;
    private String size;
    private boolean isToasted;
    private double price;
    ArrayList<Toppings> toppings;

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Sanwich(String breadType, String size, boolean isToasted, double price) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.price = price;
        this.toppings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Sanwich" + " | " +
                "price=" + price +
                ", isToasted=" + isToasted +
                ", size='" + size + '\'' +
                ", breadType='" + breadType + '\'' +
                '}';
    }

}
