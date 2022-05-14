package recursions;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calculateSum(0, arr));
    }

    private static int calculateSum(int index, int[] arr) {
        if (index == arr.length - 1) {
            return arr[arr.length - 1];
        }
        return arr[index] + calculateSum(index + 1, arr);
    }
}
