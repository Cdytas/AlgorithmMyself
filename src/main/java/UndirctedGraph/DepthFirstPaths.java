package UndirctedGraph;

import java.util.Stack;

/* 此方法为寻找起点start到终点v的一条路径，但是找出的路径跟邻接表的结构有关，故不一定是最短路径*/
public class DepthFirstPaths {
    private boolean[] marked;  //用于标记某个顶点是否访问过
    private int[] edgeTo;  //存储其父节点，如edgeTo[2] = 3，表示3是2的父结点。此父结点是相对于路径而言，也可称为其前继结点
    private final int start;  //起点
    public DepthFirstPaths(Graph G, int start) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.start = start;
        dfs(G, start);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;   // 顶点v已访问
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;  //更新，v是w的父结点，并且只在第一次访问w时记录其父结点(w可能与多个结点连通，意味着它可以有多个父结点，只取第一个)
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int w) {   //若返回值为true，表示顶点start与顶点w连通
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v)  {  //返回起点start到终点v的一条路径
        if (!marked[v]) {  //不连通，没有路径
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != start; x = edgeTo[x]) {  //从路径尾部到头部
            path.push(x);
        }
        path.push(start);
        return path;
    }
}
