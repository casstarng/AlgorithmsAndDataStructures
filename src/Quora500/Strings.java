package Quora500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Strings {

    public static boolean checkIfAStringIsRotatedPalindromeOrNot(String s1, String s2){
        String concat = s1 + s1;
        if(s1.length() != s2.length()) return false;
        return concat.contains(s2);
    }

    public static void longestPalindromicSubstring(){
        //TODO
    }

    public static boolean checkIfRepeatedSubsequenceIsPresentInTheStringOrnot(){
        //TODO
        return false;
    }

    public static boolean checkIfStringsCanBeDerivedFromEachOtherByCircularlyRotatingThem(String X, String Y){
        for(int i = 0; i < X.length(); i++){
            if(Y.equals(X.substring(i, X.length()) + X.substring(0, i))) return true;
        }
        return false;
    }

    public static boolean findDuplicateParanthesisInAnExpression(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ')'){
                stack.push(c);
            }
            else{
                if(stack.peek() == '(') return true;

                while(stack.peek() != '('){
                    stack.pop();
                }

                stack.pop();
            }
        }
        return false;
    }

    public static boolean checkIfGivenSetOfMovesIsCircularOrNot(String s){
        int x = 0;
        int y = 0;

        //0 = N, 1 = E, 2 = S, 3 = W
        int direction = 0;

        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'R':
                    direction++;
                    direction %= 4;
                    break;
                case 'L':
                    direction--;
                    if(direction == -1) direction = 3;
                    break;
                case 'M':
                    if(direction == 0) x++;
                    else if(direction == 1) y++;
                    else if(direction == 2) x--;
                    else if(direction == 3) y--;
                    break;
            }

        }

        return x == 0 && y == 0;
    }

    public static String convertGivenNumberIntoCorrespondingExcelColumnName(){
        return null;
        //TODO
    }

    public static void findAllBinaryStringsThatCanBeFormedFromGivenWildcardPattern(String s, int index){

        if(index == s.length()){
            System.out.println(s);
            return;
        }

        char current = s.charAt(index);
        if(current == '?'){
            String with0 = s.substring(0, index) + "0" + s.substring(index + 1, s.length());
            String with1 = s.substring(0, index) + "1" + s.substring(index + 1, s.length());

            findAllBinaryStringsThatCanBeFormedFromGivenWildcardPattern(with0, index + 1);
            findAllBinaryStringsThatCanBeFormedFromGivenWildcardPattern(with1, index + 1);
        }
        else{
            findAllBinaryStringsThatCanBeFormedFromGivenWildcardPattern(s, index + 1);
        }
    }

    public static void findAllInterleavingsOfGivenStrings(String result, String X, String Y, int XIndex, int YIndex, HashSet<String> res){

        if(XIndex == X.length() && YIndex == Y.length()){
            res.add(result);
            return;
        }

        if(XIndex < X.length()) findAllInterleavingsOfGivenStrings(result + X.charAt(XIndex), X, Y, XIndex + 1, YIndex, res);
        if(YIndex < Y.length()) findAllInterleavingsOfGivenStrings(result + Y.charAt(YIndex), X, Y, XIndex, YIndex + 1, res);
    }

    public static boolean isomorphicStrings(String s1, String s2){
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        if(s1.length() != s2.length()) return false;
        for(int i = 0; i < s1.length(); i++){
            char x = s1.charAt(i);
            char y = s2.charAt(i);

            if(map.containsKey(x)){
                if(map.get(x) != y) return false;
            }
            else{
                if(set.contains(y)) return false;
                else{
                    map.put(x, y);
                    set.add(y);
                }
            }
        }

        return true;
    }

    public static HashSet<String> findAllPossiblePalindromicSubstringsInAString(String s){
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            fappsiasExpand(s, i, i, set);
            fappsiasExpand(s, i, i+1, set);
        }

        System.out.println(set.toString());

        return set;
    }

    private static void fappsiasExpand(String s, int i, int k, HashSet<String> set){
        while(i >= 0 && k < s.length()){
            if(s.charAt(i) == s.charAt(k)){
                set.add(s.substring(i, k + 1));
                i--;
                k++;
            }
            else return;
        }
    }

    public static void findAllPossibleCombinationsOfWordsFormedFromMobileKeypad(int[] arr){
        //TODO
    }

    public static void main(String[] args){

        String str = "google";

        findAllPossiblePalindromicSubstringsInAString(str);
    }
}
