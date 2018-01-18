package others;

import recursion.Exponentiation;

public class AlgorithmJE {

    public static void main(String[] args) {
        e1_3(3,4,7);
    }

    /*
    1.3
    Consider a 2^n x 2^n chess board with one arbitrarily chosen square removed
    Describe and analyze an algorithm to tile the chessboard without gaps or overlaps
    by L-shaped pieces, each composed of 3 squares
     */

    private static int counter;

    private static void e1_3(int n, int row, int column) {
        Exponentiation exponentiation = new Exponentiation();
        int size = exponentiation.fastPower(2, n);
        int[][] board = new int[size][size];
        board[row][column] = -1;
        counter = 0;
        quarter(board, 0, size - 1, 0, size - 1, row, column);

        for (int[] rowOfBoard: board){
            for (int value:
                    rowOfBoard){
                System.out.print(value+"\t");
            }
            System.out.print("\n");
        }
    }

    private static void quarter(int[][] board, int startRow, int endRow, int startColumn, int endColumn, int row, int column) {
        if (endRow - startRow == 0 && endColumn - startColumn == 0) {
            return;
        }

        int midRow = (startRow + endRow) / 2;
        int midColumn = (startColumn + endColumn) / 2;

        if (row <= midRow && column <= midColumn) {
            tile(board, startRow, endRow, startColumn, endColumn, 1);
            quarter(board, startRow, midRow, startColumn, midColumn, row, column);
        }

        if (row <= midRow && column > midColumn) {
            tile(board, startRow, endRow, startColumn, endColumn, 2);
            quarter(board, startRow, midRow, midColumn + 1, endColumn, row, column);
        }

        if (row > midRow && column > midColumn) {
            tile(board, startRow, endRow, startColumn, endColumn, 3);
            quarter(board, midRow + 1, endRow, midColumn + 1, endColumn, row, column);
        }

        if (row > midRow && column <= midColumn) {
            tile(board, startRow, endRow, startColumn, endColumn, 4);
            quarter(board, midRow + 1, endRow, startColumn, midColumn, row, column);
        }
    }

    private static void tile(int[][] board, int startRow, int endRow, int startColumn, int endColumn, int omittedQuarter) {
        if (endRow - startRow == 1 && endColumn - startColumn == 1) {
            counter++;
            switch (omittedQuarter) {
                case 1:
                    board[endRow][startColumn] = counter;
                    board[endRow][endColumn] = counter;
                    board[startRow][endColumn] = counter;
                    break;
                case 2:
                    board[startRow][startColumn] = counter;
                    board[endRow][endColumn] = counter;
                    board[endRow][startColumn] = counter;
                    break;
                case 3:
                    board[endRow][startColumn] = counter;
                    board[startRow][startColumn] = counter;
                    board[startRow][endColumn] = counter;
                    break;
                case 4:
                    board[startRow][startColumn] = counter;
                    board[endRow][endColumn] = counter;
                    board[startRow][endColumn] = counter;
                    break;
            }
            return;
        }

        int midRow = (startRow + endRow) / 2;
        int midColumn = (startColumn + endColumn) / 2;

        switch (omittedQuarter) {
            case 1:
                tile(board, startRow, midRow, midColumn + 1, endColumn, 4);
                tile(board, midRow + 1, endRow, startColumn, midColumn, 2);
                tile(board, midRow + 1, endRow, midColumn + 1, endColumn, 1);
                tile(board, (startRow + midRow) / 2 + 1, (midRow + endRow) / 2,
                        (startColumn + midColumn) / 2 + 1, (midColumn + endColumn) / 2,
                        1);
                break;
            case 2:
                tile(board, startRow, midRow, startColumn, midColumn, 3);
                tile(board, midRow + 1, endRow, startColumn, midColumn, 2);
                tile(board, midRow + 1, endRow, midColumn + 1, endColumn, 1);
                tile(board, (startRow + midRow) / 2 + 1, (midRow + endRow) / 2,
                        (startColumn + midColumn) / 2 + 1, (midColumn + endColumn) / 2,
                        2);
                break;
            case 3:
                tile(board, startRow, midRow, startColumn, midColumn, 3);
                tile(board, startRow, midRow, midColumn + 1, endColumn, 4);
                tile(board, midRow + 1, endRow, startColumn, midColumn, 2);
                tile(board, (startRow + midRow) / 2 + 1, (midRow + endRow) / 2,
                        (startColumn + midColumn) / 2 + 1, (midColumn + endColumn) / 2,
                        3);
                break;
            case 4:
                tile(board, startRow, midRow, startColumn, midColumn, 3);
                tile(board, startRow, midRow, midColumn + 1, endColumn, 4);
                tile(board, midRow + 1, endRow, midColumn + 1, endColumn, 1);
                tile(board, (startRow + midRow) / 2 + 1, (midRow + endRow) / 2,
                        (startColumn + midColumn) / 2 + 1, (midColumn + endColumn) / 2,
                        4);
                break;
        }
    }
}
