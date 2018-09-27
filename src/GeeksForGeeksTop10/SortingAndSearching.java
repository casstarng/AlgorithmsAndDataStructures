package GeeksForGeeksTop10;

import java.util.Arrays;

public class SortingAndSearching {

    public static int p1BinarySearch(int[] arr, int target){
        return p1BinarySearch(arr, target, 0, arr.length - 1);
    }

    private static int p1BinarySearch(int[] arr, int target, int low, int high){
        if(low > high) return -1;

        int mid = (low + high) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) return p1BinarySearch(arr, target, mid + 1, high);
        else return p1BinarySearch(arr, target, low, mid - 1);

    }

    public static int p2SearchAnElementInASortedAndRotatedArray(int[] arr, int target){
        return p2SearchAnElementInASortedAndRotatedArray(arr, target, 0, arr.length - 1);
    }

    private static int p2SearchAnElementInASortedAndRotatedArray(int[] arr, int target, int low, int high){
        if(low > high) return -1;

        int mid = (low + high) / 2;
        if(arr[mid] == target) return mid;
        else{
            // If left is sorted
            if(arr[low] < arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    return p2SearchAnElementInASortedAndRotatedArray(arr, target, low, mid - 1);
                }
                else{
                    return p2SearchAnElementInASortedAndRotatedArray(arr, target, mid + 1, high);
                }
            }
            // If right is sorted
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    return p2SearchAnElementInASortedAndRotatedArray(arr, target, mid + 1, high);
                }
                else{
                    return p2SearchAnElementInASortedAndRotatedArray(arr, target, low, mid - 1);
                }
            }
        }
    }

    private static void p3BubbleSort(int[] arr){
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            int i = 0;
            while(i < arr.length - 1){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
                i++;
            }
        }
    }

    public static void p4InsertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int k = i - 1;

            if(current < arr[k]){
                while(k >= 0 && arr[k] > current){
                    arr[k + 1] = arr[k];
                    k--;
                }
                arr[k + 1] = current;
            }
        }
    }

    public static void p5MergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            p5MergeSort(arr, low, mid);
            p5MergeSort(arr, mid + 1, high);

            p5Merge(arr, low, high, mid);
        }
    }

    public static void p5Merge(int[] arr, int low, int high, int mid){
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        for(int i = 0; i < left.length; i++){
            left[i] = arr[low + i];
        }

        for(int i = 0; i < right.length; i++){
            right[i] = arr[mid + i + 1];
        }

        int i = 0;
        int k = 0;
        int m = low;

        while(i < left.length && k < right.length){
            if(left[i] < right[k]){
                arr[m] = left[i];
                i++;
                m++;
            }
            else{
                arr[m] = right[k];
                k++;
                m++;
            }
        }
        while(i < left.length){
            arr[m] = left[i];
            i++;
            m++;
        }
        while(k < right.length){
            arr[m] = right[k];
            k++;
            m++;
        }
    }

    public static void main(String[] args){
//        int arr[] = {0, 2, 3, 1};
        int arr[] = {0, 2, 3, 1};
        p5MergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
