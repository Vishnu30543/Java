public class Matrix_rotate_270_clockwise {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int m1[][] = transpose(m);
        rotatecols(m);
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] transpose(int m[][]){
        int r = m.length, c = m[0].length;
        int m1[][] = new int[c][r];
        for(int i=0; i<r; i++){
            for(int j=i+1; j<c; j++){
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        return m1;
    }
    static void rotatecols(int m[][]){
        int r = m.length, c = m[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int t = m[i][j];
                m[i][j] = m[i][r-i-1];
                m[i][r-i-1] = t;
            }
        }
    }
}
