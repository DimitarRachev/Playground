package finalExam;

import java.util.UUID;

public class Inventory {
    private String ID = String.valueOf(UUID.randomUUID());
    private int cnt;
   private Category category;
    private double price;
    private String description;


    public Inventory(Category category, double price) {
        this.category = category;
        this.price = price;
        description = "Product-" + ID;
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
        return description + System.lineSeparator()
                + "Category: " + category + System.lineSeparator()
                +String.format("price: %2.f%n", price);

    }
}
