package p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "1":
                    stack.push(Integer.parseInt(commands[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(stack.stream().max(Integer::compare).orElse(Integer.MIN_VALUE));
                    break;
            }
        }
    }
}
