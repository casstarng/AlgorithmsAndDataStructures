package CC;

public class Moderate8 {

    static String[] digit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] doubleDigit = {"Zero", "teen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String intToEng(int n){
        String result = "";
        int doubleCounter = 1;
        int multiplier = 1;
        while(n > 0){
            int rightMost = n % 10;

            String currentResult = "";
            if(doubleCounter % 2 == 0){
                currentResult = doubleDigit[rightMost];
            }
            else currentResult = digit[rightMost];

            if(multiplier == 100) currentResult += "Hundred ";
            else if(multiplier == 1000) currentResult += "Thousand ";

            result = currentResult + " " + result;

            n /= 10;

            doubleCounter += 1;
            multiplier *= 10;
        }
        return result;
    }

    public static void main(String[] args){
        String expected = "One Thousand, Two Hundred Thirty Four";
        int n = 1234;

        //TODO REDO
        System.out.println(intToEng(n));
    }
}
