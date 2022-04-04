package Zoo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Animal> animals = new LinkedHashMap<>();
        Map<String, Area> areas = new LinkedHashMap<>();
        String line;
        while (!"EndDay".equals(line = scanner.nextLine())) {
            String[] input = line.split(":\\s+");
            String command = input[0];
            if (command.equals("Add")) {
                String[] data = input[1].split("-");
                String name = data[0];
                int food = Integer.parseInt(data[1]);
                String area = data[2];
                animals.putIfAbsent(name, new Animal(name, 0, area));
                animals.get(name).increaseDailyFood(food);
                areas.putIfAbsent(area, new Area(area));
                areas.get(area).getAnimals().add(animals.get(name));
            } else if (command.equals("Feed")) {
                String[] data = input[1].split("-");
                String name = data[0];
                int food = Integer.parseInt(data[1]);
                if (animals.containsKey(name)) {
                    Animal animal = animals.get(name);
                    if (animal.isFed(food)) {
                        areas.get(animal.getArea()).getAnimals().remove(animal);
                        animals.remove(name);
                        System.out.println(name + " was successfully fed");
                    }
                }
            }
        }

        System.out.println("Animals:");
        animals.values().forEach(System.out::println);
        System.out.println("Areas with hungry animals:");
        areas.values().stream().filter(v -> v.toString() != null).forEach(System.out::println);
    }
}
