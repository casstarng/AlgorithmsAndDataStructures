package CC;

public class Moderate5 {

    public static int trailingZero(int n){
        int count = 0;
        for(int i = 5; n/i > 0; i *=5){
            count += n/i;
        }
        return count;
    }

    public static void main(String[] args){

    }
}
