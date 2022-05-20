package p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int toAdd = scanner.nextInt();
        int toRemove = scanner.nextInt();
        int searchCriteria = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(toAdd)
                .forEach(queue::offer);

        while (toRemove-- > 0) {
            queue.poll();
        }

        if (queue.contains(searchCriteria)) {
            System.out.println("true");
        } else {
            System.out.println(queue.stream().min(Integer::compare).orElse(0));
        }

    }
}
