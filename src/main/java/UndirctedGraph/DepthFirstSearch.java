package UndirctedGraph;

public class DepthFirstSearch {
    private boolean[] marked;  //用于标记某个顶点是否访问过
    private int count;  //与顶点start连通的顶点总数（包括其自身在内）
    public DepthFirstSearch(Graph G, int start) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, start);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;   // 顶点v已访问
        count++;        //与顶点start连通的顶点数加1
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {   //若返回值为true，表示顶点start与顶点w连通
        return marked[w];
    }

    public int count() {
        return count;  //与顶点start连通的顶点总数（包括其自身在内）
    }
}
