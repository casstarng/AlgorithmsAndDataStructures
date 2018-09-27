package CC;

public class Moderate1 {


    public static void swap(int[] arr, int i, int k){
        arr[i] = arr[i] - arr[k];
        arr[k] = arr[i] + arr[k];
        arr[i] = arr[k] - arr[i];
    }

    public static void main(String[] args){
        int[] arr = {1, 7, 3, 9, 15};
        swap(arr, 1, 4);
        System.out.println(arr[1]);
        System.out.println(arr[4]);
    }
}
