public class Rotate_90_AllMartrices_ac {       // Anti Clockwise | Clockwise 270
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        m = inplace(m);
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] inplace(int m[][]){
        int r = m.length, c = m[0].length;
        int m1[][] = new int[c][r];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                m1[c-j-1][i] = m[i][j];
            }
        }
        return m1;
    }
}
