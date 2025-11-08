public class Search_2D_Matrix {
    public static void main(String[] args) {
        int m[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(find(m, target));
    }
    static boolean find(int m[][], int target){
        int r = m.length, c = m[0].length;
        int low = 0;
        int high = r*c-1;
        while(low <= high){
            int mid = (low + high)/2;
            int row = mid / c;
            int col = mid % c;
            if(m[row][col] == target) return true;
            else if(m[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
