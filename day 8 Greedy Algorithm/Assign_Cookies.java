import java.util.Arrays;

public class Assign_Cookies {

    static int findContentChildren(int[] student, int[] cookie) {

        // Step 1: Sort both student and cookie arrays
        // Step 2: Use two pointers to match smallest student with smallest cookie
        // Step 3: If cookie can satisfy student, assign and move both pointers
        // Step 4: Otherwise, try next larger cookie
        // Step 5: Return total number of students satisfied
        Arrays.sort(student);
        Arrays.sort(cookie);

        int i = 0, j= 0;
        int satisfied = 0;
        int m = cookie.length, n = student.length;
        while(i < m && j < student.length){
            if(cookie[i] >= student[j]){
                satisfied++;
                i++;
                j++;
            }
            else 
                i++;
        }
        return satisfied;
    }

    public static void main(String[] args) {

        int[] student = {1, 2, 3};
        int[] cookie = {1, 2};

        System.out.println(findContentChildren(student, cookie));
    }
}
