package Quora500;

import java.util.*;
import java.util.stream.IntStream;

public class Array {
    public static int[] findPairWithGivenSumInTheArray(int[] arr, int sum){
        //arr = [8, 7, 2, 5, 3, 1] sum = 10
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(sum - num)){
                int[] result = new int[2];
                result[0] = sum - num;
                result[1] = num;
                return result;
            }
            else{
                set.add(num);
            }
        }
        return new int[2];
    }

    public static boolean checkIfSubarrayWith0SumIsExistsOrNot(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(sum);
        for(int num : arr){
            sum += num;
            if(set.contains(sum)) return true;
            else{
                set.add(sum);
            }
        }
        return false;
    }

    public static void printAllSubArraysWith0Sum(int[] arr){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(sum,list);
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                list = map.get(sum);

                for(int num : list){
                    System.out.println(num + 1 + "..." + i);
                }
                list.add(i);
            }
            else{
                list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }

        }
    }

    public static void sortBinaryArrayInLinearTime(int[] arr){
        int count = 0;
        for(int num : arr){
            if(num == 0) count++;
        }
        for(int i = 0; i < arr.length; i++){
            if(count > 0){
                arr[i] = 0;
                count--;
            }
            else{
                arr[i] = 1;
            }
        }
    }

    public static int findADuplicateElementInALimitedRangeArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0) return Math.abs(arr[i]);
            else{
                arr[index] *= -1;
            }
        }
        return 0;
    }

    public static int findLargestSubarrayFormedByConsecutiveIntegers(){
        //TODO
        return 0;
    }

    public static int findMaximumLengthSubArrayHavingGivenSum(int[] arr, int target){
        List<Integer> lengths = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0, list);

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum-target)){
                list = map.get(sum-target);

                for(int num : list){
                    lengths.add(i - num);
                }

                list.add(i);
            }
            else if(map.containsKey(sum)){
                list = map.get(sum);
                list.add(i);
            }
            else{
                list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }
        }
        return Collections.max(lengths);
    }

    public static void findMaximumLengthSubarrayHavingEqualNumberOf0And1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) arr[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int length = 0;
        int endIndex = -1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum) && i - map.get(sum) > length){
                length = i - map.get(sum);
                endIndex = i;
            }
            else{
                map.put(sum, i);
            }
        }
        System.out.println(endIndex - length + 1 + "..." + endIndex);
    }

    public static void sortAnArrayContaining01And2DutchNationalFlag(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int pivot = 1;

        while(mid <= end){
            if(arr[mid] < pivot){
                swap(arr, mid, start);
                mid++;
                start++;
            }
            else if(arr[mid] > pivot){
                swap(arr, mid, end);
                end--;
            }
            else{
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void inPlaceMergeTwoSortedArrays(int[] X, int[] Y){
        for(int i = 0; i < X.length; i++){
            if(X[i] > Y[0]){
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                int first = Y[0];
                int k;
                for(k = 1; k < Y.length && Y[k] < first; k++){
                    Y[k - 1] = Y[k];
                }
                Y[k - 1] = first;
            }
        }
    }

    public static void mergeTwoArraysBySatisfyingGivenConstraints(int[] X, int[] Y){
        //TODO
        int k = 0;
        for(int i = 0; i < X.length; i++){
            if(X[i] != 0){
                X[k] = X[i];
                k++;
            }
        }

        mergeTwoArraysBySatisfyingGivenConstraints(X, Y, k - 1, Y.length - 1);

    }

    private static void mergeTwoArraysBySatisfyingGivenConstraints(int[] X, int[] Y, int m, int n){
        int k = m + n + 1;

        while(m >= 0 && n >= 0){
            if (Y[n] > X[m]){
                X[k] = Y[n];
                k--;
                n--;
            }
            else{
                X[k] = X[m];
                k--;
                m--;
            }
        }

        while(n >= 0){
            X[k] = Y[n];
            k--;
            n--;
        }
    }

    public static int findIndex0ToBeReplacedToGetMaximumLengthSequenceOfContinuousOnes(int[] arr){
        //TODO
       int max_length = 0;
       int max_index = 0;

       int previousIndex = -1;
       int count = 0;

       for(int i = 0; i < arr.length; i++){
           if(arr[i] == 1) count++;
           else{
               count = i - previousIndex;

               previousIndex = i;
           }

           if(count > max_length){
               max_length = count;
               max_index = previousIndex;
           }
       }

       return max_index;
    }

    public static int findMaximumProductOfTwoIntegerInAnArray(int[] arr){
        int largest = 0;
        int secondLargest = 0;

        int smallest = 0;
        int secondSmallest = 0;

        for(int num : arr){
            if(num < 0){
                if(num < smallest){
                    secondSmallest = smallest;
                    smallest = num;
                }
                else if(num < secondSmallest){
                    secondSmallest = num;
                }
            }
            if(num > 0){
                if(num > largest){
                    secondLargest = largest;
                    largest = num;
                }
                else if(num > secondLargest){
                    secondLargest = num;
                }
            }
        }

        return Math.max(largest  * secondLargest, smallest * secondSmallest);
    }

    public static void rearrangeTheArrayWithAlternateHighAndLowElements(int[] arr){
        for(int i = 1; i < arr.length; i+=2){
            if(arr[i] < arr[i - 1]){
                swap(arr, i, i-1);
            }

            if(i+1 < arr.length && arr[i] < arr[i + 1]){
                swap(arr, i, i + 1);
            }
        }
    }

    public static void findEquilibriumIndexOfAnArray(int[] arr){
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(i == 0) left[i] = arr[i];
            else left[i] = arr[i] + left[i-1];
        }

        for(int i = arr.length - 1; i >= 0; i--){
            if(i == arr.length - 1) right[i] = arr[i];
            else right[i] = arr[i] + right[i+1];
        }

        for(int i = 0; i < arr.length; i++){
            if(left[i] == right[i]) System.out.println(i);
        }
    }

    public static int findMajorityElementInAnArray(int[] A){
        //TODO
        return 0;
    }

    public static void moveAllZerosPresentInTheArrayToTheEnd(int[] A){
        int k = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                swap(A, i, k);
                k++;
            }
        }
    }

    public static void replaceEachElementOfTheArrayWithProductOfEveryOtherElementWithoutUsingDivisionOperator(int[] arr){
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 1;
        for(int i = 1; i < left.length; i++){
            left[i] = arr[i - 1] * left[i - 1];
        }

        right[arr.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--){
            right[i] = arr[i + 1] * right[i + 1];
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = left[i] * right[i];
        }
    }

    public static void findLongestBitonicSubarrayInAnArray(int[] arr){
        //TODO
    }

    public static int findMaximumDifferenceBetweenTwoElementsInTheArrayBySatisfyingGivenConstraints(int[] arr){
        int max = arr[arr.length - 1];
        int diff = Integer.MIN_VALUE;

        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > max) max = arr[i];
            else{
                diff = Math.max(diff, max - arr[i]);
            }
        }
        return diff;
    }

    public static int maximumSubarrayProblem(int[] arr){
        int current_max = arr[0];
        int global_max = arr[0];

        for(int i = 1; i < arr.length; i++){
            current_max = Math.max(arr[i], arr[i] + current_max);

            if(current_max > global_max) global_max = current_max;
        }
        return global_max;
    }

    public static void printContinuousSubarrayWithMaximumSum(int[] arr){
        int current_max = 0;
        int global_max = 0;
        int current_start = 0;
        int current_end = 0;

        int global_start = 0;
        int global_end = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > arr[i] + current_max){
                current_max = arr[i];
                current_start = i;
                current_end = i;
            }
            else{
                current_max += arr[i];
                current_end = i;
            }

            if(global_max < current_max){
                global_max = current_max;
                global_start = current_start;
                global_end = current_end;
            }
        }

        for(int i = global_start; i <= global_end; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void maximumSumCircularSubarray(int[] arr){
        //TODO
    }

    public static List<List<Integer>> findAllDistinctCombinationsOfGivenLength(int[] arr){
        //TODO
        List<List<Integer>> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args){
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        printContinuousSubarrayWithMaximumSum(A);

       // System.out.print(maximumSubarrayProblem(A));
    }
}
