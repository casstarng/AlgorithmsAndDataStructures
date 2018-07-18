package SortAlgorithms;

/**
 * Created by Cassidy Tarng on 7/17/2018.
 */
public class MergeSort {

    public static void main(String[] args){
        int[] arr = {4, 3, 2, 1, 5, 33, 5};

        mergeSort(0, arr.length - 1, arr);

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void mergeSort(int left, int right, int[] arr){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid, arr);
            mergeSort(mid + 1, right, arr);

            merge(left, right, mid, arr);
        }
    }

    public static void merge(int left, int right, int mid, int[] arr){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Initialize left and right array
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];

        // Fill in new arrays
        for(int i = 0; i < leftSize; i++){
            L[i] = arr[left + i];
        }
        for(int i = 0; i < rightSize; i++){
            R[i] = arr[i + mid + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge temp arrays back into arr
        while (i < leftSize && j < rightSize){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining of L
        while (i < leftSize){
            arr[k] = L[i];
            k++;
            i++;
        }
        // Copy remaining of R
        while(j < rightSize){
            arr[k] = R[j];
            k++;
            j++;
        }

    }

//    public static void mergeSort(int left, int right, int[] arr){
//        if (left < right){
//            int mid = (left + right) / 2;
//            mergeSort(left, mid, arr);
//            mergeSort(mid + 1, right, arr);
//
//            merge(left, mid, right, arr);
//        }
//
//    }
//
//    public static void merge(int left, int mid, int right, int[] arr){
//        int leftSize = mid - left + 1;
//        int rightSize = right - mid;
//
//        int[] L = new int[leftSize];
//        int[] R = new int[rightSize];
//
//        for(int i = 0; i < leftSize; i++){
//            L[i] = arr[left + i];
//        }
//        for(int i = 0; i < rightSize; i++){
//            R[i] = arr[mid + 1 + i];
//        }
//
//        int i = 0;
//        int k = 0;
//        int count = left;
//
//        while (i < leftSize && k < rightSize){
//            if (L[i] < R[k]){
//                arr[count] = L[i];
//                i++;
//                count++;
//            }
//            else{
//                arr[count] = R[k];
//                k++;
//                count++;
//            }
//        }
//        while (i < leftSize){
//            arr[count] = L[i];
//            i++;
//            count++;
//        }
//        while (k < rightSize){
//            arr[count] = R[k];
//            k++;
//            count++;
//        }
//    }
}
