// package Sortings;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    static void sort(int a[]){
        int n = a.length;
        for(int i=0; i<n-1; i++){
            int min_ind = i;
            for(int j=i+1; j<n; j++){
                if(a[j] < a[min_ind])
                    min_ind = j;
            }
            int t = a[min_ind];
            a[min_ind] = a[i];
            a[i] = t;
        }
    }
}
