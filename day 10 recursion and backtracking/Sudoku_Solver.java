public class Sudoku_Solver {    // TC : O(9 ^ emptycells)

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solveSudoku(board));
    }

    public static boolean solveSudoku(char[][] board) {
        return backtrack(board);
    }

    private static boolean backtrack(char[][] board) {
        // Find the next empty cell in the board
        // Try placing digits from '1' to '9'
        // Check if the placement is valid
        // Place the digit and recurse
        // If recursion fails, undo the placement (backtrack)
        // Return true if the board is completely solved
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] == '.'){

                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            if(backtrack(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;       // Important
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char digit) {
        // Check the current row for duplicate digit
        // Check the current column for duplicate digit
        // Check the 3x3 subgrid for duplicate digit
        // Return true if digit can be placed safely
        for(int i=0; i<9; i++){
            // Row
            if(board[i][col] == digit)
                return false;

            // Col
            if(board[row][i] == digit)
                return false;

            // Grid
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == digit)
                return false;
        }
        return true;
    }
}
