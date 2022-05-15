package recursions;

import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Integer[]vector = new Integer[size];
        generateVector(vector, 0);
    }

    private static void generateVector(Integer[] vector, int index) {
        if (index == vector.length) {
            printVector(vector);
            return;
        }
        for (int i = 0; i < 2; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }

    private static void printVector(Integer[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
        }
        System.out.println();
    }
}
