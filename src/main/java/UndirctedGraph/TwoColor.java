package UndirctedGraph;

public class TwoColor {
    private boolean[] marked;

    private boolean[] color;

    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];  //两连通结点颜色相反
                dfs(G, w);
            }
            else if (color[w] == color[v]) {  //w结点之前已经上过色且和父节点颜色不同，不可能成为二分图
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }
}
