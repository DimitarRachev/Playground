package p01StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!"print".equals(input = scanner.nextLine())) {
            if ("cancel".equals(input)) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                printerQueue.offer(input);
            }
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
