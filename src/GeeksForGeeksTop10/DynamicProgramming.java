package GeeksForGeeksTop10;

import java.util.HashMap;

public class DynamicProgramming {

    public static String p1LongestCommonSequence(String A, String B){
        HashMap<String, String> map = new HashMap<>();
        return p1LongestCommonSequence(A, B, A.length() - 1, B.length() - 1, "", map);
    }

    private static String p1LongestCommonSequence(String A, String B, int i, int k, String result, HashMap<String, String> map){
        if(i < 0 || k < 0) return result;
        if(map.containsKey(i + " " + k)){
            return map.get(i + " " + k);
        }
        if(A.charAt(i) == B.charAt(k)){
            result = A.charAt(i) + result;
            map.put(i + " " + k, result);
            return p1LongestCommonSequence(A, B, i - 1, k - 1, result, map);
        }
        else{
            String left = p1LongestCommonSequence(A, B, i, k - 1, result, map);
            String right = p1LongestCommonSequence(A, B, i - 1, k, result, map);
            if(left.length() > right.length()){
                map.put(i + " " + (k - 1), left);
                return left;
            }
            else{
                map.put((i - 1) + " " + k, left);
                return right;
            }
        }
    }

//    Input  : arr[] = {3, 10, 2, 1, 20}
//    Output : Length of LIS = 3
//    The longest increasing subsequence is 3, 10, 20
    public static int p2LongestIncreasingSubsequence(int[] arr){
        return 00000;
    }

    public static void main(String[] args){
        String A = "ABCDGH";
        String B = "AEDFHR";

        System.out.println(p1LongestCommonSequence(A, B));
    }
}
