package recursions;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println(calculateFactoriel(size));
    }

    private static long calculateFactoriel(int size) {
        if (size == 1) {
            return 1;
        }
        return size * calculateFactoriel(size - 1);
    }
}
