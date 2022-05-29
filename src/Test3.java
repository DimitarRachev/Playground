import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            String[] rowInput = scanner.nextLine().split("\\s+");

            for (int col = 0; col < 8; col++) {
                char symbol = rowInput[col].charAt(0);
                matrix[row][col] = symbol;
            }
        }
        int qRow = 0;
        int qCol = 0;
        boolean realQueen = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                if (matrix[row][col] == 'q') {

                    qRow = row;
                    qCol = col;

                } else {
                    continue;
                }

                for (int horizontal = 0; horizontal < matrix.length; horizontal++) {
                    if (horizontal != qCol && matrix[qRow][horizontal] == 'q') {
                        realQueen = false;
                        break;
                    } else {
                        realQueen = true;
                    }
                }
                if (realQueen) {
                    for (int vertical = 0; vertical < matrix.length; vertical++) {
                        if (vertical != qRow && matrix[vertical][qCol] == 'q') {
                            realQueen = false;
                            break;
                        } else {
                            realQueen = true;
                        }
                    }
                }
                if (realQueen) {
                    for (int dia1Row = qRow + 1, dia1Col = qCol + 1; dia1Row < matrix.length && dia1Col < matrix.length; dia1Row++, dia1Col++) {
                        if (matrix[dia1Row][dia1Col] == 'q') {
                            realQueen = false;
                            break;
                        } else {
                            realQueen = true;
                        }
                    }
                }
                if (realQueen) {
                    for (int dia2Row = qRow, dia2Col = qCol; dia2Row - 1 >= 0 && dia2Col - 1 >= 0; dia2Row--, dia2Col--) {
                        if (matrix[dia2Row - 1][dia2Col - 1] == 'q') {
                            realQueen = false;
                            break;
                        } else {
                            realQueen = true;
                        }
                    }
                }
                if (realQueen) {
                    for (int dia3Row = qRow - 1, dia3Col = qCol + 1; dia3Row >= 0 && dia3Col < matrix.length; dia3Row--, dia3Col++) {
                        if (matrix[dia3Row][dia3Col] == 'q') {
                            realQueen = false;
                            break;

                        } else {
                            realQueen = true;
                        }
                    }
                }
                if (realQueen) {
                    for (int dia4Row = qRow + 1, dia4Col = qCol - 1; dia4Row < matrix.length && dia4Col >= 0; dia4Row++, dia4Col--) {
                        if (matrix[dia4Row][dia4Col] == 'q') {
                            realQueen = false;
                            break;

                        } else {
                            realQueen = true;
                        }
                    }
                }
                if (realQueen) {
                    System.out.println(qRow + " " + qCol);
                }
            }
        }
    }
}
