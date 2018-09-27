package CC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Moderate11 {


    public static HashSet<Integer> moderate11(int k){
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        moderate11(k, 0, set, visited);
        return set;
    }

    private static void moderate11(int k, int sum, HashSet<Integer> set, HashSet<String> visited){
        int shorter = 5;
        int longer = 8;
        if(k == 0){
            set.add(sum);
            return;
        }

        String key = k + " " + sum;
        if(visited.contains(key)) return;

        else{

            moderate11(k - 1, sum + shorter, set, visited);
            moderate11(k - 1, sum + longer, set, visited);

            visited.add(key);
        }
    }

    private static void moderate14(){

    }

//    public static String moderate16(String slot, String guess){
//        int hit = 0;
//        slot.toCharArray();
//    }

    public static void main(String[] args){
        System.out.println(moderate11(3).toString());
    }
}
