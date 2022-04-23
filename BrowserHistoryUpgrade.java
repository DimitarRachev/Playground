package JavaAdvanced.p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> back = new ArrayDeque<String>();
        ArrayDeque<String> forward = new ArrayDeque<String>();

        String input;
        String current = null;

        while (!"Home".equals(input = scanner.nextLine())) {
            if (input.equals("back")) {
                if (back.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    forward.push(current);
                    current = back.pop();
                    System.out.println(current);
                }

            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    back.push(current);
                    current = forward.pop();
                    System.out.println(current);
                }

            }else {
                if (current != null) {
                    back.push(current);
                }
                current = input;
                forward.clear();
                System.out.println(current);
            }
        }
    }
}
