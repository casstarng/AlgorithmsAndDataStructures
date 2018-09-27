import java.util.*;

class Solution {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);

        for(int i = 0; i < s.length() - p.length(); i++){
            char[] sArr = s.substring(i, p.length()).toCharArray();
            Arrays.sort(sArr);

            if(Arrays.equals(sArr, pArr)) result.add(i);
        }

        return result;
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        findAnagrams("cbaebabacd", "abc");
    }

}