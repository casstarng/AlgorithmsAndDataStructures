package GeeksForGeeksTop10;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBST {

    static class Node{
        Node left = null;
        Node right = null;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    public static int p1FindMinimumDepthOfABinaryTree(Node root){
        if(root == null) return 0;
        return p1FindMinimumDepthOfABinaryTree(root, 1);
    }

    public static int p1FindMinimumDepthOfABinaryTree(Node root, int level){
        if(root.left == null && root.right == null) return level;

        int leftLevel = Integer.MAX_VALUE;
        int rightLevel = Integer.MAX_VALUE;
        if(root.left != null) leftLevel = p1FindMinimumDepthOfABinaryTree(root.left, level + 1);
        if(root.right != null) rightLevel = p1FindMinimumDepthOfABinaryTree(root.right, level + 1);

        return Math.min(leftLevel, rightLevel);

    }

    public static int p2MaximumPathSumInABinaryTree(Node root){
        //TODO
        return 0;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(6);


        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(p1FindMinimumDepthOfABinaryTree(root));
    }
}
