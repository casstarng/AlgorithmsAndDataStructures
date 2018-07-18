package SortAlgorithms;

/**
 * Created by Cassidy Tarng on 7/17/2018.
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {4, 3, 2, 1, 5, 33, 5};

        selectionSort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            // Find the minimum value index on right
            int minIndex = i;
            for (int k = i + 1; k < arr.length; k++){
                // If new minimum is found, replace
                if (arr[k] < arr[minIndex]){
                    minIndex = k;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
