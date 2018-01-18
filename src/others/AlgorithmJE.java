package others;

import recursion.Exponentiation;

public class AlgorithmJE {

    public static void main(String[] args) {
//        e1_3(3, 4, 7);
        e3_1_a(new int[]{0, 2, 3, 5, 7, 11, 12, 16, 29, 4, 10, 5},
                new int[]{1, 2, 3, 4, 2, 3, 5, 7, 11, 12, 16, 29, 10, 52, 3, 5, 7, 11, 12, 16, 29});
    }

    /*
    1.3
    Consider a 2^n x 2^n chess board with one arbitrarily chosen square removed
    Describe and analyze an algorithm to tile the chessboard without gaps or overlaps
    by L-shaped pieces, each composed of 3 squares

    Answer: Cut the board into 2 pieces by using method "quarter", the first one
    is the quarter that contains the removed square, and the second one is the rest (L shape).
    Call quarter recursively on the first piece and call tile recursively on the second
    piece
     */

    private static int counter;

    private static void e1_3(int n, int row, int column) {
        Exponentiation exponentiation = new Exponentiation();
        int size = exponentiation.fastPower(2, n);
        int[][] board = new int[size][size];
        board[row][column] = -1;
        counter = 0;
        quarter(board, 0, size - 1, 0, size - 1, row, column);

        for (int[] rowOfBoard : board) {
            for (int value :
                    rowOfBoard) {
                System.out.print(value + "\t");
            }
            System.out.print("\n");
        }
    }

    private static void quarter(int[][] board, int startRow, int endRow,
                                int startColumn, int endColumn, int row, int column) {
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

    private static void tile(int[][] board, int startRow, int endRow,
                             int startColumn, int endColumn, int omittedQuarter) {
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

    /*
    3.1a
    Describe an algorithm to give the length of the longest common subsequence
    of 2 arbitrary arrays A[0..n] and B[0..m]

    Answer: Assume i & j are where A[i] = B[j], the longest common subsequence of
    A[0..n] and B[0..m] is the longest common subsequence of A[i..n] and B[j..m].
    The longest common subsequence of A[i..n] and B[j..m] is either the longest common
    subsequence of A[i+1..n] and B[j+1..m] or A[i..i+k] = B[j..j+k]
     */
    private static void e3_1_a(int[] A, int[] B) {
        int ls = longestCommonSubsequence(A, B, 0, 0, 0);
        System.out.println(ls);
    }

    private static int longestCommonSubsequence(int[] A, int[] B, int startA, int startB, int length) {
        if (startA == A.length || startB == B.length)
            return length;

        int temp;
        for (int i = startA; i < A.length; i++) {
            for (int j = startB; j < B.length; j++) {
                if (A[i] == B[j]) {
                    temp = longestCommonSubsequence(A, B, i + 1, j + 1,
                            (i == startA && j == startB) ? length + 1 : 1);
                    if (length < temp)
                        length = temp;
                }
            }
        }
        return length;
    }
}
