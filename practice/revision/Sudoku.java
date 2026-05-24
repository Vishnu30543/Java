import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        char board[][] = {
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
        System.out.println(solve(board));
        
        for(char i[] : board){
            System.out.println(Arrays.toString(i));
        }
    }
    static boolean solve(char board[][]){
        return backtrack(board);
    }
    static boolean backtrack(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){

                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(i, j, board, c)){
                            board[i][j] = c;
                            if(backtrack(board) == true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isSafe(int i, int j, char board[][], char c){
        for(int k=0; k<9; k++){
            if(board[k][j] == c) return false;
            if(board[i][k] == c) return false;
            if(board[3 * (i/3) + k/3][3 * (j/3) + k%3] == c) return false;
        }
        return true;
    }
}
