package UndirctedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;  //到达该顶点的最短路径是否已找到?
    private int[] edgeTo;  //最短路径上，到达某个顶点的前继结点，也可称为其父结点
    private final int start;  //起点

    public BreadthFirstPaths(Graph G, int start) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.start = start;
        bfs(G, start);
    }

    private void bfs(Graph G, int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        marked[start] = true;
        deque.offerLast(start);  //入队
        while (!deque.isEmpty()) {
            int v = deque.removeFirst();   //出队
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    deque.offerLast(w);  //入队
                }
            }
        }
    }

    public boolean hasPathTo(int v) {  //起点start到终点v是否有路径
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) {  //不连通，没有路径
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != start; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path;
    }

}
