package p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class p02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>(List.of(input));

        int sum = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String action = stack.pop();
            int num = Integer.parseInt(stack.pop());
            sum = action.equals("+") ? sum + num : sum - num;
        }
        System.out.println(sum);
    }
}
