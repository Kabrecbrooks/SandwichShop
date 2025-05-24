public class Toppings {
    private String name;
    private int size;
    private boolean isPremium;
    boolean isExtra;
    private double price;

    public Toppings(String name, int size, boolean isPremium, boolean isExtra, double price) {
        this.name = name;
        this.size = size;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}





