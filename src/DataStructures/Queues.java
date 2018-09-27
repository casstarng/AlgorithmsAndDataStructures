package DataStructures;

public class Queues {

    public static class Node<T>{
        Node next;
        T val;

        public Node(T val){
            this.val = val;
            this.next = null;
        }
    }

    public static class Queue{
        Node first = null;
        Node last = null;

        public Queue(){
            first = null;
        }

        public void enQueue(Node node){
            if (first == null){
                first = node;
                last = first;
            }
            else{
                last.next = node;
            }
        }

        public Node deQueue(){
            Node firstRemoved = first;
            first = first.next;
            return firstRemoved;
        }
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enQueue(new Node(5));
        queue.enQueue(new Node(10));
        System.out.println(queue.deQueue().val);
        //System.out.println(queue.remove().val);
        //System.out.println(queue.remove().val);
    }

}
