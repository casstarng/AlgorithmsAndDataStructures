package GeeksForGeeksTop10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArray {

    public static void p1ReverseArrayWithoutAffectingSpecialCharacters(char[] arr){
        int i = 0;
        int k = arr.length - 1;

        while(i < k){
            if(!Character.isLetter(arr[i]) && !Character.isDigit(arr[i])){
                i++;
            }
            else if(!Character.isLetter(arr[k]) && !Character.isDigit(arr[k])){
                k--;
            }
            else{
                char temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                i++;
                k--;
            }
        }
    }

    public static void p2AllPossiblePalindromicPartitions(String s, String result){
        //TODO
    }

    public static void p3CountTripletsWithSumSmallerThanValue(int[] arr, int sum){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++){
            int m = i + 1;
            int n = arr.length - 1;

            while(m < n){
                if(arr[i] + arr[m] + arr[n] < sum){
                    System.out.println(arr[i] + " " + arr[m] + " " + arr[n]);
                    m++;
                }
                else{
                    n--;
                }

            }

        }
    }

    public static void p4ConvertArrayIntoZigZag(int[] arr){
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++){
            if(flag){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            else{
                if(arr[i] < arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag;
        }
    }

    public static void p5GenerateAllPossibleSortedArraysFromAlternateElements(int[] A, int[] B){
        //TODO

    }

    public static boolean p6PythagoreanTripletInAnUnsortedArray(int[] arr){

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int) Math.pow(arr[i], 2);
        }

        Arrays.sort(arr);

        for(int i = arr.length - 1; i > 1; i--){
            int m = 0;
            int n = i - 1;

            while(m < n) {
                if(arr[m] + arr[n] == arr[i]) return true;
                else if (arr[m] + arr[n] < arr[i]) m++;
                else n--;
            }
        }

        return false;
    }

    public static int p7LengthOfLargestSubarrayWithContiguousElements(int[] arr){
        int maxLength = 0;
        for(int i = 0; i < arr.length - 1; i++){

            int max = arr[i];
            int min = arr[i];

            for(int k = i + 1; k < arr.length; k++){
                max = Math.max(max, arr[k]);
                min = Math.min(min, arr[k]);

                if(max - min == k - i){
                    maxLength = Math.max(maxLength, max - min + 1);
                }
            }

        }

        return maxLength;
    }

    public static int p8FindTheSmallestPositiveIntegerValueThatCannotBeRepresentedAsSum(int[] arr){
        int result = 1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > result) return result;
            else{
                result += arr[i];
            }
        }

        return result;
    }

    public static int p9SmallestSubarrayWithSumGreatherThanGivenValue(int[] arr, int sum){

        int smallestSubArray = arr.length;
        int i = 0;
        int k = 0;

        int currentSum = arr[0];
        while(i < arr.length){

            if(currentSum > sum){
                if(i - k + 1 <= smallestSubArray){
                    smallestSubArray = i - k + 1;
                }
                currentSum -= arr[k];
                k++;


                if(k > i) break;
            }

            else{
                i++;
                if(i >= arr.length) break;
                currentSum += arr[i];
            }
        }

        return smallestSubArray;
    }



    public static void main(String[] args){
        int[] arr = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        //          {1, 5, 51, 57, 57, 76}
        int x  =  280;

        System.out.println(p9SmallestSubarrayWithSumGreatherThanGivenValue(arr, x));
    }
}
