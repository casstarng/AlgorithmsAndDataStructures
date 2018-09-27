package DataStructures;

public class Stacks {

    public static class Node{
        Node next;
        int val;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static class Stack{
        Node top;

        public Stack(){
            top = null;
        }

        public void push(Node node){
            node.next = top;
            top = node;
        }

        public Node pop(){
            try{
                Node popped = top;
                top = top.next;
                return popped;
            }
            catch (NullPointerException e){
                System.out.println("End of Stack");
            }
            return null;
        }

        public Node peek(){
            return top;
        }

        public boolean isEmpty(){
            if (top == null){
                return true;
            }
            else return false;
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(new Node(10));
        stack.push(new Node(11));
        System.out.println(stack.pop().val);
        System.out.println(stack.peek().val);
        System.out.println(stack.pop().val);
        System.out.println(stack.isEmpty());
    }
}
