package backtracking;

/**
 * list down all possible ways of placing n non-attacking queens on an n×n chessboard,
 * for which solutions exist for all natural numbers n with the exception of n=2 and n=3
 */
public class N_Queen {

    public static void main(String[] args) {
        N_Queen n_queen = new N_Queen();
        n_queen.nQueen(5);
    }

    public void nQueen(int n) {
        addQueenTo(new int[n], 0);
        System.out.println(noOfSolution + " possible solutions");
    }

    private int noOfSolution = 0;

    private void addQueenTo(int[] columns, int row) {
        if (row == columns.length) {
            noOfSolution++;
            for (int column : columns) {
                for (int col = 0; col < columns.length; col++) {
                    if (col == column)
                        System.out.print("|x");
                    else
                        System.out.print("|_");
                }
                System.out.print("|\n");
            }
            System.out.println("\n");
            return;
        }
        for (int column = 0; column < columns.length; column++) {
            boolean isLegal = true;
            for (int rowTaken = 0; rowTaken < row; rowTaken++) {
                boolean isInTheSameColumn = columns[rowTaken] == column;
                boolean isInTheSameUpDiagonal = column + row == rowTaken + columns[rowTaken];
                boolean isInTheSameDownDiagonal = column - row == columns[rowTaken] - rowTaken;
                if(isInTheSameColumn || isInTheSameDownDiagonal || isInTheSameUpDiagonal) {
                    isLegal = false;
                }
            }
            if (isLegal) {
                columns[row] = column;
                addQueenTo(columns, row + 1);
            }
        }
    }

}
