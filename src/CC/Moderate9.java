package CC;

public class Moderate9 {


    public static int multiply(int n, int m){
        int result = 0;
        for(int i = 0; i < m; i++){
            result += n;
        }
        return result;
    }

    public static int subtract(int n, int m){
        int larger = 0;
        int smaller = 0;
        if(n < m){
            larger = m;
            smaller = n;
        }
        else{
            larger = n;
            smaller = m;
        }
        int diff = 0;

        for(int i = smaller; i < larger; i++){
            diff++;
        }

        if(n < m) return -diff;
        else return diff;
    }

    public static int divide(int n, int m){
        if(n < m) return 0;

        int result = 0;
        int tracker = 0;
        while(tracker + m <= n){
            result++;
            tracker += m;
        }

        return result;
    }

    public static void main(String[] args){
        //System.out.println(multiply(4, 9));
        //System.out.println(subtract(13, 2));
        System.out.println(divide(3, 3));
    }
}
