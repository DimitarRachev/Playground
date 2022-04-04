package Zoo;

import java.util.LinkedHashSet;
import java.util.Set;

public class Area {
    String name;
    Set<Animal> animals;

    public Area(String name) {
        this.name = name;
        animals = new LinkedHashSet<>();
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        if (animals.size() > 0) {
            return name + ": " + animals.size();
        }
        return null;
    }
}
