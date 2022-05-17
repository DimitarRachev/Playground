package p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String input;
        String currentUrl = null;
        while (!"Home".equals(input = scanner.nextLine())) {
            if ("back".equals(input)) {
                if (back.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    forward.push(currentUrl);
                    currentUrl = back.pop();
                }
            } else if ("forward".equals(input)) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    back.push(currentUrl);
                    currentUrl = forward.pop();
                }

            } else {
                if (currentUrl != null) {
                    back.push(currentUrl);
                }
                forward.clear();
                currentUrl = input;
            }
            System.out.println(currentUrl);
        }
    }
}
