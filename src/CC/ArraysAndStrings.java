package CC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArraysAndStrings {

    public static boolean Q1IsUnique(String s){
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)) return false;
            else set.add(c);
        }

        return true;
    }

    public static boolean Q2CheckPermutation(String s, String p){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(!map.containsKey(c)) return false;
            else{
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static String Q3URLify(String s){
        return s.replace(" ", "%20");
    }

    public static boolean Q4PalindromePermutation(String s){
        s = s.replace(" ", "").toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        boolean oddExists = false;

        for(Character key : map.keySet()){
            if(map.get(key) % 2 != 0){
                if (!oddExists) oddExists = true;
                else return false;
            }
        }

        return true;
    }

    public static boolean Q5OneAway(String s, String p){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        boolean editFound = false;

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);

            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
            }
            else{
                if(!editFound) editFound = true;
                else return false;
            }
        }

        if(s.length() == p.length()) editFound = false;

        for(char key : map.keySet()){
            if(!editFound) editFound = true;
            else return false;
        }
        return true;

    }

    public static String Q6StringCompression(String s){
        int i = 1;

        StringBuilder p = new StringBuilder();

        int count = 1;
        char c = s.charAt(i);
        while(i < s.length()){
            if(s.charAt(i) == c) count++;
            else{
                p.append(c);
                p.append(count);
                count = 1;
                c = s.charAt(i);
            }
            i++;
        }
        p.append(c);
        p.append(count);

        if(p.length() > s.length()) return s;
        else return p.toString();
    }

//    public static void Q7RotateMatrix(int[][] matrix){
//        for(int i = 0; i < matrix.length / 2; i++){
//            for(int k = i; i < )
//        }
//    }

    public static void Q8ZeroMatrix(int[][] matrix){
        boolean yHas0 = false;
        boolean xHas0 = false;
        //Check if y has 0
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                yHas0 = true;
                break;
            }
        }
        //Check if x has 0
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                xHas0 = true;
                break;
            }
        }

        //Search through matrix
        for(int y = 1; y < matrix.length; y++){
            for(int x = 1; x < matrix[y].length; x++){
                if(matrix[y][x] == 0){
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;
                }
            }
        }

        //Add 0 for y
        for(int y = 1; y < matrix.length; y++){
            if(matrix[y][0] == 0){
                for(int x = 1; x < matrix[y].length; x++){
                    matrix[y][x] = 0;
                }
            }
        }

        //Add 0 for x
        for(int x = 1; x < matrix[0].length; x++){
            if(matrix[0][x] == 0){
                for(int y = 1; y < matrix.length; y++){
                    matrix[y][x] = 0;
                }
            }
        }

        if(yHas0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(xHas0){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Q8ZeroMatrix(matrix);
        for(int y = 0; y < matrix.length; y++){
            for(int x = 0; x < matrix[y].length; x++){
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
    }
}
