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
       return  foodNeeded <= 0;
    }

    public void increaseDailyFood(int value) {
        foodNeeded += value;
    }

    public String getArea() {
        return Area;
    }

    public int getFoodNeeded() { return foodNeeded;  }

    public String getName() { return name;  }

    @Override
    public String toString() {
        return name + " -> " + foodNeeded + "g";
    }
}
