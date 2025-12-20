import java.util.*;

public class Job_Sequencing {

    static int[] jobScheduling(int[][] j, int n) {

        // Step 1: Sort jobs based on profit in descending order
        // Step 2: Find maximum deadline
        // Step 3: Create a time slot array to track occupied slots
        // Step 4: Schedule each job in the latest available slot before its deadline
        // Step 5: Count number of jobs done and total profit
        Arrays.sort(j, (a,b) -> b[2]-a[2]);     // Descending order
        int maxdeadline = j[0][1];
        for(int i=1; i<n; i++)
            maxdeadline = Math.max(maxdeadline, j[i][1]);

        boolean time[] = new boolean[maxdeadline+1];
        int cnt = 0, profit = 0;;
        
        for(int i=0; i<n; i++){
            for(int k=j[i][1]; k>0; k--){
                if(!time[k]){
                    time[k] = true;
                    cnt++;
                    profit += j[i][2];
                    break;
                }
            }
        }

        return new int[]{cnt, profit};
    }

    public static void main(String[] args) {

        int[][] jobs = {
            {1, 4, 20},
            {2, 1, 10},
            {3, 1, 40},
            {4, 1, 30}
        };

        int[] result = jobScheduling(jobs, jobs.length);
        System.out.println(result[0] + " " + result[1]);
    }
}
