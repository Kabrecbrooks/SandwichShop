public abstract class Toppings {

    private String name;
    private boolean extra;
    private double price;

    public Toppings(String name, boolean extra, double price) {
        this.name = name;
        this.extra = extra;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + (extra ? " (extra)" : "") + " - $" + price;
    }
}