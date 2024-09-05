package UndirctedGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;  //顶点数目
    private int E;  //边的数目
    private List<Integer>[] adj;   //邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {    //获取某个顶点的邻接链表
        return adj[v];
    }

}
