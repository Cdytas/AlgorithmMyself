package UndirctedGraph;

public class CC {
    private boolean[] marked;
    private int[] id;  //连通分量标识符数组
    private int count;  //连通分量数

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        for (int s = 0; s < G.V(); s++) {   //遍历G的每个顶点，可能会产生新的连通分量
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
