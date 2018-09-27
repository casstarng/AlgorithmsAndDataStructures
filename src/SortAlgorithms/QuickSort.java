package SortAlgorithms;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = {4, 3, 2, 1, 5, 33, 5};

        quickSort(0, arr.length - 1, arr);

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void quickSort(int left, int right, int[] arr){
        if (left < right){
            int mid = partition(left, right, arr);

            quickSort(left, mid - 1, arr);
            quickSort(mid + 1, right, arr);
        }
    }

    public static int partition(int left, int right, int[] arr){
        int pivot = arr[right];

        int i = left - 1;

        for(int k = left; k < right; k++){
            if (arr[k] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }

        i++;
        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }

//    public static void quickSort(int left, int right, int[] arr){
//        if (left < right){
//            int mid = partition(left, right, arr);
//
//            quickSort(left, mid - 1, arr);
//            quickSort(mid + 1, right, arr);
//        }
//    }
//
//    public static int partition(int left, int right, int[] arr){
//        int pivot = arr[right];
//
//        // place first pointer -1 below start
//        int i = left - 1;
//
//        for (int k = left; k < right; k++){
//            // if current point is less than pivot
//            if (arr[k] < pivot){
//
//                // increment i and swap with k
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[k];
//                arr[k] = temp;
//            }
//        }
//
//        // swap pivot with i + 1
//        arr[right] = arr[i + 1];
//        arr[i + 1] = pivot;
//
//        return i + 1;
//    }

}
