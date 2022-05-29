package Misc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {


                Scanner scanner = new Scanner(System.in);

                TreeMap<String, LinkedHashMap<String, LinkedHashSet<String>>> userTreemap = new TreeMap<>();

                String regex = "IP=(?<IP>[\\d+.]+) message='(?<message>[\\S]+)' user=(?<user>[\\S]+)";

                String input = scanner.nextLine();

                while (!input.equals("end")) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.find()) {
                        String IP = matcher.group("IP");
                        String message = matcher.group("message");
                        String user = matcher.group("user");

                        if (userTreemap.containsKey(user)) {
                            if (userTreemap.get(user).containsKey(IP)) {
                                userTreemap.get(user).get(IP).add(message);
                            } else {
                                LinkedHashSet<String> messageSet = new LinkedHashSet<>();
                                messageSet.add(message);
                                userTreemap.get(user).put(IP, messageSet);
                            }
                        } else {
                            LinkedHashMap<String, LinkedHashSet<String>> IPMap = new LinkedHashMap<>();
                            LinkedHashSet<String> messageSet = new LinkedHashSet<>();
                            messageSet.add(message);
                            IPMap.put(IP, messageSet);
                            userTreemap.put(user, IPMap);
                        }
                    }

                    input = scanner.nextLine();
                }

                for (Map.Entry<String, LinkedHashMap<String, LinkedHashSet<String>>> entry : userTreemap.entrySet()) {
                    System.out.printf("%s:%n", entry.getKey());

                    int i = 0;
                    for (Map.Entry<String, LinkedHashSet<String>> entry1 : entry.getValue().entrySet()) {
                        System.out.printf("%s => %d", entry1.getKey(), entry1.getValue().size());
                        if (i < entry.getValue().size() - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.print(".");
                        }
                        i++;


                    }
                }



    }
}
