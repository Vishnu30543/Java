import java.util.*;

public class N_Queens {     // TC : O(n!)

    static List<List<String>> solveNQueens(int n) {
        // create result list
        // initialize board with '.'
        // call backtracking helper starting from row 0
        // return result

        List<List<String>> res = new ArrayList<>();
        char board[][] = new char[n][n];
        for(char t[] : board) 
            Arrays.fill(t, '.');        // Important

        int leftrow[] = new int[n];
        int lowerdiagonal[] = new int[(2*n) - 1];
        int upperdiagonal[] = new int[(2*n) - 1];
        backtrack(0, n, board, leftrow, lowerdiagonal, upperdiagonal, res);
        return res;
    }

    static void backtrack(int col, int n, char[][] board, int leftrow[], int lowerdiagonal[], int upperdiagonal[], List<List<String>> res) {
        // if row == n, convert board to list and add to result
        // iterate over columns
        // check if placing queen is safe
        // place queen
        // recursive call for next row
        // remove queen (backtrack)

        // If all queens are placed
        if(col == n){
            List<String> l = new ArrayList<>();
            for(int i=0; i<n; i++){
                l.add(new String(board[i]));
            }
            res.add(l);
            return;
        }
        for(int row=0; row<n; row++){
            // Check Safety
            if(leftrow[row] == 0 && lowerdiagonal[row+col] == 0 && upperdiagonal[n-1+col-row] == 0){
                // Place Queen
                board[row][col] = 'Q';
                leftrow[row] = 1;
                lowerdiagonal[row+col] = 1;
                upperdiagonal[n-1+col-row] = 1;

                // Recurse
                backtrack(col+1, n, board, leftrow, lowerdiagonal, upperdiagonal, res);

                // Backtrack
                board[row][col] = '.';
                leftrow[row] = 0;
                lowerdiagonal[row+col] = 0;
                upperdiagonal[n-1+col-row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(solveNQueens(4));
        List<List<String>> ans = solveNQueens(4);
        for(List<String> board : ans){
            for(String row : board){
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
