package recursions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyFibonacci {
    public static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map.put(0, 0L);
        map.put(1, 1L);
        int size = scanner.nextInt();
        LocalTime start = LocalTime.now();
        System.out.println(calculateRecursionFibonacci(size));
        Duration recursionDuration = Duration.between(start, LocalTime.now());
        start = LocalTime.now();
        System.out.println(calculateOptimisedRecursionFibonacci(size));
        Duration optimisedRecursionDuration = Duration.between(start, LocalTime.now());
        System.out.println("Normal recursion: " + recursionDuration.toMillis() + "ms.");
        System.out.println("Optimised recursion: " + optimisedRecursionDuration.toMillis() + "ms.");
        System.out.println("Optimised recursion: " + optimisedRecursionDuration.toNanos() + "ns.");


    }

    private static long calculateOptimisedRecursionFibonacci(int size) {
        if (map.get(size) != null) {
            return map.get(size);
        }
        map.put(size - 1, calculateOptimisedRecursionFibonacci(size - 1));
        return map.get(size - 1) + map.get(size - 2);
    }

    private static long calculateRecursionFibonacci(int size) {
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return 1;
        }
        return calculateRecursionFibonacci(size - 1) + calculateRecursionFibonacci(size - 2);
    }
}

