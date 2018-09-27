package CC;

public class Moderate2 {

    public static int frequency(String book, String word){
        String[] arr = book.split(" ");
        int count = 0;
        for(String ar : arr){
            if(ar.equals(word)) count++;
        }
        return count;
    }

    public static void main(String[] args){
        String book = "The crow crows in the crow";
        String word = "crow";
        System.out.println(frequency(book, word));
    }
}
