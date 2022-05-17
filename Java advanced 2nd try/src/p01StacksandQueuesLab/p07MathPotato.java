package p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class p07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>(List.of(scanner.nextLine().split("\\s+")));
        int pass = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        for (int i = pass + 1; i >= 0; i++) {
            if (queue.size() == 1) {
                System.out.println("Last is " + queue.poll());
                return;
            }

            if (i % pass == 0) {
                if (!isPrime(cycle++)) {
                    System.out.println("Removed " + queue.poll());
                } else {
                    System.out.println("Prime " + queue.peek());
                }
            } else {
                queue.offer(queue.poll());
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
