import java.util.Arrays;

public class N_meetings_in_one_room {

    static class Meeting {
        int start;
        int end;
        Meeting(int s, int e){
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {

        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1   = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(start1, end1, start1.length)); 
    }
    static int maxMeetings(int s[], int e[], int n){

         // Step 1: Store meetings
         // Step 2: Sort by end time
         // Step 3: Select meetings

        if(n == 0) return 0;        // Important

         Meeting m[] = new Meeting[n];
         for(int i=0; i<n; i++){
            m[i] = new Meeting(s[i], e[i]);
         }

         Arrays.sort(m, (a,b) -> a.end - b.end);

         int endtime = m[0].end;
         int cnt = 1;
         for(int i=1; i<n; i++){
            if(m[i].start > endtime){
                cnt++;
                endtime = m[i].end;
            }
         }
         return cnt;
    }
}
