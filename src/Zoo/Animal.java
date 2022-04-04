package Zoo;

public class Animal {
    private String name;
    private int foodNeeded;
    String Area;

    public Animal(String name, int foodNeeded, String area) {
        this.name = name;
        this.foodNeeded = foodNeeded;
        Area = area;
    }

    public boolean isFed(int food) {
        foodNeeded -= food;
        if (foodNeeded <= 0) {
            return true;
        }
        return false;
    }

    public void increaseDailyFood(int value) {
        foodNeeded += value;
    }

    public String getArea() {
        return Area;
    }

    @Override
    public String toString() {
        return name + " -> " + foodNeeded + "g";
    }
}
