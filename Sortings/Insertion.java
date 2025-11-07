//package Sortings;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    static void sort(int a[]){
        int n = a.length;
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                while(j>0 && a[j-1] > a[j]){
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;

                    j--;
                }
            }
        }
    }
}
