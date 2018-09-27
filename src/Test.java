import java.util.Stack;

public class Test {
    private static void checkBracket(String[] lines){
        for(String line : lines){
            String result = "YES";
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < line.length(); i++){
                char current = line.charAt(i);
                switch(current){
                    case '(':
                    case '{':
                    case '[':
                        stack.push(current);
                        break;
                    case ')':
                        if (stack.pop() != '(') result = "NO";
                        break;
                    case '}':
                        if (stack.pop() != '{') result = "NO";
                        break;
                    case ']':
                        if (stack.pop() != ']') result = "NO";
                        break;
                    default:
                        break;
                }
                if (result.equals("NO")) break;
            }
            if (!stack.isEmpty()) result = "NO";
            System.out.println(result);

        }
    }


    public static void main(String[] args){
        String[] lines = {"{}"};
        checkBracket(lines);
    }
}
