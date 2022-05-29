import java.util.Arrays;
import java.util.Scanner;

//  Crossfire @Boev 100/100

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);
        String line;

        while (!"Nuke it from orbit".equals(line = scanner.nextLine())) {
            int[] blowInstructions = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int blowRow = blowInstructions[0];
            int blowCol = blowInstructions[1];
            int blowRadius = blowInstructions[2];

            nukeRow(matrix, blowRow, blowCol, blowRadius);
            nukeCol(matrix, blowRow, blowCol, blowRadius);

            matrix = TruncateMatrix(matrix);
        }
        printMatrix(matrix);


    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = ScannerToIntArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;
    }

    private static void nukeCol(int[][] matrix, int blowRow, int blowCol, int blowRadius) {
        for (int i = blowRow - blowRadius; i <= blowRow + blowRadius; i++) {
            if (isValid(i, blowCol, matrix)) {
                matrix[i][blowCol] = 0;
            }
        }
    }

    private static void nukeRow(int[][] matrix, int blowRow, int blowCol, int blowRadius) {
        for (int i = blowCol - blowRadius; i <= blowCol + blowRadius; i++) {
            if (isValid(blowRow, i, matrix)) {
                matrix[blowRow][i] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
                if (col != matrix[row].length - 1) {
                    System.out.print(" ");
                }
            }
            if (row != matrix.length - 1) {
                System.out.println();
            }
        }

    }

    private static int[][] TruncateMatrix(int[][] matrix) {
        int[][] temp = fixCols(matrix);
        return fixRows(temp);
    }

    private static int[][] fixCols(int[][] matrix) {
        int[][] temp = new int[matrix.length][];
        for (int r = 0; r < matrix.length; r++) {
            int size = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != 0) {
                    size++;
                }
            }
            int[] row = new int[size];
            int index = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != 0) {
                    row[index++] = matrix[r][c];
                }
            }
            temp[r] = row;
        }
        return temp;
    }

    private static int[][] fixRows(int[][] matrix) {
        int size = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                size++;
            }
        }
        int[][] temp = new int[size][];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                temp[index++] = matrix[i];
            }
        }
        return temp;
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        return ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length));
    }

    private static int[] ScannerToIntArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }
}

