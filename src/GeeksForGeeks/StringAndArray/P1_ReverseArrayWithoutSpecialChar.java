package GeeksForGeeks.StringAndArray;

public class P1_ReverseArrayWithoutSpecialChar {

    public static String reverse(String str){

        int i = 0;
        int k = str.length() - 1;

        while(i < k){
            if (!Character.isLetter(str.charAt(i))){
                i++;
                continue;
            }
            else if (!Character.isLetter(str.charAt(k))){
                k--;
                continue;
            }

            String tempi = str.substring(i, i+1);
            String tempk = str.substring(k, k+1);
            str = str.substring(0, i) + tempk + str.substring(i + 1, k) + tempi + str.substring(k + 1, str.length());
            i++;
            k--;
        }

        return str;
    }

    public static void main(String[] args){
        String str = "Ab,c,de!$";
        System.out.println(reverse(str));
    }
}
