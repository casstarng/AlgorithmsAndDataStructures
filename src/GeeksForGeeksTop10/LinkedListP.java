package GeeksForGeeksTop10;

import java.util.Arrays;

public class LinkedListP {

    static class Node{
        Node next = null;
        int val;

        public Node(int val){
            this.val = val;
        }
    }

    public static void p1GivenASortedListInsert(Node head, Node prev, Node target){
        if(head.val < target.val && prev != null){
            prev.next = target;
            target.next = head;
            return;
        }
        else if(head.val < target.val && prev == null){
            target.next = head;
            return;
        }
        else{
            p1GivenASortedListInsert(head.next, head, target);
        }
    }

    public static void p2DeleteAGivenNodeUnderGivenConstraints(Node head, Node target){
        if (head == target){
            head.val = head.next.val;
            head.next = head.next.next;
        }
        else{
            Node previous = head;
            head = head.next;

            while(head != null){
                if(head == target){
                   previous.next = head.next;
                   return;
                }
                else{
                    previous = head;
                    head = head.next;
                }
            }
        }
    }

    public static int p3compareTwoStringsRepresentedAsLinkedLists(Node n1, Node n2){
        while(n1 != null && n2 != null){
            if(n1 == n2){
                n1 = n1.next;
                n2 = n2.next;
            }
            else{
                return (n1.val > n2.val ? 1 : -1);
            }
        }

        if(n1 != null && n2 == null){
            return 1;
        }
        else if(n1 == null && n2 != null){
            return -1;
        }
        else return 0;
    }

    public static int p4AddTwoNumbersRepresentedByLinkedLists(Node n1, Node n2){
        int node1 = 0;
        int node2 = 0;

        while(n1 != null){
            node1 *= 10;
            node1 += n1.val;
            n1 = n1.next;
        }

        while(n2 != null){
            node2 *= 10;
            node2 += n2.val;
            n2 = n2.next;
        }

        return node1 + node2;
    }

    

    public static void main(String[] args){
//        Node n2 = new Node(2);
//        Node n5 = new Node(5);
//        Node n7 = new Node(7);
//        Node n10 = new Node(10);
//        Node n15 = new Node(15);
//        Node n9 = new Node(9);
//
//        n2.next = n5;
//        n5.next = n7;
//        n7.next = n10;
//        n10.next = n15;

        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3);
        n5.next = n6;
        n6.next = n3;

        Node n8 = new Node(8);
        Node n4 = new Node(4);
        Node n2 = new Node(2);
        n8.next = n4;
        n4.next = n2;

        System.out.println(p4AddTwoNumbersRepresentedByLinkedLists(n5, n8));
    }
}
