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

            merge(left, mid, right, arr);
        }
    }

    public static void merge(int left, int mid, int right, int[] arr){
        int lSize = mid - left + 1;
        int rSize = right - mid;

        int[] L = new int[lSize];
        int[] R = new int[rSize];

        for(int i = 0; i < L.length; i++){
            L[i] = arr[left + i];
        }
        for(int i = 0; i < R.length; i++){
            R[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int k = 0;
        int j = left;

        while(i < lSize && k < rSize){
            if (L[i] < R[k]){
                arr[j] = L[i];
                j++;
                i++;
            }
            else{
                arr[j] = R[k];
                j++;
                k++;
            }
        }
        while (i < lSize){
            arr[j] = L[i];
            j++;
            i++;
        }
        while (k < rSize){
            arr[j] = R[k];
            j++;
            k++;
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
