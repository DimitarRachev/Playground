package finalExam;

public class Inventory {
    private String ID;
    private int cnt;
   private Category category;
    private double price;
    private String description;


    public Inventory(Category category, double price) {
        this.category = category;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "ID='" + ID + '\'' +
                ", cnt=" + cnt +
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
