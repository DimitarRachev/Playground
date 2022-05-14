package recursions;

import java.time.Duration;
import java.time.LocalTime;

public class Queens8 {
    public static char[][] board = populateBoard();

    private static char[][] populateBoard() {
        char[][] initial = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                initial[i][j] = '-';
            }
        }
        return initial;
    }

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        placeQueen(0);
        System.out.println("Time elapsed: " + Duration.between(time, LocalTime.now()).toMillis() + "ms.");
    }

    private static void placeQueen(int row) {
        if (row == 8) {
            printBoard();
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (placeIsAvailable(row, col)) {
                putQueen(row, col);
                placeQueen(row + 1);
                removeQueen(row, col);
            }
        }

    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static boolean placeIsAvailable(int row, int col) {
        int r = row, c = col;
        while (r >= 0) {
            if (board[r--][col] == '*') {
                return false;
            }
        }

        r = row;
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == '*') {
                return false;
            }
        }
        r = row;
        c = col;
        while (r >= 0 && c < 8) {
            if (board[r--][c++] == '*') {
                return false;
            }
        }
        return true;
    }
}
