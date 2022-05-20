package p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int toPush = scanner.nextInt();
        int toPop = scanner.nextInt();
        int searchCriteria = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < toPush; i++) {
            stack.push(queue.poll());
        }

        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }

        if (stack.contains(searchCriteria)) {
            System.out.println("true");
        } else {
            System.out.println(stack.stream().min(Integer::compare).orElse(0));
        }
    }
}
