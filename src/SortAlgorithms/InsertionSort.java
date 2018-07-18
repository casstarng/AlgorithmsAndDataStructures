package SortAlgorithms;

/**
 * Created by Cassidy Tarng on 7/17/2018.
 */
public class InsertionSort {

    public static void main(String[] args){
        int[] arr = {4, 3, 2, 1, 5, 33, 5};

        insertionSort(arr);

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] arr){
        if (arr.length == 0) return;

        for(int i = 1; i < arr.length; i++){
            // Get current key at i
            int key = arr[i];
            // Starting from key - 1
            int index = i - 1;
            while(index >= 0 && arr[index] > key){
                // Move to right
                arr[index + 1] = arr[index];
                index--;
            }
            // Replace at end
            arr[index + 1] = key;
        }
    }
}
