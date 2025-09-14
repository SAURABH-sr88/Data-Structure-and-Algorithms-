package DSA.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void inserionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] ;
            int j = i-1 ;
            while (j > -1 && temp < arr[j]){
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        inserionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
