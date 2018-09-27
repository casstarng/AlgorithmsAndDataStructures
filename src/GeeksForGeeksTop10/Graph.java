package GeeksForGeeksTop10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    static int v;
    static List<Integer> adj[];

    Graph(int v){
        this.v = v;
        adj = new List[v];
        for(int i = 0; i < v; i++){
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    public static void p1BFS(int s){
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[v];

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");

            for(int n : adj[s]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void p2DFS(int s){
        boolean[] visited = new boolean[v];
        p2DFS(s, visited);
    }

    public static void p2DFS(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + " ");

        for(int n : adj[s]){
            if(!visited[n]){
                p2DFS(n, visited);
            }
        }
    }

    public static void p3Dijkstra(){

    }



    public static void main(String[] args){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        p2DFS(2);
    }
}
