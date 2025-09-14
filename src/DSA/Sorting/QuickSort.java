package DSA.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int pivot(int[] arr, int pI, int index){
        int swapIndex = pI;
        for (int i = pI+1 ; i <= index ; i++) {
            if (arr[i] < arr[pI]){
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pI, swapIndex);
        return swapIndex;
    }

    public static void quickSortHelper(int[] arr, int left, int right){
        if (left < right){
            int pivot = pivot(arr, left, right);
            quickSortHelper(arr, left, pivot-1);
            quickSortHelper(arr, pivot+1, right);
        }
    }
    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }


    public static void main(String[] args) {
        int[] arr = {4,6,1,7,3,2,5};
        int returnedIndex = pivot(arr, 0, 6);
        quickSort(arr);
        System.out.println("Returned Index :"+ returnedIndex);
        System.out.println(Arrays.toString(arr));
    }
}
