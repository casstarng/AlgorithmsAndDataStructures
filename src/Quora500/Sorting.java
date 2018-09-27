package Quora500;

import java.util.Arrays;

public class Sorting {

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int k = i -1;
            while(k >= 0 && arr[k] > current){
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = current;
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int smallest = i;
            for(int k = i + 1; k < arr.length; k++){
                if(arr[k] < arr[smallest]) smallest = k;
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr){
        boolean done = false;
        while(!done){
            done = true;
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    done = false;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, right, mid);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid){
        int[] L = new int[mid - left + 1];
        int[] R = new int[right - mid];

        for(int i = 0; i < L.length; i++){
            L[i] = arr[left + i];
        }
        for(int i = 0; i < R.length; i++){
            R[i] = arr[i + mid + 1];
        }

        int i = 0;
        int k = 0;
        int m = left;

        while(i < L.length && k < R.length){
            if(L[i] < R[k]){
                arr[m] = L[i];
                m++;
                i++;
            }
            else{
                arr[m] = R[k];
                m++;
                k++;
            }
        }
        while(i < L.length){
            arr[m] = L[i];
            m++;
            i++;
        }
        while(k < R.length){
            arr[m] = R[k];
            m++;
            k++;
        }

    }

    public static void main(String[] args){
        int[] arr = { 1, 0, 2, 2, 4, 10, 9, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
