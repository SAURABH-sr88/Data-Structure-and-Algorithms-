package DSA.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j] ){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] myArr = {9,8,7,6,5,4,3,2,1};
        selectionSort(myArr);
        System.out.println(Arrays.toString(myArr));
    }
}
