package MaxSumMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareMatrix {
    int[][] dataArray;
    List<int[]> coordinates;
//    int maxSum;

    //Конструктори за общо ползване, по подразбиране и копиране
    //По подразбиране е празен конструктор,
    // но какви са другите нямам идея,
    //затова направих тези два:

    public SquareMatrix(int[][] dataArray) {
        this();
        this.dataArray = dataArray;
    }

    public SquareMatrix() {
        coordinates = new ArrayList<>();
    }

    public void printAll() {
        System.out.println("Maximum sum: " + findMaxSum());
        System.out.println("Submatrices with Maximum sum:");
        for (int[] coordinate : coordinates) {
            System.out.println(Arrays.toString(coordinate));
        }

    }

    public int findMaxSum() {
        int[][] matrix;
        int maxSum = 0;
        for (int i = 0; i < dataArray.length - 1; i++) {
            for (int j = 0; j < dataArray[i].length - 1; j++) {
                matrix = new int[][]{{dataArray[i][j], dataArray[i][j + 1]}, {dataArray[i + 1][j], dataArray[i + 1][j + 1]}};
                int sum = findSum(matrix);
                if (sum > maxSum) {
                    maxSum = sum;
                    coordinates.clear();
                    coordinates.add(new int[]{i, j});
                } else if (sum == maxSum) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        return maxSum;
    }

    private int findSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : dataArray) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
