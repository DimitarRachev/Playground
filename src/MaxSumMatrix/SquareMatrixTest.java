package MaxSumMatrix;

import java.util.Random;

public class SquareMatrixTest {
    public static void main(String[] args) {

        SquareMatrix squareMatrix = new SquareMatrix();
        Random random = new Random();

        int size = random.nextInt(11) + 2;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(9);
            }
        }
        squareMatrix.setDataArray(matrix);
        squareMatrix.printAll();
    }
}
