public class Matrix_rotate_180_clockwise {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotaterows(m);
        rotatecols(m);
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void rotaterows(int m[][]){
        int r = m.length, c = m[0].length;
        
        for(int i=0; i<r; i++){
            for(int left=0,right=r-1; left<right; left++,right--){
                int t = m[i][left];
                m[i][left] = m[i][right];
                m[i][right] = t;
            }
        }
    }
    static void rotatecols(int m[][]){
        int r = m.length, c = m[0].length;
        
        for(int i=0; i<r/2; i++){
            for(int j=0; j<c; j++){
                int t = m[i][j];
                m[i][j] = m[r-i-1][j];
                m[r-i-1][j] = t;
            }
        }
    }
}
