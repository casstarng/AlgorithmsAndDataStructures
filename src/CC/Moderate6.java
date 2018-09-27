package CC;

import java.util.Arrays;
import java.util.Collections;

public class Moderate6 {

    public static int smallestDiff(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int k = 0;

        int minDiff = Integer.MAX_VALUE;

        while(i < A.length && k < B.length){
            int diff = Math.abs(A[i] - B[k]);
            if(diff < minDiff){
                minDiff = diff;
            }
            if(A[i] < B[k]){
                i++;
            }
            else k++;
        }

        return minDiff;
    }

    public static void main(String[] args){
        int[] A = {1, 2, 11, 15};
        int[] B = {4, 12, 19, 23, 127, 235};
        System.out.println(smallestDiff(A, B));
    }
}
