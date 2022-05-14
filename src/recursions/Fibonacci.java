package recursions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    public static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map.put(0, 1L);
        map.put(1, 1L);
        int size = scanner.nextInt();

        System.out.println(calculateOptimisedRecursionFibonacci(size));
    }

    private static long calculateOptimisedRecursionFibonacci(int size) {
        if (map.get(size) != null) {
            return map.get(size);
        }
        map.put(size - 1, calculateOptimisedRecursionFibonacci(size - 1));
        return map.get(size - 1) + map.get(size - 2);
    }
}
