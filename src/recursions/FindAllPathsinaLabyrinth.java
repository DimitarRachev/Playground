package recursions;

import java.util.Scanner;

public class FindAllPathsinaLabyrinth {
    public static char[][] labyrinth;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        labyrinth = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            labyrinth[i] = scanner.nextLine().toCharArray();
        }

        findPath(0, 0, " ");
    }

    private static void findPath(int row, int col, String direction) {
        if (!indexesAreValid(row, col) || labyrinth[row][col] == '*' || labyrinth[row][col] == 'V') {
            return;
        }
        if (labyrinth[row][col] == 'e') {
            sb.append(direction);
            printPath();
            sb.replace(sb.length() - 1, sb.length(), "");
            return;
        }

        labyrinth[row][col] = 'V';
        sb.append(direction);

        findPath(row, col + 1, "R");
        findPath(row, col - 1, "L");
        findPath(row + 1, col, "D");
        findPath(row - 1, col, "U");
        labyrinth[row][col] = '-';
        sb.replace(sb.length() - 1, sb.length(), "");
    }

    private static void printPath() {
        System.out.println(sb.toString().trim());
    }

    private static boolean indexesAreValid(int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[0].length;
    }
}
