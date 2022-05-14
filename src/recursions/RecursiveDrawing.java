package recursions;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        draw(size);
    }

    private static void draw(int size) {
        if (size == 0) {
            return;
        }
        System.out.println("*".repeat(size));
        draw(size - 1);
        System.out.println("#".repeat(size));
    }
}
