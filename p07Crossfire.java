package JavaAdvanced.p04MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillListMatrix(rows, cols, matrix);

        String line;
        while (!"Nuke it from orbit".equals(line = scanner.nextLine())) {
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = input[0];
            int c = input[1];
            int radius = input[2];

            nukeTheTarget(matrix, r, c, radius);
            removeEmptyLines(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillListMatrix(int rows, int cols, List<List<Integer>> matrix) {
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(counter++);
            }
        }
    }

    private static void removeEmptyLines(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).size() == 0) {
                matrix.remove(i--);
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> list : matrix) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void nukeTheTarget(List<List<Integer>> matrix, int r, int c, int radius) {
        //remove nuked row
        for (int i = c + radius; i >= c - radius; i--) {
            if (isValidIndex(r, matrix.size()) && isValidIndex(i, matrix.get(r).size())) {
                matrix.get(r).remove(i);
            }
        }
        //remove nuked column except for row r
        for (int i = r - radius; i <= r + radius; i++) {
            if (isValidIndex(i, matrix.size()) && isValidIndex(c, matrix.get(i).size()) && i != r) {
                matrix.get(i).remove(c);
            }
        }
    }

    private static boolean isValidIndex(int i, int size) {
        return i >= 0 && i < size;
    }
}
