package p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String input;
        String currentUrl = null;
        while (!"Home".equals(input = scanner.nextLine())) {
            if ("back".equals(input)) {
                if (history.isEmpty()) {
                    currentUrl = "no previous URLs";
                } else {
                    currentUrl = history.pop();
                }
            } else {
                if (currentUrl != null) {
                    history.push(currentUrl);
                }
                currentUrl = input;
            }
            System.out.println(currentUrl);
        }
    }
}
