public class FindDuplicateNumber_withoutManipulation {  // Efficient
    public static void main(String[] args) {
        int a[] = {1,3,4,2,2};
        System.out.println(find(a));
    }
    static int find(int a[]){
        int n = a.length;
        int slow = 0;
        int fast = 0;
        do{
            slow = a[slow];
            fast = a[a[fast]];
        }while(slow != fast);

        slow = 0;
        while(slow != fast){
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
