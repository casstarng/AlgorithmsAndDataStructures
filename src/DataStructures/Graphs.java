package DataStructures;

import java.util.ArrayList;

public class Graphs {

    public static class Node<T>{
        T data;
        ArrayList<Node> children = new ArrayList<>();

        public Node(T data){
            this.data = data;
        }

        public void addChildren(Node node){
            children.add(node);
        }

        public void removeChildren(Node node){
            children.remove(node);
        }
    }

    public static class Graph{
        ArrayList<Node> nodes = new ArrayList<>();

        public Graph(Node node){
            nodes.add(node);
        }

        public void add(Node link, Node node){
            boolean found = false;
            for (Node currentNode : nodes){
                if (currentNode == link){
                    nodes.add(node);
                    currentNode.addChildren(node);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("ERROR: Link is invalid");
        }
    }

    public static void main(String[] args){
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(10);
        Graph graph = new Graph(n1);
        graph.add(n1, n2);

    }
}
