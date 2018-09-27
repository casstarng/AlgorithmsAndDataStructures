package Quora500;

import java.util.Arrays;
import java.util.HashMap;

public class DynamicProgramming {

    public static int longestCommonSubsequence(String s1, String s2){
        HashMap<String, Integer> map = new HashMap<>();
        return longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1, map);
    }

    public static int longestCommonSubsequence(String s1, String s2, int n, int m, HashMap<String, Integer> map){

        if(map.containsKey(m + " " + n)) return map.get(m + " " + n);

        if(n == 0 || m == 0) return 0;

        if(s1.charAt(n) == s2.charAt(m)){
            int result = 1 + longestCommonSubsequence(s1, s2, n-1, m-1, map);
            map.put(m + " " + n, result);
            return result;
        }

        int one = longestCommonSubsequence(s1, s2, n-1, m, map);
        int two = longestCommonSubsequence(s1, s2, n, m-1, map);

        int result = Math.max(one, two);
        map.put(m + " " + n, result);

        return Math.max(one, two);
    }

    public static void main(String[] args){
        int[] arr = { 1, 0, 2, 2, 4, 10, 9, 4};
        String s = "ABCBDAB";
        String s2 = "BDCABA";
        System.out.println(longestCommonSubsequence(s, s2));
    }
}
