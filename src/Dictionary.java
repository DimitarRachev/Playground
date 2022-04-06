import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        String[]input = scanner.nextLine().split("[\\s][|][\\s]");
        for (String s : input) {
            String word = s.split(": ")[0];
            String definition = s.split(": ")[1];
            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(definition);
        }

        String[]test = scanner.nextLine().split("[\\s][|][\\s]");
        String command = scanner.nextLine();
        switch (command){
            case "Test":
                for (String s : test) {
                    if (dictionary.containsKey(s)) {
                        System.out.println(s + ":");
                        for (String def : dictionary.get(s)) {
                            System.out.println(" -" + def);
                        }
                    }
                }
                break;
            case "Hand Over":
                for (String s : dictionary.keySet()) {
                    System.out.print(s + " ");
                }

                break;
        }

    }
}
