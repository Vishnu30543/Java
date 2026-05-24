public class m_graph_coloring {
    public static void main(String[] args) {
        int N = 4;
        int M = 3;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {0, 2}
        };
        System.out.println(color(edges, N, M));
    }
    static boolean color(int edges[][], int n, int col){
        int mat[][] = new int[n][n];
        for(int i=0; i<edges.length; i++){
            mat[edges[i][0]][edges[i][1]] = 1;
            mat[edges[i][1]][edges[i][0]] = 1;
        }
        int nodecolor[] = new int[n];
        return solve(0, mat, n, col, nodecolor);
    }
    static boolean solve(int index, int mat[][], int n, int col, int nodecolor[]){
        if(index == n) return true;
        
        for(int c = 1; c <= col; c++){
            if(isSafe(index, mat, c, nodecolor)){
                nodecolor[index] = c;

                if(solve(index+1, mat, n, col, nodecolor) == true) return true;
                else nodecolor[index] = 0;
            }
        }
        return false;
    }
    static boolean isSafe(int index, int mat[][], int c, int nodecolor[]){
        for(int i=0; i<mat.length; i++){
            if(mat[index][i] == 1 && nodecolor[i] == c){
                return false;
            }
        }
        return true;
    }
}
