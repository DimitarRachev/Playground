package aRealFinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        String line;
        while (!"Results".equals(line = scanner.nextLine())) {
            String[] input = line.split(":");
            switch (input[0]) {
                case "Add":
                    String name = input[1];
                    int health = Integer.parseInt(input[2]);
                    int energy = Integer.parseInt(input[3]);
                    add(name, energy, health, persons);
                    break;
                case "Attack":
                    String attacker = input[1];
                    String defender = input[2];
                    int damage = Integer.parseInt(input[3]);
                    attack(attacker, defender, damage, persons);
                    break;
                case "Delete":
                    String person = input[1];
                    delete(persons, person);
                    break;
            }
        }

        System.out.println("People count: " + persons.size());
        persons.values().forEach(System.out::println);
    }

    private static void attack(String attacker, String defender, int damage, Map<String, Person> persons) {
        if (persons.containsKey(attacker) && persons.containsKey(defender)) {
            Person att = persons.get(attacker);
            Person def = persons.get(defender);
            att.attack();
            def.takeDmg(damage);
            if (def.isDead()){
                persons.remove(defender);
                System.out.println(defender + " was disqualified!");
            }
            if (att.isDead()) {
                persons.remove(attacker);
                System.out.println(attacker + " was disqualified!");

            }
        }
    }

    private static void delete(Map<String, Person> persons, String person) {
        if (person.equals("All")) {
            persons.clear();
        } else {
            persons.remove(person);
        }
    }

    private static void add(String name, int energy, int health, Map<String, Person> persons) {
        if (persons.containsKey(name)) {
            persons.get(name).increaseHealth(health);
        } else {
            persons.put(name, new Person(name, health, energy));
        }
    }

    static class Person {
        String name;
        int health;
        int energy;

        public Person(String name, int health, int energy) {
            this.health = health;
            this.energy = energy;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s - %d - %d", name, health, energy);
        }

        public void increaseHealth(int health) {
            this.health += health;
        }

        public void attack() {
            this.energy--;
        }

        public void takeDmg(int damage) {
            health -= damage;
        }

        public boolean isDead() {
            return health <= 0 || energy <= 0;
        }
    }
}
