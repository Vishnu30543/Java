import java.util.Arrays;

public class Minimum_Platforms {    // TC : O(nlogn)

    static int findPlatform(int[] arr, int[] dep, int n) {

        // Step 1: Handle edge case (no trains)
        // Step 2: Sort arrival and departure times
        // Step 3: Use two pointers to track platforms needed
        // Step 4: Update maximum platforms required
        if(n == 0) return 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int platforms = 0, max = 0;
        while (i < n && j < n) {
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            max = Math.max(platforms, max);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arrival, departure, arrival.length));
    }
}
